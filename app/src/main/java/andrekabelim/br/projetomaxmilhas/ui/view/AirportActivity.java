package andrekabelim.br.projetomaxmilhas.ui.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.RelativeLayout;

import andrekabelim.br.projetomaxmilhas.R;
import andrekabelim.br.projetomaxmilhas.ui.adapters.AirportAdapter;
import andrekabelim.br.projetomaxmilhas.ui.config.IntentsConfig;
import andrekabelim.br.projetomaxmilhas.ui.helpers.CodeIATA;
import andrekabelim.br.projetomaxmilhas.ui.models.Airport;
import andrekabelim.br.projetomaxmilhas.ui.models.ConstantsFligth;
import butterknife.BindView;
import butterknife.ButterKnife;

public class AirportActivity extends AppCompatActivity {

    @BindView(R.id.sw_airport)
    SearchView filterAirport;

    @BindView(R.id.rc_airports)
    RecyclerView rcwAirports;

    private String IATAFlag = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airport);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ButterKnife.bind(this);

        rcwAirports.setLayoutManager(new LinearLayoutManager(this));
        rcwAirports.setItemAnimator(new DefaultItemAnimator());

        final AirportAdapter adapter = new AirportAdapter(CodeIATA.getListIATA());
        adapter.setItemClickListener(clickListener);

        rcwAirports.setAdapter(adapter);

        filterAirport.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                adapter.getFilter().filter(query);
                return false;
            }
        });

        getIntentData();

        forceShowKeyboard();
    }

    private void getIntentData(){
        if(getIntent().getStringExtra(ConstantsFligth.IATA_FLAG_KEY) != null){
            IATAFlag = getIntent().getStringExtra(ConstantsFligth.IATA_FLAG_KEY);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void forceShowKeyboard() {
        filterAirport.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.showSoftInput(filterAirport, InputMethodManager.SHOW_FORCED);
    }

    AirportAdapter.OnItemClickListener clickListener = new AirportAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {

            Airport airport = (Airport) ((RelativeLayout) view).getChildAt(0).getTag();

            Intent intent = new Intent(AirportActivity.this, HomeActivity.class);

            intent.putExtras(getIntent().getExtras());
            intent.putExtra(IntentsConfig.AIRPORT_AITA_KEY, airport);
            intent.putExtra(ConstantsFligth.IATA_FLAG_KEY, IATAFlag);
            startActivity(intent);
            finish();
        }
    };
}
