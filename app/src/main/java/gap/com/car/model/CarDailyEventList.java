
package gap.com.car.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CarDailyEventList implements Parcelable {

    @SerializedName("nameFv")
    @Expose
    private String nameFv;
    @SerializedName("car")
    @Expose
    private Car car;
    @SerializedName("dailyEventDetailList")
    @Expose
    private List<DailyEventDetailList> dailyEventDetailList = null;
    @SerializedName("startTime")
    @Expose
    private String startTime;
    @SerializedName("endTime")
    @Expose
    private String endTime;

    protected CarDailyEventList(Parcel in) {
        nameFv = in.readString();
        car = in.readParcelable(Car.class.getClassLoader());
        startTime = in.readString();
        endTime = in.readString();
    }

    public static final Creator<CarDailyEventList> CREATOR = new Creator<CarDailyEventList>() {
        @Override
        public CarDailyEventList createFromParcel(Parcel in) {
            return new CarDailyEventList(in);
        }

        @Override
        public CarDailyEventList[] newArray(int size) {
            return new CarDailyEventList[size];
        }
    };

    public String getNameFv() {
        return nameFv;
    }

    public void setNameFv(String nameFv) {
        this.nameFv = nameFv;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<DailyEventDetailList> getDailyEventDetailList() {
        return dailyEventDetailList;
    }

    public void setDailyEventDetailList(List<DailyEventDetailList> dailyEventDetailList) {
        this.dailyEventDetailList = dailyEventDetailList;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nameFv);
        parcel.writeParcelable(car, i);
        parcel.writeString(startTime);
        parcel.writeString(endTime);
    }
}
