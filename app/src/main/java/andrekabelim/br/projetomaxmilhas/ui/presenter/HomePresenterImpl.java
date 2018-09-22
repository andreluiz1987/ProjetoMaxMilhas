package andrekabelim.br.projetomaxmilhas.ui.presenter;

import android.util.Log;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import andrekabelim.br.projetomaxmilhas.R;
import andrekabelim.br.projetomaxmilhas.ui.config.AppConfig;
import andrekabelim.br.projetomaxmilhas.ui.helpers.DateHelpers;
import andrekabelim.br.projetomaxmilhas.ui.models.Data;
import andrekabelim.br.projetomaxmilhas.ui.models.OnWardFlight;
import andrekabelim.br.projetomaxmilhas.ui.models.ResponseData;
import andrekabelim.br.projetomaxmilhas.ui.support.http.GoibiboAPI;
import andrekabelim.br.projetomaxmilhas.ui.support.http.RetrofitConfig;
import andrekabelim.br.projetomaxmilhas.ui.view.HomeView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePresenterImpl implements HomePresenter {

    private HomeView homeView;

    public HomePresenterImpl(HomeView homeView) {
        this.homeView = homeView;
    }

    @Override
    public void onSearchClick(String source, final String dest, String dateFrom, String dateReturn, String numAdults) {

        try {

            String strError = validateData(source, dest, dateFrom, dateReturn, numAdults);

            if (!strError.isEmpty()) {
                homeView.showAlert(strError);
                return;
            }

            homeView.showLoading();

            dateFrom = DateHelpers.formatDateToGiobibo(dateFrom);
            dateReturn = (dateReturn.length() > 0) ? DateHelpers.formatDateToGiobibo(dateReturn) : dateReturn;

            GoibiboAPI goibiboAPI = RetrofitConfig.getRetrofit().create(GoibiboAPI.class);

            final Map<String, String> filters = new HashMap<>();
            filters.put(AppConfig.Goibibo.PARAM_APP_ID, AppConfig.Goibibo.APP_ID);
            filters.put(AppConfig.Goibibo.PARAM_APP_KEY, AppConfig.Goibibo.KEY);
            filters.put(AppConfig.Goibibo.PARAM_FORMAT, AppConfig.Goibibo.FORMAT_JSON);
            filters.put(AppConfig.Goibibo.PARAM_SOURCE, source);
            filters.put(AppConfig.Goibibo.PARAM_DESTINATION, dest);
            filters.put(AppConfig.Goibibo.PARAM_DATEOFDEPARTURE, dateFrom);

            if (dateReturn.length() > 0)
                filters.put(AppConfig.Goibibo.PARAM_DATEOFARRIVAL, dateReturn);

            filters.put(AppConfig.Goibibo.PARAM_ADULTS, numAdults);
            filters.put(AppConfig.Goibibo.PARAM_SEATING_CLASS, AppConfig.Goibibo.DEFAULT_SEATING_CLASS_VALUE);
            filters.put(AppConfig.Goibibo.PARAM_CHILDREN, AppConfig.Goibibo.DEFAULT_CHILDREN_VALUE);
            filters.put(AppConfig.Goibibo.PARAM_INFANTS, AppConfig.Goibibo.DEFAULT_INFANTS_VALUE);
            filters.put(AppConfig.Goibibo.PARAM_COUNTER, AppConfig.Goibibo.DEFAULT_COUNTER_VALUE);

            Call<ResponseData> call = goibiboAPI.getFlights(filters);

            call.enqueue(new Callback<ResponseData>() {
                @Override
                public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {

                    homeView.hideLoading();

                    ResponseData data = response.body();

                    data.setData(prepareFligths(data, filters.get(AppConfig.Goibibo.PARAM_SOURCE), filters.get(AppConfig.Goibibo.PARAM_DESTINATION)));

                    if (data.getData().getOnwardflights().size() == 0) {
                        homeView.showAlert("Não existem passagens para a pesquisa realizada.");
                    } else {
                        homeView.navigateToFligthPage(data.getData().getOnwardflights());
                    }
                }

                @Override
                public void onFailure(Call<ResponseData> call, Throwable t) {
                    homeView.hideLoading();
                    Log.d("HomePresenterImpl", t.getMessage());
                    homeView.showAlert("Não foi possível completar a solicitação.");
                }
            });

        } catch (Exception ex) {
            ex.printStackTrace();
            homeView.hideLoading();
        }
    }

    private Data prepareFligths(ResponseData data, String origin, String dest) {

        Data result = new Data();

        for (OnWardFlight item : data.getData().getOnwardflights()) {
            if(item.getOrigin().equals(origin) && item.getDestination().equals(dest)){
                result.getOnwardflights().add(item);
            }
        }

        return result;
    }

    private String validateData(String source, String dest, String dateFrom, String dateReturn, String numAdults) {

        if (source.isEmpty()) {
            return "Informe o aeroporto de origem.";
        } else if (dest.isEmpty()) {
            return "Informe o aeroporto de destino.";
        } else if (dateFrom.isEmpty()) {
            return "Informe a data de partida.";
        } else if (numAdults.isEmpty()) {
            return "Informe o número de adultos.";
        } else {

            if (source.equals(dest)) {
                return "O aeroporto de origine não podem ser iguais.";
            }

            if (!dateFrom.isEmpty() && !dateReturn.isEmpty()) {

                if (Date.valueOf(dateFrom).after(Date.valueOf(dateReturn))) {
                    return "A data de retorno deve ser superior a data de partida.";
                }
            }

            if (numAdults.equals("0"))
                return "O número de adultos deve ser superior a 0";
        }
        return "";
    }
}
