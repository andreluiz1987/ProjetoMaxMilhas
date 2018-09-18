package andrekabelim.br.projetomaxmilhas.ui.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {
    @SerializedName("returnflights")
    @Expose
    private List<Object> returnflights = null;
    @SerializedName("onwardflights")
    @Expose
    private List<OnWardFlight> onwardflights = null;

    public List<Object> getReturnflights() {
        return returnflights;
    }

    public void setReturnflights(List<Object> returnflights) {
        this.returnflights = returnflights;
    }

    public List<OnWardFlight> getOnwardflights() {
        return onwardflights;
    }

    public void setOnwardflights(List<OnWardFlight> onwardflights) {
        this.onwardflights = onwardflights;
    }
}
