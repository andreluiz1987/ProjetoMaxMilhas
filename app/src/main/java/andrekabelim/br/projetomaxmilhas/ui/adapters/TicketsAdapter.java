package andrekabelim.br.projetomaxmilhas.ui.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import andrekabelim.br.projetomaxmilhas.R;
import andrekabelim.br.projetomaxmilhas.ui.helpers.DateHelpers;
import andrekabelim.br.projetomaxmilhas.ui.models.Data;

public class TicketsAdapter extends RecyclerView.Adapter<TicketsAdapter.TicketsViewHolder> {

    Context context;
    Data dataTicket;

    public TicketsAdapter(Context context, Data dataTicket) {
        this.context = context;
    }

    @NonNull
    @Override
    public TicketsAdapter.TicketsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fligths_item, null);
        TicketsAdapter.TicketsViewHolder holder = new TicketsViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TicketsAdapter.TicketsViewHolder holder, int position) {

        holder.txtCompanyOnWard.setText(dataTicket.getOnwardflights().get(position).getAirline());
        holder.txtNumberFligthOnWard.setText(dataTicket.getOnwardflights().get(position).getFlightcode());
        holder.txtTimeBoardingOnWard.setText(dataTicket.getOnwardflights().get(position).getDeptime());
        holder.txtIATABoardingOnWard.setText(dataTicket.getOnwardflights().get(position).getOrigin());
        holder.txtTotalTimeBoardingOnWard.setText(dataTicket.getOnwardflights().get(position).getDuration());
        //holder.txtTypeOnWard.setText(dataTicket.getOnwardflights().get(position).());
        holder.txtTimeLadingOnWard.setText(dataTicket.getOnwardflights().get(position).getArrtime());
        holder.txtIATALadinggOnWard.setText(dataTicket.getOnwardflights().get(position).getDestination());
        holder.txtDateFrom.setText(DateHelpers.formatDateToText(dataTicket.getOnwardflights().get(position).getDepartureTime()));

        if (dataTicket.getOnwardflights().get(position).getReturnfl().size() > 0) {
            holder.txtCompanyReturn.setText(dataTicket.getOnwardflights().get(position).getAirline());
            holder.txtNumberFligthReturn.setText(dataTicket.getOnwardflights().get(position).getReturnfl().get(0).getFlightcode());
            holder.txtTimeBoardingReturn.setText(dataTicket.getOnwardflights().get(position).getReturnfl().get(0).getDeptime());
            holder.txtIATABoardingReturn.setText(dataTicket.getOnwardflights().get(position).getReturnfl().get(0).getOrigin());
            holder.txtTotalTimeBoardingReturn.setText(dataTicket.getOnwardflights().get(position).getReturnfl().get(0).getDuration());
            //holder.txtTypeReturnsetText(dataTicket.getOnwardflights().get(position).());
            holder.txtTimeLadingReturn.setText(dataTicket.getOnwardflights().get(position).getReturnfl().get(0).getArrtime());
            holder.txtIATALadinggReturn.setText(dataTicket.getOnwardflights().get(position).getReturnfl().get(0).getDestination());
            holder.txtDateReturn.setText(DateHelpers.formatDateToText(dataTicket.getOnwardflights().get(position).getReturnfl().get(0).getDepartureTime()));

        }
        holder.btnBuy.setText(this.context.getString(R.string.buy_ticket)
                .replace("[COST]", dataTicket.getOnwardflights().get(position).getFare().getTotalfare().toString()));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class TicketsViewHolder extends RecyclerView.ViewHolder {

        TextView txtCompanyOnWard,
                txtNumberFligthOnWard,
                txtTimeBoardingOnWard,
                txtIATABoardingOnWard,
                txtTotalTimeBoardingOnWard,
                txtTypeOnWard,
                txtTimeLadingOnWard,
                txtIATALadinggOnWard,
                txtDateFrom,
                txtCompanyReturn,
                txtNumberFligthReturn,
                txtTimeBoardingReturn,
                txtIATABoardingReturn,
                txtTotalTimeBoardingReturn,
                txtTypeReturn,
                txtTimeLadingReturn,
                txtIATALadinggReturn,
                txtDateReturn;

        Button btnBuy;

        public TicketsViewHolder(View itemView) {
            super(itemView);

            this.txtCompanyOnWard = itemView.findViewById(R.id.txt_company_name_onward);
            this.txtNumberFligthOnWard = itemView.findViewById(R.id.txt_fligth_number_onward);
            this.txtTimeBoardingOnWard = itemView.findViewById(R.id.txt_time_boarding_onward);
            this.txtIATABoardingOnWard = itemView.findViewById(R.id.txt_iata_boarding_onward);
            this.txtTotalTimeBoardingOnWard = itemView.findViewById(R.id.txt_total_time_onward);
            this.txtTypeOnWard = itemView.findViewById(R.id.txt_type_onward);
            this.txtTimeLadingOnWard = itemView.findViewById(R.id.txt_time_lading_onward);
            this.txtIATALadinggOnWard = itemView.findViewById(R.id.txt_iata_lading_onward);
            this.txtDateFrom = itemView.findViewById(R.id.txt_date_from);

            this.txtCompanyReturn = itemView.findViewById(R.id.txt_company_name_return);
            this.txtNumberFligthReturn = itemView.findViewById(R.id.txt_fligth_number_return);
            this.txtTimeBoardingReturn = itemView.findViewById(R.id.txt_time_boarding_return);
            this.txtIATABoardingReturn = itemView.findViewById(R.id.txt_iata_boarding_return);
            this.txtTotalTimeBoardingReturn = itemView.findViewById(R.id.txt_total_time_return);
            this.txtTypeReturn = itemView.findViewById(R.id.txt_type_return);
            this.txtTimeLadingReturn = itemView.findViewById(R.id.txt_time_lading_return);
            this.txtIATALadinggReturn = itemView.findViewById(R.id.txt_iata_lading_return);
            this.txtDateReturn = itemView.findViewById(R.id.txt_date_return);

            this.btnBuy = itemView.findViewById(R.id.btn_buy_ticket);
        }
    }
}
