package andrekabelim.br.projetomaxmilhas.ui.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import andrekabelim.br.projetomaxmilhas.R;
import andrekabelim.br.projetomaxmilhas.ui.adapters.Filters.CustomFilter;
import andrekabelim.br.projetomaxmilhas.ui.models.Airport;
import andrekabelim.br.projetomaxmilhas.ui.view.interfaces.ItemClickListener;

public class AirportAdapter extends RecyclerView.Adapter<AirportAdapter.AirportHolder> implements Filterable {

    private Context context;
    public ArrayList<Airport> airports, filterList;
    private CustomFilter filter;

    public AirportAdapter(Context context, ArrayList<Airport> airports) {
        this.context = context;
        this.airports = airports;
        this.filterList = airports;
    }

    @Override
    public AirportHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.airport_item, null);

        AirportHolder holder = new AirportHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(AirportHolder holder, int position) {

        holder.txtAirportName.setText(airports.get(position).getName());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //Snackbar.make(v, players.get(pos).getName(), Snackbar.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return airports.size();
    }

    @Override
    public Filter getFilter() {
        if (filter == null) {
            filter = new CustomFilter(filterList, this);
        }

        return filter;
    }

    class AirportHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView txtAirportName;
        ItemClickListener itemClickListener;

        public AirportHolder(View itemView) {
            super(itemView);
            this.txtAirportName = itemView.findViewById(R.id.txt_airport_name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            this.itemClickListener.onItemClick(view, getLayoutPosition());
        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }
    }
}
