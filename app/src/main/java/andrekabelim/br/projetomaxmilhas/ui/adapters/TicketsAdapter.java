package andrekabelim.br.projetomaxmilhas.ui.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;

import andrekabelim.br.projetomaxmilhas.R;
import andrekabelim.br.projetomaxmilhas.ui.helpers.DateHelpers;
import andrekabelim.br.projetomaxmilhas.ui.helpers.NumberHelpers;
import andrekabelim.br.projetomaxmilhas.ui.models.Data;
import andrekabelim.br.projetomaxmilhas.ui.models.OnWardFlight;

public class TicketsAdapter extends RecyclerView.Adapter<TicketsAdapter.TicketsViewHolder> {

    Context context;
    List<OnWardFlight> dataTicket;

    public TicketsAdapter(Context context, List<OnWardFlight> dataTicket) {
        this.context = context;
        this.dataTicket = dataTicket;
    }

    @NonNull
    @Override
    public TicketsAdapter.TicketsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fligths_item, parent, false);
        TicketsAdapter.TicketsViewHolder holder = new TicketsViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TicketsAdapter.TicketsViewHolder holder, int position) {

        holder.txtCompanyOnWard.setText(dataTicket.get(position).getAirline().split(" ")[0]);
        holder.txtNumberFligthOnWard.setText(dataTicket.get(position).getFlightno());
        holder.txtTimeBoardingOnWard.setText(dataTicket.get(position).getDeptime());
        holder.txtIATABoardingOnWard.setText(dataTicket.get(position).getOrigin());
        holder.txtTotalTimeBoardingOnWard.setText(dataTicket.get(position).getDuration());
        //holder.txtTypeOnWard.setText(dataTicket.getOnwardflights().get(position).());
        holder.txtTimeLadingOnWard.setText(dataTicket.get(position).getArrtime());
        holder.txtIATALadinggOnWard.setText(dataTicket.get(position).getDestination());
        holder.txtDateFrom.setText(DateHelpers.formatDateToText(dataTicket.get(position).getDepdate()));

        if (dataTicket.get(position).getReturnfl() != null && dataTicket.get(position).getReturnfl().size() > 0) {
            holder.pnlTicketReturn.setVisibility(View.VISIBLE);
            holder.txtCompanyReturn.setText(dataTicket.get(position).getAirline().split(" ")[0]);
            holder.txtNumberFligthReturn.setText(dataTicket.get(position).getReturnfl().get(0).getFlightno());
            holder.txtTimeBoardingReturn.setText(dataTicket.get(position).getReturnfl().get(0).getDeptime());
            holder.txtIATABoardingReturn.setText(dataTicket.get(position).getReturnfl().get(0).getOrigin());
            holder.txtTotalTimeBoardingReturn.setText(dataTicket.get(position).getReturnfl().get(0).getDuration());
            //holder.txtTypeReturnsetText(dataTicket.getOnwardflights().get(position).());
            holder.txtTimeLadingReturn.setText(dataTicket.get(position).getReturnfl().get(0).getArrtime());
            holder.txtIATALadinggReturn.setText(dataTicket.get(position).getReturnfl().get(0).getDestination());
            holder.txtDateReturn.setText(DateHelpers.formatDateToText(dataTicket.get(position).getReturnfl().get(0).getArrdate()));
        } else {
            holder.pnlTicketReturn.setVisibility(View.GONE);
        }

       if( dataTicket.get(position).getFare() != null){
           holder.btnBuy.setText(this.context.getString(R.string.buy_ticket)
                   .replace("[COST]", NumberHelpers.formatToCurrentLocate(dataTicket.get(position).getFare().getTotalfare())));
       }else {

           holder.btnBuy.setText(this.context.getString(R.string.buy_ticket)
                   .replace("[COST]", ""));
       }
    }

    @Override
    public int getItemCount() {
        return dataTicket.size();
    }

    class TicketsViewHolder extends RecyclerView.ViewHolder {

        LinearLayout pnlTicketReturn;
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

            this.pnlTicketReturn = itemView.findViewById(R.id.pnl_ticket_return);
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
