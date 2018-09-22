package andrekabelim.br.projetomaxmilhas;

import android.util.Log;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import andrekabelim.br.projetomaxmilhas.ui.config.AppConfig;
import andrekabelim.br.projetomaxmilhas.ui.models.Data;
import andrekabelim.br.projetomaxmilhas.ui.models.ResponseData;
import andrekabelim.br.projetomaxmilhas.ui.support.http.GoibiboAPI;
import andrekabelim.br.projetomaxmilhas.ui.support.http.RetrofitConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class ApiGoibiboTest {

    @Test
    public void getTickets() {

        GoibiboAPI goibiboAPI = RetrofitConfig.getRetrofit().create(GoibiboAPI.class);

        final Map<String, String> filters = new HashMap<>();
        filters.put(AppConfig.Goibibo.PARAM_APP_ID, AppConfig.Goibibo.APP_ID);
        filters.put(AppConfig.Goibibo.PARAM_APP_KEY, AppConfig.Goibibo.KEY);
        filters.put(AppConfig.Goibibo.PARAM_FORMAT, AppConfig.Goibibo.FORMAT_JSON);
        filters.put(AppConfig.Goibibo.PARAM_SOURCE, "CNF");
        filters.put(AppConfig.Goibibo.PARAM_DESTINATION, "CRU");
        filters.put(AppConfig.Goibibo.PARAM_DATEOFDEPARTURE, "20180923");
        filters.put(AppConfig.Goibibo.PARAM_DATEOFARRIVAL, "20180924");
        filters.put(AppConfig.Goibibo.PARAM_ADULTS, "1");
        filters.put(AppConfig.Goibibo.PARAM_SEATING_CLASS, AppConfig.Goibibo.DEFAULT_SEATING_CLASS_VALUE);
        filters.put(AppConfig.Goibibo.PARAM_CHILDREN, AppConfig.Goibibo.DEFAULT_CHILDREN_VALUE);
        filters.put(AppConfig.Goibibo.PARAM_INFANTS, AppConfig.Goibibo.DEFAULT_INFANTS_VALUE);
        filters.put(AppConfig.Goibibo.PARAM_COUNTER, AppConfig.Goibibo.DEFAULT_COUNTER_VALUE);

        Call<ResponseData> call = goibiboAPI.getFlights(filters);

        call.enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                ResponseData responseData = response.body();
            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {
            }
        });
    }

    @Test
    public void forceIncorrectDestination() {

        GoibiboAPI goibiboAPI = RetrofitConfig.getRetrofit().create(GoibiboAPI.class);

        final Map<String, String> filters = new HashMap<>();
        filters.put(AppConfig.Goibibo.PARAM_APP_ID, AppConfig.Goibibo.APP_ID);
        filters.put(AppConfig.Goibibo.PARAM_APP_KEY, AppConfig.Goibibo.KEY);
        filters.put(AppConfig.Goibibo.PARAM_FORMAT, AppConfig.Goibibo.FORMAT_JSON);
        filters.put(AppConfig.Goibibo.PARAM_SOURCE, "CNF");
        filters.put(AppConfig.Goibibo.PARAM_DESTINATION, "CRUU");
        filters.put(AppConfig.Goibibo.PARAM_DATEOFDEPARTURE, "20180923");
        filters.put(AppConfig.Goibibo.PARAM_DATEOFARRIVAL, "");
        filters.put(AppConfig.Goibibo.PARAM_ADULTS, "1");
        filters.put(AppConfig.Goibibo.PARAM_SEATING_CLASS, AppConfig.Goibibo.DEFAULT_SEATING_CLASS_VALUE);
        filters.put(AppConfig.Goibibo.PARAM_CHILDREN, AppConfig.Goibibo.DEFAULT_CHILDREN_VALUE);
        filters.put(AppConfig.Goibibo.PARAM_INFANTS, AppConfig.Goibibo.DEFAULT_INFANTS_VALUE);
        filters.put(AppConfig.Goibibo.PARAM_COUNTER, AppConfig.Goibibo.DEFAULT_COUNTER_VALUE);

        Call<ResponseData> call = goibiboAPI.getFlights(filters);

        call.enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                ResponseData responseData = response.body();
            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {
            }
        });
    }
}
