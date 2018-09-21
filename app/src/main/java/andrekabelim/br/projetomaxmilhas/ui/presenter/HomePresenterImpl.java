package andrekabelim.br.projetomaxmilhas.ui.presenter;

import android.util.Log;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import andrekabelim.br.projetomaxmilhas.R;
import andrekabelim.br.projetomaxmilhas.ui.config.AppConfig;
import andrekabelim.br.projetomaxmilhas.ui.helpers.DateHelpers;
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
    public void onSearchClick(String source, String dest, String dateFrom, String dateReturn, String numAdults) {

        homeView.showLoading();

        try {

            String strError = validateData(source, dest, dateFrom, dateReturn, numAdults);

            if (!strError.isEmpty()) {
                homeView.showAlert(strError);
                return;
            }

            dateFrom = DateHelpers.formatDateToGiobibo(dateFrom);
            dateReturn = (dateReturn.length() > 0) ? DateHelpers.formatDateToGiobibo(dateReturn) : dateReturn;

            GoibiboAPI goibiboAPI = RetrofitConfig.getRetrofit().create(GoibiboAPI.class);

            Map<String, String> filters = new HashMap<>();
            filters.put(AppConfig.Goibibo.PARAM_APP_ID, AppConfig.Goibibo.APP_ID);
            filters.put(AppConfig.Goibibo.PARAM_APP_ID, AppConfig.Goibibo.KEY);
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

                    if (data.getData().getOnwardflights().size() == 0 || data.getData().getReturnflights().size() == 0) {
                        homeView.showAlert("Não existem passagens para a pesquisa realizada.");
                    } else {
                        homeView.navigateToFligthPage(data.getData());
                    }
                }

                @Override
                public void onFailure(Call<ResponseData> call, Throwable t) {
                    Log.d("HomePresenterImpl", t.getMessage());
                }
            });

        } catch (Exception ex) {
            ex.printStackTrace();
            homeView.hideLoading();
        }
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
