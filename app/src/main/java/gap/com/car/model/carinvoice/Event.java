package gap.com.car.model.carinvoice;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Event implements Parcelable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("dateCreation")
    @Expose
    private String dateCreation;
    @SerializedName("reasonSysParamStr")
    @Expose
    private String reasonSysParamStr;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getReasonSysParamStr() {
        return reasonSysParamStr;
    }

    public void setReasonSysParamStr(String reasonSysParamStr) {
        this.reasonSysParamStr = reasonSysParamStr;
    }

    protected Event(Parcel in) {
        name = in.readString();
        dateCreation = in.readString();
        reasonSysParamStr = in.readString();
    }

    public static final Creator<Event> CREATOR = new Creator<Event>() {
        @Override
        public Event createFromParcel(Parcel in) {
            return new Event(in);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(dateCreation);
        dest.writeString(reasonSysParamStr);
    }
}
