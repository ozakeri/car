package gap.com.car.model.carinvoice;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Line implements Parcelable {

    @SerializedName("lineCode")
    @Expose
    private String lineCode;

    public String getLineCode() {
        return lineCode;
    }

    public void setLineCode(String lineCode) {
        this.lineCode = lineCode;
    }

    protected Line(Parcel in) {
        lineCode = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(lineCode);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Line> CREATOR = new Creator<Line>() {
        @Override
        public Line createFromParcel(Parcel in) {
            return new Line(in);
        }

        @Override
        public Line[] newArray(int size) {
            return new Line[size];
        }
    };
}
