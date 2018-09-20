package andrekabelim.br.projetomaxmilhas.ui.view;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import andrekabelim.br.projetomaxmilhas.R;
import andrekabelim.br.projetomaxmilhas.ui.config.AppConfig;
import andrekabelim.br.projetomaxmilhas.ui.config.IntentsConfig;
import andrekabelim.br.projetomaxmilhas.ui.models.Airport;
import andrekabelim.br.projetomaxmilhas.ui.models.ResponseData;
import andrekabelim.br.projetomaxmilhas.ui.presenter.HomePresenter;
import andrekabelim.br.projetomaxmilhas.ui.presenter.HomePresenterImpl;
import andrekabelim.br.projetomaxmilhas.ui.support.http.GoibiboAPI;
import andrekabelim.br.projetomaxmilhas.ui.support.http.RetrofitConfig;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity implements HomeView {

    @BindView(R.id.btn_find_tickets)
    Button btnSearch;

    @BindView(R.id.edt_date_from)
    TextView txtDateFrom;

    @BindView(R.id.edt_date_to)
    TextView txtDateReturn;

    @BindView(R.id.edt_adults)
    EditText edtAdults;

    @BindView(R.id.edt_source_iata)
    TextView txtSourceIATA;

    @BindView(R.id.edt_destination_iata)
    TextView txtDestinationIATA;

    @BindView(R.id.pnl_loading_search)
    LinearLayout pnlLoading;

    HomePresenter homePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        homePresenter = new HomePresenterImpl(this);

        getIntents();
    }

    private void getIntents() {
        Intent intent = getIntent();
        if (intent.getBundleExtra(IntentsConfig.AIRPORT_AITA) != null) {
            Airport airport = (Airport) intent.getSerializableExtra(IntentsConfig.AIRPORT_AITA);
            txtSourceIATA.setText(airport.getCode());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.btn_find_tickets)
    public void btnSearchClicked(View view) {

        homePresenter.onSearchClick(txtSourceIATA.getText().toString(),
                txtDestinationIATA.getText().toString(),
                txtDateFrom.getText().toString(),
                txtDateReturn.getText().toString(),
                edtAdults.getText().toString());
    }

    @OnClick(R.id.edt_source_iata)
    public void txtSourceIATAClicked(View view) {
        Intent intent = new Intent(this, AirportActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.edt_destination_iata)
    public void txtDestinationIATAClicked(View view) {
        Intent intent = new Intent(this, AirportActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.edt_date_from)
    public void edtDateOnWardClicked(View view) {
        showDatePicker((TextView) view);
    }

    @OnClick(R.id.edt_date_to)
    public void edtDateReturn(View view) {
        showDatePicker((TextView) view);
    }

    private void showDatePicker(final TextView editText) {

        Calendar calendar = Calendar.getInstance();

        DatePickerDialog datePickerDialog = new DatePickerDialog(HomeActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        Calendar newDate = Calendar.getInstance();
                        newDate.set(year, monthOfYear, dayOfMonth);
                        editText.setText(dateFormatter.format(newDate.getTime()));
                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        datePickerDialog.show();
    }

    @Override
    public void showDialog() {
        pnlLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideDialog() {
        pnlLoading.setVisibility(View.INVISIBLE);
    }

    @Override
    public void navigateToFligthPage() {
        Intent intent = new Intent(this, FligthActivity.class);
        //startActivity(intent);
    }

    @Override
    public void showAlert(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
