package andrekabelim.br.projetomaxmilhas.ui.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Data implements Parcelable {

    @SerializedName("returnflights")
    @Expose
    private List<Object> returnflights = null;
    @SerializedName("onwardflights")
    @Expose
    private ArrayList<OnWardFlight> onwardflights = null;

    public Data() {
        onwardflights = new ArrayList<>();
    }

    protected Data(Parcel in) {
        this();
        in.readTypedList(onwardflights, OnWardFlight.CREATOR);
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

    public ArrayList<OnWardFlight> getOnwardflights() {
        return onwardflights;
    }

    public void setOnwardflights(ArrayList<OnWardFlight> onwardflights) {
        this.onwardflights = onwardflights;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(onwardflights);
    }
}
