package andrekabelim.br.projetomaxmilhas.ui.models;

import java.util.Date;

public class Filters {

    class SearchTickets {
        private String sourceIATA;
        private String destinationIATA;
        private Date dateOnWard;
        private Date dateReturn;
        private int numAdults;

        public SearchTickets(String sourceIATA, String destinationIATA, Date dateOnWard, Date dateReturn, int numAdults) {
            this.sourceIATA = sourceIATA;
            this.destinationIATA = destinationIATA;
            this.dateOnWard = dateOnWard;
            this.dateReturn = dateReturn;
            this.numAdults = numAdults;
        }

        public String getSourceIATA() {
            return sourceIATA;
        }

        public void setSourceIATA(String sourceIATA) {
            this.sourceIATA = sourceIATA;
        }

        public String getDestinationIATA() {
            return destinationIATA;
        }

        public void setDestinationIATA(String destinationIATA) {
            this.destinationIATA = destinationIATA;
        }

        public Date getDateOnWard() {
            return dateOnWard;
        }

        public void setDateOnWard(Date dateOnWard) {
            this.dateOnWard = dateOnWard;
        }

        public Date getDateReturn() {
            return dateReturn;
        }

        public void setDateReturn(Date dateReturn) {
            this.dateReturn = dateReturn;
        }

        public int numAdults() {
            return numAdults;
        }

        public void setNumAdults(int numAdults) {
            this.numAdults = numAdults;
        }
    }
}
