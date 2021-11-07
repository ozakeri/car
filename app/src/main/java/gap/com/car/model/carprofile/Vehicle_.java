
package gap.com.car.model.carprofile;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Vehicle_ implements Parcelable
{

    @SerializedName("dateCreation")
    @Expose
    public String dateCreation;
    @SerializedName("autoCompleteLabel")
    @Expose
    public String autoCompleteLabel;
    @SerializedName("nameFv")
    @Expose
    public String nameFv;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("doorType")
    @Expose
    public Integer doorType;
    @SerializedName("cabinsNo")
    @Expose
    public Integer cabinsNo;
    @SerializedName("aveFuelUsage")
    @Expose
    public Integer aveFuelUsage;
    @SerializedName("vehicleType_text")
    @Expose
    public String vehicleTypeText;
    @SerializedName("cabinsNo_text")
    @Expose
    public String cabinsNoText;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("groupLevelEn")
    @Expose
    public Integer groupLevelEn;
    @SerializedName("groupLevelEn_text")
    @Expose
    public String groupLevelEnText;
    @SerializedName("minFuelUsage")
    @Expose
    public Integer minFuelUsage;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("status_text")
    @Expose
    public String statusText;
    @SerializedName("maxFuelUsage")
    @Expose
    public Integer maxFuelUsage;
    @SerializedName("vehicleType")
    @Expose
    public Integer vehicleType;
    @SerializedName("doorType_text")
    @Expose
    public String doorTypeText;
    @SerializedName("status")
    @Expose
    public Integer status;
    public final static Creator<Vehicle_> CREATOR = new Creator<Vehicle_>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Vehicle_ createFromParcel(Parcel in) {
            return new Vehicle_(in);
        }

        public Vehicle_[] newArray(int size) {
            return (new Vehicle_[size]);
        }

    }
    ;

    protected Vehicle_(Parcel in) {
        this.dateCreation = ((String) in.readValue((String.class.getClassLoader())));
        this.autoCompleteLabel = ((String) in.readValue((String.class.getClassLoader())));
        this.nameFv = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.doorType = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.cabinsNo = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.aveFuelUsage = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.vehicleTypeText = ((String) in.readValue((String.class.getClassLoader())));
        this.cabinsNoText = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.groupLevelEn = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.groupLevelEnText = ((String) in.readValue((String.class.getClassLoader())));
        this.minFuelUsage = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.statusText = ((String) in.readValue((String.class.getClassLoader())));
        this.maxFuelUsage = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.vehicleType = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.doorTypeText = ((String) in.readValue((String.class.getClassLoader())));
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public Vehicle_() {
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(dateCreation);
        dest.writeValue(autoCompleteLabel);
        dest.writeValue(nameFv);
        dest.writeValue(description);
        dest.writeValue(doorType);
        dest.writeValue(cabinsNo);
        dest.writeValue(aveFuelUsage);
        dest.writeValue(vehicleTypeText);
        dest.writeValue(cabinsNoText);
        dest.writeValue(name);
        dest.writeValue(groupLevelEn);
        dest.writeValue(groupLevelEnText);
        dest.writeValue(minFuelUsage);
        dest.writeValue(id);
        dest.writeValue(statusText);
        dest.writeValue(maxFuelUsage);
        dest.writeValue(vehicleType);
        dest.writeValue(doorTypeText);
        dest.writeValue(status);
    }

    public int describeContents() {
        return  0;
    }

}
