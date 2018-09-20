package andrekabelim.br.projetomaxmilhas.ui.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import andrekabelim.br.projetomaxmilhas.R;
import andrekabelim.br.projetomaxmilhas.ui.adapters.AirportAdapter;
import andrekabelim.br.projetomaxmilhas.ui.adapters.TicketsAdapter;
import andrekabelim.br.projetomaxmilhas.ui.config.IntentsConfig;
import andrekabelim.br.projetomaxmilhas.ui.helpers.CodeIATA;
import andrekabelim.br.projetomaxmilhas.ui.models.Airport;
import andrekabelim.br.projetomaxmilhas.ui.models.Data;
import butterknife.BindView;
import butterknife.ButterKnife;

public class FligthActivity extends AppCompatActivity {


    @BindView(R.id.rvw_fligths)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fligths);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ButterKnife.bind(this);
    }

    private void loadTickets(){

        Intent intent = getIntent();

        Data dataFlight = intent.getParcelableExtra(IntentsConfig.DATA_FLIGTH_KEY);
        
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        TicketsAdapter adapter = new TicketsAdapter();
//        recyclerView.setAdapter(adapter);
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
}
