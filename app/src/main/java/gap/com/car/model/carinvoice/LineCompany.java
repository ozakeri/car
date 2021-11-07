package gap.com.car.model.carinvoice;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LineCompany implements Parcelable {

    @SerializedName("lineCode")
    @Expose
    public String lineCode;

    protected LineCompany(Parcel in) {
        lineCode = in.readString();
    }

    public static final Creator<LineCompany> CREATOR = new Creator<LineCompany>() {
        @Override
        public LineCompany createFromParcel(Parcel in) {
            return new LineCompany(in);
        }

        @Override
        public LineCompany[] newArray(int size) {
            return new LineCompany[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(lineCode);
    }
}
