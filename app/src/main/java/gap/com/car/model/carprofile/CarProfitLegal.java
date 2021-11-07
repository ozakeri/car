
package gap.com.car.model.carprofile;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CarProfitLegal implements Parcelable
{

    @SerializedName("sharePart")
    @Expose
    public Integer sharePart;
    @SerializedName("dateCreation")
    @Expose
    public String dateCreation;
    @SerializedName("processStatus")
    @Expose
    public Integer processStatus;
    @SerializedName("profitType")
    @Expose
    public Integer profitType;
    @SerializedName("processStatus_text")
    @Expose
    public String processStatusText;
    @SerializedName("ownerIs_text")
    @Expose
    public String ownerIsText;
    @SerializedName("finishDate")
    @Expose
    public String finishDate;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("status_text")
    @Expose
    public String statusText;
    @SerializedName("profitType_text")
    @Expose
    public String profitTypeText;
    @SerializedName("startDate")
    @Expose
    public String startDate;
    @SerializedName("status")
    @Expose
    public Integer status;
    @SerializedName("ownerIs")
    @Expose
    public Integer ownerIs;
    public final static Creator<CarProfitLegal> CREATOR = new Creator<CarProfitLegal>() {


        @SuppressWarnings({
            "unchecked"
        })
        public CarProfitLegal createFromParcel(Parcel in) {
            return new CarProfitLegal(in);
        }

        public CarProfitLegal[] newArray(int size) {
            return (new CarProfitLegal[size]);
        }

    }
    ;

    protected CarProfitLegal(Parcel in) {
        this.sharePart = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.dateCreation = ((String) in.readValue((String.class.getClassLoader())));
        this.processStatus = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.profitType = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.processStatusText = ((String) in.readValue((String.class.getClassLoader())));
        this.ownerIsText = ((String) in.readValue((String.class.getClassLoader())));
        this.finishDate = ((String) in.readValue((String.class.getClassLoader())));
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.statusText = ((String) in.readValue((String.class.getClassLoader())));
        this.profitTypeText = ((String) in.readValue((String.class.getClassLoader())));
        this.startDate = ((String) in.readValue((String.class.getClassLoader())));
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.ownerIs = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public CarProfitLegal() {
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(sharePart);
        dest.writeValue(dateCreation);
        dest.writeValue(processStatus);
        dest.writeValue(profitType);
        dest.writeValue(processStatusText);
        dest.writeValue(ownerIsText);
        dest.writeValue(finishDate);
        dest.writeValue(id);
        dest.writeValue(statusText);
        dest.writeValue(profitTypeText);
        dest.writeValue(startDate);
        dest.writeValue(status);
        dest.writeValue(ownerIs);
    }

    public int describeContents() {
        return  0;
    }

}
