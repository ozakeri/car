package gap.com.car.model.carinvoice;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SuccessResponseCarInvoice implements Parcelable {

    @SerializedName("SUCCESS")
    @Expose
    private String SUCCESS;
    @SerializedName("carInvoice")
    @Expose
    private CarInvoice carInvoice;
    @SerializedName("carDailyInfo")
    @Expose
    private CarDailyInfo carDailyInfo;

    public String getSUCCESS() {
        return SUCCESS;
    }

    public void setSUCCESS(String SUCCESS) {
        this.SUCCESS = SUCCESS;
    }

    public CarInvoice getCarInvoice() {
        return carInvoice;
    }

    public void setCarInvoice(CarInvoice carInvoice) {
        this.carInvoice = carInvoice;
    }

    public CarDailyInfo getCarDailyInfo() {
        return carDailyInfo;
    }

    public void setCarDailyInfo(CarDailyInfo carDailyInfo) {
        this.carDailyInfo = carDailyInfo;
    }

    protected SuccessResponseCarInvoice(Parcel in) {
        SUCCESS = in.readString();
        carInvoice = in.readParcelable(CarInvoice.class.getClassLoader());
        carDailyInfo = in.readParcelable(CarInvoice.class.getClassLoader());
    }

    public static final Creator<SuccessResponseCarInvoice> CREATOR = new Creator<SuccessResponseCarInvoice>() {
        @Override
        public SuccessResponseCarInvoice createFromParcel(Parcel in) {
            return new SuccessResponseCarInvoice(in);
        }

        @Override
        public SuccessResponseCarInvoice[] newArray(int size) {
            return new SuccessResponseCarInvoice[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(SUCCESS);
        dest.writeParcelable(carInvoice, flags);
        dest.writeParcelable(carDailyInfo, flags);
    }
}
