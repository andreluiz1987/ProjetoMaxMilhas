package andrekabelim.br.projetomaxmilhas.ui.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data implements Parcelable {
    @SerializedName("returnflights")
    @Expose
    private List<Object> returnflights = null;
    @SerializedName("onwardflights")
    @Expose
    private List<OnWardFlight> onwardflights = null;

    protected Data(Parcel in) {
    }

    public static final Creator<Data> CREATOR = new Creator<Data>() {
        @Override
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }
}
