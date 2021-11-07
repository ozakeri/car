package gap.com.car.model.carinvoice;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CarDailyInfoList implements Parcelable {

    @SerializedName("calender")
    @Expose
    private Calender calender;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("lineCompany")
    @Expose
    private LineCompany lineCompany;
    @SerializedName("priceEtPass")
    @Expose
    private int priceEtPass;
    @SerializedName("countEtPass")
    @Expose
    private int countEtPass;
    @SerializedName("reasonInactiveEn")
    @Expose
    private int reasonInactiveEn;
    @SerializedName("activeIs")
    @Expose
    private boolean activeIs;
    @SerializedName("processStatus")
    @Expose
    private Integer processStatus;

    public Calender getCalender() {
        return calender;
    }

    public void setCalender(Calender calender) {
        this.calender = calender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LineCompany getLineCompany() {
        return lineCompany;
    }

    public void setLineCompany(LineCompany lineCompany) {
        this.lineCompany = lineCompany;
    }

    public int getPriceEtPass() {
        return priceEtPass;
    }

    public void setPriceEtPass(int priceEtPass) {
        this.priceEtPass = priceEtPass;
    }

    public int getCountEtPass() {
        return countEtPass;
    }

    public void setCountEtPass(int countEtPass) {
        this.countEtPass = countEtPass;
    }

    public int getReasonInactiveEn() {
        return reasonInactiveEn;
    }

    public void setReasonInactiveEn(int reasonInactiveEn) {
        this.reasonInactiveEn = reasonInactiveEn;
    }

    public boolean isActiveIs() {
        return activeIs;
    }

    public void setActiveIs(boolean activeIs) {
        this.activeIs = activeIs;
    }

    public Integer getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(int processStatus) {
        this.processStatus = processStatus;
    }

    protected CarDailyInfoList(Parcel in) {
        calender = in.readParcelable(Calender.class.getClassLoader());
        id = in.readInt();
        lineCompany = in.readParcelable(LineCompany.class.getClassLoader());
        priceEtPass = in.readInt();
        countEtPass = in.readInt();
        reasonInactiveEn = in.readInt();
        activeIs = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(calender, flags);
        dest.writeInt(id);
        dest.writeParcelable(lineCompany, flags);
        dest.writeInt(priceEtPass);
        dest.writeInt(countEtPass);
        dest.writeInt(reasonInactiveEn);
        dest.writeByte((byte) (activeIs ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CarDailyInfoList> CREATOR = new Creator<CarDailyInfoList>() {
        @Override
        public CarDailyInfoList createFromParcel(Parcel in) {
            return new CarDailyInfoList(in);
        }

        @Override
        public CarDailyInfoList[] newArray(int size) {
            return new CarDailyInfoList[size];
        }
    };
}
