
package gap.com.car.model.carprofile;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Color implements Parcelable
{

    @SerializedName("dateCreation")
    @Expose
    public String dateCreation;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("status_text")
    @Expose
    public String statusText;
    @SerializedName("status")
    @Expose
    public Integer status;
    public final static Creator<Color> CREATOR = new Creator<Color>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Color createFromParcel(Parcel in) {
            return new Color(in);
        }

        public Color[] newArray(int size) {
            return (new Color[size]);
        }

    }
    ;

    protected Color(Parcel in) {
        this.dateCreation = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.statusText = ((String) in.readValue((String.class.getClassLoader())));
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public Color() {
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(dateCreation);
        dest.writeValue(name);
        dest.writeValue(id);
        dest.writeValue(statusText);
        dest.writeValue(status);
    }

    public int describeContents() {
        return  0;
    }

}
