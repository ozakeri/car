package gap.com.car.model.carinvoice;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Calender implements Parcelable {

    @SerializedName("date")
    @Expose
    public String date;
    @SerializedName("holidayIs")
    @Expose
    public int holidayIs;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getHolidayIs() {
        return holidayIs;
    }

    public void setHolidayIs(int holidayIs) {
        this.holidayIs = holidayIs;
    }

    protected Calender(Parcel in) {
        date = in.readString();
        holidayIs = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(date);
        dest.writeInt(holidayIs);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Calender> CREATOR = new Creator<Calender>() {
        @Override
        public Calender createFromParcel(Parcel in) {
            return new Calender(in);
        }

        @Override
        public Calender[] newArray(int size) {
            return new Calender[size];
        }
    };
}
