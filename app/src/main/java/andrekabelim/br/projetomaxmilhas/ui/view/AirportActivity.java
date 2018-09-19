package andrekabelim.br.projetomaxmilhas.ui.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.SearchView;

import andrekabelim.br.projetomaxmilhas.R;
import andrekabelim.br.projetomaxmilhas.ui.adapters.AirportAdapter;
import andrekabelim.br.projetomaxmilhas.ui.helpers.CodeIATA;
import butterknife.BindView;

public class AirportActivity extends AppCompatActivity {

    @BindView(R.id.sw_airport)
    SearchView filterAirport;

    @BindView(R.id.rc_airports)
    RecyclerView rcwAirports;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airport);

        rcwAirports.setLayoutManager(new LinearLayoutManager(this));
        rcwAirports.setItemAnimator(new DefaultItemAnimator());

        final AirportAdapter adapter = new AirportAdapter(this, CodeIATA.getListIATA());
        rcwAirports.setAdapter(adapter);

        //SEARCH
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
    }
}
