package andrekabelim.br.projetomaxmilhas.ui.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class OnWardFlight implements Parcelable {

    //region class
    @SerializedName("origin")
    @Expose
    private String origin;
    @SerializedName("rating")
    @Expose
    private Integer rating;
    @SerializedName("DepartureTime")
    @Expose
    private String departureTime;
    @SerializedName("flightcode")
    @Expose
    private String flightcode;
    @SerializedName("Group")
    @Expose
    private String group;
    @SerializedName("farebasis")
    @Expose
    private String farebasis;
    @SerializedName("depterminal")
    @Expose
    private String depterminal;
    @SerializedName("holdflag")
    @Expose
    private String holdflag;
    @SerializedName("CINFO")
    @Expose
    private String cINFO;
    @SerializedName("deptime")
    @Expose
    private String deptime;
    @SerializedName("codeshare")
    @Expose
    private String codeshare;
    @SerializedName("ibibopartner")
    @Expose
    private String ibibopartner;
    @SerializedName("duration")
    @Expose
    private String duration;
    @SerializedName("platingcarrier")
    @Expose
    private String platingcarrier;
    @SerializedName("qtype")
    @Expose
    private String qtype;
    @SerializedName("arrterminal")
    @Expose
    private String arrterminal;
    @SerializedName("flightno")
    @Expose
    private String flightno;
    @SerializedName("destination")
    @Expose
    private String destination;
    @SerializedName("FlHash")
    @Expose
    private String flHash;
    @SerializedName("stops")
    @Expose
    private String stops;
    @SerializedName("seatsavailable")
    @Expose
    private String seatsavailable;
    @SerializedName("carrierid")
    @Expose
    private String carrierid;
    @SerializedName("provider")
    @Expose
    private String provider;
    @SerializedName("refundable")
    @Expose
    private String refundable;
    @SerializedName("PromotionId")
    @Expose
    private String promotionId;
    @SerializedName("fare")
    @Expose
    private Fare fare;
    @SerializedName("CabinClass")
    @Expose
    private String cabinClass;
    @SerializedName("returnfl")
    @Expose
    private List<Returnfl> returnfl = null;
    @SerializedName("warnings")
    @Expose
    private String warnings;
    @SerializedName("ArrivalTime")
    @Expose
    private String arrivalTime;
    @SerializedName("onwardflights")
    @Expose
    private List<Object> onwardflights = null;
    @SerializedName("aircraftType")
    @Expose
    private String aircraftType;
    @SerializedName("seatingclass")
    @Expose
    private String seatingclass;
    @SerializedName("operatingcarrier")
    @Expose
    private String operatingcarrier;
    @SerializedName("src")
    @Expose
    private String src;
    @SerializedName("internationalsearch")
    @Expose
    private String internationalsearch;
    @SerializedName("splitduration")
    @Expose
    private String splitduration;
    @SerializedName("AvailabilityDisplayType")
    @Expose
    private String availabilityDisplayType;
    @SerializedName("searchKey")
    @Expose
    private String searchKey;
    @SerializedName("bookingclass")
    @Expose
    private String bookingclass;
    @SerializedName("airline")
    @Expose
    private String airline;
    @SerializedName("multicitysearch")
    @Expose
    private String multicitysearch;
    @SerializedName("depdate")
    @Expose
    private String depdate;
    @SerializedName("arrtime")
    @Expose
    private String arrtime;
    @SerializedName("arrdate")
    @Expose
    private String arrdate;
    @SerializedName("CacheKey")
    @Expose
    private String cacheKey;
    @SerializedName("TravelTime")
    @Expose
    private String travelTime;

    protected OnWardFlight(Parcel in) {
        origin = in.readString();
        if (in.readByte() == 0) {
            rating = null;
        } else {
            rating = in.readInt();
        }
        departureTime = in.readString();
        flightcode = in.readString();
        group = in.readString();
        farebasis = in.readString();
        depterminal = in.readString();
        holdflag = in.readString();
        cINFO = in.readString();
        deptime = in.readString();
        codeshare = in.readString();
        ibibopartner = in.readString();
        duration = in.readString();
        platingcarrier = in.readString();
        qtype = in.readString();
        arrterminal = in.readString();
        flightno = in.readString();
        destination = in.readString();
        flHash = in.readString();
        stops = in.readString();
        seatsavailable = in.readString();
        carrierid = in.readString();
        provider = in.readString();
        refundable = in.readString();
        promotionId = in.readString();
        fare = in.readParcelable(Fare.class.getClassLoader());
        cabinClass = in.readString();
        returnfl = in.createTypedArrayList(Returnfl.CREATOR);
        warnings = in.readString();
        arrivalTime = in.readString();
        aircraftType = in.readString();
        seatingclass = in.readString();
        operatingcarrier = in.readString();
        src = in.readString();
        internationalsearch = in.readString();
        splitduration = in.readString();
        availabilityDisplayType = in.readString();
        searchKey = in.readString();
        bookingclass = in.readString();
        airline = in.readString();
        multicitysearch = in.readString();
        depdate = in.readString();
        arrtime = in.readString();
        arrdate = in.readString();
        cacheKey = in.readString();
        travelTime = in.readString();
    }

    public static final Creator<OnWardFlight> CREATOR = new Creator<OnWardFlight>() {
        @Override
        public OnWardFlight createFromParcel(Parcel in) {
            return new OnWardFlight(in);
        }

        @Override
        public OnWardFlight[] newArray(int size) {
            return new OnWardFlight[size];
        }
    };

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getFlightcode() {
        return flightcode;
    }

    public void setFlightcode(String flightcode) {
        this.flightcode = flightcode;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getFarebasis() {
        return farebasis;
    }

    public void setFarebasis(String farebasis) {
        this.farebasis = farebasis;
    }

    public String getDepterminal() {
        return depterminal;
    }

    public void setDepterminal(String depterminal) {
        this.depterminal = depterminal;
    }

    public String getHoldflag() {
        return holdflag;
    }

    public void setHoldflag(String holdflag) {
        this.holdflag = holdflag;
    }

    public String getCINFO() {
        return cINFO;
    }

    public void setCINFO(String cINFO) {
        this.cINFO = cINFO;
    }

    public String getDeptime() {
        return deptime;
    }

    public void setDeptime(String deptime) {
        this.deptime = deptime;
    }

    public String getCodeshare() {
        return codeshare;
    }

    public void setCodeshare(String codeshare) {
        this.codeshare = codeshare;
    }

    public String getIbibopartner() {
        return ibibopartner;
    }

    public void setIbibopartner(String ibibopartner) {
        this.ibibopartner = ibibopartner;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPlatingcarrier() {
        return platingcarrier;
    }

    public void setPlatingcarrier(String platingcarrier) {
        this.platingcarrier = platingcarrier;
    }

    public String getQtype() {
        return qtype;
    }

    public void setQtype(String qtype) {
        this.qtype = qtype;
    }

    public String getArrterminal() {
        return arrterminal;
    }

    public void setArrterminal(String arrterminal) {
        this.arrterminal = arrterminal;
    }

    public String getFlightno() {
        return flightno;
    }

    public void setFlightno(String flightno) {
        this.flightno = flightno;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFlHash() {
        return flHash;
    }

    public void setFlHash(String flHash) {
        this.flHash = flHash;
    }

    public String getStops() {
        return stops;
    }

    public void setStops(String stops) {
        this.stops = stops;
    }

    public String getSeatsavailable() {
        return seatsavailable;
    }

    public void setSeatsavailable(String seatsavailable) {
        this.seatsavailable = seatsavailable;
    }

    public String getCarrierid() {
        return carrierid;
    }

    public void setCarrierid(String carrierid) {
        this.carrierid = carrierid;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getRefundable() {
        return refundable;
    }

    public void setRefundable(String refundable) {
        this.refundable = refundable;
    }

    public String getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(String promotionId) {
        this.promotionId = promotionId;
    }

    public Fare getFare() {
        return fare;
    }

    public void setFare(Fare fare) {
        this.fare = fare;
    }

    public String getCabinClass() {
        return cabinClass;
    }

    public void setCabinClass(String cabinClass) {
        this.cabinClass = cabinClass;
    }

    public List<Returnfl> getReturnfl() {
        return returnfl;
    }

    public void setReturnfl(List<Returnfl> returnfl) {
        this.returnfl = returnfl;
    }

    public String getWarnings() {
        return warnings;
    }

    public void setWarnings(String warnings) {
        this.warnings = warnings;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public List<Object> getOnwardflights() {
        return onwardflights;
    }

    public void setOnwardflights(List<Object> onwardflights) {
        this.onwardflights = onwardflights;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
    }

    public String getSeatingclass() {
        return seatingclass;
    }

    public void setSeatingclass(String seatingclass) {
        this.seatingclass = seatingclass;
    }

    public String getOperatingcarrier() {
        return operatingcarrier;
    }

    public void setOperatingcarrier(String operatingcarrier) {
        this.operatingcarrier = operatingcarrier;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getInternationalsearch() {
        return internationalsearch;
    }

    public void setInternationalsearch(String internationalsearch) {
        this.internationalsearch = internationalsearch;
    }

    public String getSplitduration() {
        return splitduration;
    }

    public void setSplitduration(String splitduration) {
        this.splitduration = splitduration;
    }

    public String getAvailabilityDisplayType() {
        return availabilityDisplayType;
    }

    public void setAvailabilityDisplayType(String availabilityDisplayType) {
        this.availabilityDisplayType = availabilityDisplayType;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public String getBookingclass() {
        return bookingclass;
    }

    public void setBookingclass(String bookingclass) {
        this.bookingclass = bookingclass;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getMulticitysearch() {
        return multicitysearch;
    }

    public void setMulticitysearch(String multicitysearch) {
        this.multicitysearch = multicitysearch;
    }

    public String getDepdate() {
        return depdate;
    }

    public void setDepdate(String depdate) {
        this.depdate = depdate;
    }

    public String getArrtime() {
        return arrtime;
    }

    public void setArrtime(String arrtime) {
        this.arrtime = arrtime;
    }

    public String getArrdate() {
        return arrdate;
    }

    public void setArrdate(String arrdate) {
        this.arrdate = arrdate;
    }

    public String getCacheKey() {
        return cacheKey;
    }

    public void setCacheKey(String cacheKey) {
        this.cacheKey = cacheKey;
    }

    public String getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(String travelTime) {
        this.travelTime = travelTime;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(origin);
        if (rating == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(rating);
        }
        parcel.writeString(departureTime);
        parcel.writeString(flightcode);
        parcel.writeString(group);
        parcel.writeString(farebasis);
        parcel.writeString(depterminal);
        parcel.writeString(holdflag);
        parcel.writeString(cINFO);
        parcel.writeString(deptime);
        parcel.writeString(codeshare);
        parcel.writeString(ibibopartner);
        parcel.writeString(duration);
        parcel.writeString(platingcarrier);
        parcel.writeString(qtype);
        parcel.writeString(arrterminal);
        parcel.writeString(flightno);
        parcel.writeString(destination);
        parcel.writeString(flHash);
        parcel.writeString(stops);
        parcel.writeString(seatsavailable);
        parcel.writeString(carrierid);
        parcel.writeString(provider);
        parcel.writeString(refundable);
        parcel.writeString(promotionId);
        parcel.writeParcelable(fare, i);
        parcel.writeString(cabinClass);
        parcel.writeTypedList(returnfl);
        parcel.writeString(warnings);
        parcel.writeString(arrivalTime);
        parcel.writeString(aircraftType);
        parcel.writeString(seatingclass);
        parcel.writeString(operatingcarrier);
        parcel.writeString(src);
        parcel.writeString(internationalsearch);
        parcel.writeString(splitduration);
        parcel.writeString(availabilityDisplayType);
        parcel.writeString(searchKey);
        parcel.writeString(bookingclass);
        parcel.writeString(airline);
        parcel.writeString(multicitysearch);
        parcel.writeString(depdate);
        parcel.writeString(arrtime);
        parcel.writeString(arrdate);
        parcel.writeString(cacheKey);
        parcel.writeString(travelTime);
    }

    //end region
}
