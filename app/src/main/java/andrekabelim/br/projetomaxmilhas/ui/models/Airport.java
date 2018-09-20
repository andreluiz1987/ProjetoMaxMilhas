package andrekabelim.br.projetomaxmilhas.ui.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Airport implements Parcelable {

    public String code;
    public String name;

    protected Airport(Parcel in) {
        code = in.readString();
        name = in.readString();
    }

    public Airport() {
    }

    public static final Creator<Airport> CREATOR = new Creator<Airport>() {
        @Override
        public Airport createFromParcel(Parcel in) {
            return new Airport(in);
        }

        @Override
        public Airport[] newArray(int size) {
            return new Airport[size];
        }
    };

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(code);
        parcel.writeString(name);
    }
}
