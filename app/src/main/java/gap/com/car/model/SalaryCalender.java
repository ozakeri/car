
package gap.com.car.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SalaryCalender implements Parcelable {

    @SerializedName("holidayIs")
    @Expose
    public int holidayIs;

    protected SalaryCalender(Parcel in) {
        holidayIs = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(holidayIs);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SalaryCalender> CREATOR = new Creator<SalaryCalender>() {
        @Override
        public SalaryCalender createFromParcel(Parcel in) {
            return new SalaryCalender(in);
        }

        @Override
        public SalaryCalender[] newArray(int size) {
            return new SalaryCalender[size];
        }
    };

    public int getHolidayIs() {
        return holidayIs;
    }

    public void setHolidayIs(int holidayIs) {
        this.holidayIs = holidayIs;
    }
}
