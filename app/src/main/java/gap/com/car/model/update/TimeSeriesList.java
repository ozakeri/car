
package gap.com.car.model.update;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TimeSeriesList implements Parcelable {

    @SerializedName("date")
    @Expose
    public String date;
    @SerializedName("childVOListSize")
    @Expose
    public Integer childVOListSize;
    @SerializedName("count")
    @Expose
    public Integer count;

    protected TimeSeriesList(Parcel in) {
        date = in.readString();
        if (in.readByte() == 0) {
            childVOListSize = null;
        } else {
            childVOListSize = in.readInt();
        }
        if (in.readByte() == 0) {
            count = null;
        } else {
            count = in.readInt();
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(date);
        if (childVOListSize == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(childVOListSize);
        }
        if (count == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(count);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TimeSeriesList> CREATOR = new Creator<TimeSeriesList>() {
        @Override
        public TimeSeriesList createFromParcel(Parcel in) {
            return new TimeSeriesList(in);
        }

        @Override
        public TimeSeriesList[] newArray(int size) {
            return new TimeSeriesList[size];
        }
    };

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getChildVOListSize() {
        return childVOListSize;
    }

    public void setChildVOListSize(Integer childVOListSize) {
        this.childVOListSize = childVOListSize;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
