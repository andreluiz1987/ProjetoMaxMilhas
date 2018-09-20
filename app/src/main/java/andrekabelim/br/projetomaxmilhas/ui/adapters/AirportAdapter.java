package andrekabelim.br.projetomaxmilhas.ui.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import andrekabelim.br.projetomaxmilhas.R;
import andrekabelim.br.projetomaxmilhas.ui.adapters.Filters.CustomFilter;
import andrekabelim.br.projetomaxmilhas.ui.models.Airport;

public class AirportAdapter extends RecyclerView.Adapter<AirportAdapter.AirportHolder> implements Filterable {

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    private OnItemClickListener clickListener;
    public ArrayList<Airport> airports, filterList;
    private CustomFilter filter;

    public AirportAdapter(ArrayList<Airport> airports) {
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
        holder.txtAirportName.setTag(airports.get(position));
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

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    public class AirportHolder extends RecyclerView.ViewHolder {

        RelativeLayout relativeLayout;
        TextView txtAirportName;

        public AirportHolder(View itemView) {
            super(itemView);
            this.relativeLayout = itemView.findViewById(R.id.lyt_airport_item);
            this.txtAirportName = itemView.findViewById(R.id.txt_airport_name);

            this.relativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (clickListener != null) {
                        clickListener.onItemClick(view, getAdapterPosition());
                    }
                }
            });
        }
    }
}
