package andrekabelim.br.projetomaxmilhas.ui.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fare {

    @SerializedName("totalfare")
    @Expose
    private Integer totalfare;
    @SerializedName("totalbasefare")
    @Expose
    private Integer totalbasefare;
    @SerializedName("adultbasefare")
    @Expose
    private Integer adultbasefare;
    @SerializedName("grossamount")
    @Expose
    private Integer grossamount;
    @SerializedName("totalsurcharge")
    @Expose
    private Integer totalsurcharge;
    @SerializedName("adultchangepenalty_1")
    @Expose
    private Integer adultchangepenalty1;
    @SerializedName("adulttotalfare")
    @Expose
    private Integer adulttotalfare;
    @SerializedName("adultcancelpenalty_1")
    @Expose
    private Integer adultcancelpenalty1;
    @SerializedName("totalcommission")
    @Expose
    private String totalcommission;

    public Integer getTotalfare() {
        return totalfare;
    }

    public void setTotalfare(Integer totalfare) {
        this.totalfare = totalfare;
    }

    public Integer getTotalbasefare() {
        return totalbasefare;
    }

    public void setTotalbasefare(Integer totalbasefare) {
        this.totalbasefare = totalbasefare;
    }

    public Integer getAdultbasefare() {
        return adultbasefare;
    }

    public void setAdultbasefare(Integer adultbasefare) {
        this.adultbasefare = adultbasefare;
    }

    public Integer getGrossamount() {
        return grossamount;
    }

    public void setGrossamount(Integer grossamount) {
        this.grossamount = grossamount;
    }

    public Integer getTotalsurcharge() {
        return totalsurcharge;
    }

    public void setTotalsurcharge(Integer totalsurcharge) {
        this.totalsurcharge = totalsurcharge;
    }

    public Integer getAdultchangepenalty1() {
        return adultchangepenalty1;
    }

    public void setAdultchangepenalty1(Integer adultchangepenalty1) {
        this.adultchangepenalty1 = adultchangepenalty1;
    }

    public Integer getAdulttotalfare() {
        return adulttotalfare;
    }

    public void setAdulttotalfare(Integer adulttotalfare) {
        this.adulttotalfare = adulttotalfare;
    }

    public Integer getAdultcancelpenalty1() {
        return adultcancelpenalty1;
    }

    public void setAdultcancelpenalty1(Integer adultcancelpenalty1) {
        this.adultcancelpenalty1 = adultcancelpenalty1;
    }

    public String getTotalcommission() {
        return totalcommission;
    }

    public void setTotalcommission(String totalcommission) {
        this.totalcommission = totalcommission;
    }

}
