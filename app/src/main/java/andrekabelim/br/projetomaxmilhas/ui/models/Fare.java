package andrekabelim.br.projetomaxmilhas.ui.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fare implements Parcelable{

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

    protected Fare(Parcel in) {
        if (in.readByte() == 0) {
            totalfare = null;
        } else {
            totalfare = in.readInt();
        }
        if (in.readByte() == 0) {
            totalbasefare = null;
        } else {
            totalbasefare = in.readInt();
        }
        if (in.readByte() == 0) {
            adultbasefare = null;
        } else {
            adultbasefare = in.readInt();
        }
        if (in.readByte() == 0) {
            grossamount = null;
        } else {
            grossamount = in.readInt();
        }
        if (in.readByte() == 0) {
            totalsurcharge = null;
        } else {
            totalsurcharge = in.readInt();
        }
        if (in.readByte() == 0) {
            adultchangepenalty1 = null;
        } else {
            adultchangepenalty1 = in.readInt();
        }
        if (in.readByte() == 0) {
            adulttotalfare = null;
        } else {
            adulttotalfare = in.readInt();
        }
        if (in.readByte() == 0) {
            adultcancelpenalty1 = null;
        } else {
            adultcancelpenalty1 = in.readInt();
        }
        totalcommission = in.readString();
    }

    public static final Creator<Fare> CREATOR = new Creator<Fare>() {
        @Override
        public Fare createFromParcel(Parcel in) {
            return new Fare(in);
        }

        @Override
        public Fare[] newArray(int size) {
            return new Fare[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        if (totalfare == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(totalfare);
        }
        if (totalbasefare == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(totalbasefare);
        }
        if (adultbasefare == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(adultbasefare);
        }
        if (grossamount == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(grossamount);
        }
        if (totalsurcharge == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(totalsurcharge);
        }
        if (adultchangepenalty1 == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(adultchangepenalty1);
        }
        if (adulttotalfare == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(adulttotalfare);
        }
        if (adultcancelpenalty1 == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(adultcancelpenalty1);
        }
        parcel.writeString(totalcommission);
    }
}
