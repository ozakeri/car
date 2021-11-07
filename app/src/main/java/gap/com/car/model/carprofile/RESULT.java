
package gap.com.car.model.carprofile;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RESULT implements Parcelable
{

    @SerializedName("car")
    @Expose
    public Car car;
    public final static Creator<RESULT> CREATOR = new Creator<RESULT>() {


        @SuppressWarnings({
            "unchecked"
        })
        public RESULT createFromParcel(Parcel in) {
            return new RESULT(in);
        }

        public RESULT[] newArray(int size) {
            return (new RESULT[size]);
        }

    }
    ;

    protected RESULT(Parcel in) {
        this.car = ((Car) in.readValue((Car.class.getClassLoader())));
    }

    public RESULT() {
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(car);
    }

    public int describeContents() {
        return  0;
    }

}
