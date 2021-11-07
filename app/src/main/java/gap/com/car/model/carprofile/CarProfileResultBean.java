
package gap.com.car.model.carprofile;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CarProfileResultBean implements Parcelable
{

    @SerializedName("SUCCESS")
    @Expose
    public String sUCCESS;
    @SerializedName("RESULT")
    @Expose
    public RESULT rESULT;
    public final static Creator<CarProfileResultBean> CREATOR = new Creator<CarProfileResultBean>() {


        @SuppressWarnings({
            "unchecked"
        })
        public CarProfileResultBean createFromParcel(Parcel in) {
            return new CarProfileResultBean(in);
        }

        public CarProfileResultBean[] newArray(int size) {
            return (new CarProfileResultBean[size]);
        }

    }
    ;

    protected CarProfileResultBean(Parcel in) {
        this.sUCCESS = ((String) in.readValue((String.class.getClassLoader())));
        this.rESULT = ((RESULT) in.readValue((RESULT.class.getClassLoader())));
    }

    public CarProfileResultBean() {
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(sUCCESS);
        dest.writeValue(rESULT);
    }

    public int describeContents() {
        return  0;
    }

}
