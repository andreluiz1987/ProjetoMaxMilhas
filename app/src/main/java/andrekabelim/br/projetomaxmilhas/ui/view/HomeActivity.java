package andrekabelim.br.projetomaxmilhas.ui.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.util.HashMap;
import java.util.Map;

import andrekabelim.br.projetomaxmilhas.R;
import andrekabelim.br.projetomaxmilhas.ui.adapters.AirportAdapter;
import andrekabelim.br.projetomaxmilhas.ui.config.AppConfig;
import andrekabelim.br.projetomaxmilhas.ui.helpers.CodeIATA;
import andrekabelim.br.projetomaxmilhas.ui.models.Airport;
import andrekabelim.br.projetomaxmilhas.ui.models.Data;
import andrekabelim.br.projetomaxmilhas.ui.models.ResponseData;
import andrekabelim.br.projetomaxmilhas.ui.support.http.GoibiboAPI;
import andrekabelim.br.projetomaxmilhas.ui.support.http.RetrofitConfig;
import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.btn_find_tickets)
    Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        AppCompatAutoCompleteTextView autoTextViewCustom = findViewById(R.id.acIATA);
//
//        AirportAdapter airportAdapter = new AirportAdapter(this, R.layout.autocomplete_item, CodeIATA.getIATACodes());
//
//        autoTextViewCustom.setThreshold(1);
//        autoTextViewCustom.setAdapter(airportAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                GoibiboAPI goibiboAPI = RetrofitConfig.getRetrofit().create(GoibiboAPI.class);

                Map<String, String> filters = new HashMap<>();
                filters.put(AppConfig.Goibibo.PARAM_APP_ID, AppConfig.Goibibo.APP_ID);
                filters.put(AppConfig.Goibibo.PARAM_APP_ID,AppConfig.Goibibo.KEY);
                filters.put(AppConfig.Goibibo.PARAM_FORMAT, AppConfig.Goibibo.FORMAT_JSON);
                filters.put(AppConfig.Goibibo.PARAM_SOURCE, "CNF");
                filters.put(AppConfig.Goibibo.PARAM_DESTINATION, "VIX");
                filters.put(AppConfig.Goibibo.PARAM_DATEOFDEPARTURE, "20180920");
                filters.put(AppConfig.Goibibo.PARAM_DATEOFARRIVAL, "20181019");
                filters.put(AppConfig.Goibibo.PARAM_ADULTS, "1");
                filters.put(AppConfig.Goibibo.PARAM_SEATING_CLASS, AppConfig.Goibibo.DEFAULT_SEATING_CLASS_VALUE);
                filters.put(AppConfig.Goibibo.PARAM_CHILDREN, AppConfig.Goibibo.DEFAULT_CHILDREN_VALUE);
                filters.put(AppConfig.Goibibo.PARAM_INFANTS, AppConfig.Goibibo.DEFAULT_INFANTS_VALUE);
                filters.put(AppConfig.Goibibo.PARAM_COUNTER, AppConfig.Goibibo.DEFAULT_COUNTER_VALUE);

                Call<ResponseData> call = goibiboAPI.getFlights(filters);

                call.enqueue(new Callback<ResponseData>() {
                    @Override
                    public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                        Log.d("HOME", response.body().toString());
                        ResponseData data = response.body();
                    }

                    @Override
                    public void onFailure(Call<ResponseData> call, Throwable t) {
                        Log.d("HOME", t.getMessage());
                    }
                });
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
