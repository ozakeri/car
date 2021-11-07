
package gap.com.car.model.carprofile;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CarProfitOwner implements Parcelable
{

    @SerializedName("ownerType")
    @Expose
    public Integer ownerType;
    @SerializedName("sharePart")
    @Expose
    public Integer sharePart;
    @SerializedName("ownerType_text")
    @Expose
    public String ownerTypeText;
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
    @SerializedName("company")
    @Expose
    public Company__ company;
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
    @SerializedName("dateConfirm")
    @Expose
    public String dateConfirm;
    @SerializedName("status")
    @Expose
    public Integer status;
    @SerializedName("ownerIs")
    @Expose
    public Integer ownerIs;
    public final static Creator<CarProfitOwner> CREATOR = new Creator<CarProfitOwner>() {


        @SuppressWarnings({
            "unchecked"
        })
        public CarProfitOwner createFromParcel(Parcel in) {
            return new CarProfitOwner(in);
        }

        public CarProfitOwner[] newArray(int size) {
            return (new CarProfitOwner[size]);
        }

    }
    ;

    protected CarProfitOwner(Parcel in) {
        this.ownerType = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.sharePart = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.ownerTypeText = ((String) in.readValue((String.class.getClassLoader())));
        this.dateCreation = ((String) in.readValue((String.class.getClassLoader())));
        this.processStatus = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.profitType = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.processStatusText = ((String) in.readValue((String.class.getClassLoader())));
        this.ownerIsText = ((String) in.readValue((String.class.getClassLoader())));
        this.company = ((Company__) in.readValue((Company__.class.getClassLoader())));
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.statusText = ((String) in.readValue((String.class.getClassLoader())));
        this.profitTypeText = ((String) in.readValue((String.class.getClassLoader())));
        this.startDate = ((String) in.readValue((String.class.getClassLoader())));
        this.dateConfirm = ((String) in.readValue((String.class.getClassLoader())));
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.ownerIs = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public CarProfitOwner() {
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(ownerType);
        dest.writeValue(sharePart);
        dest.writeValue(ownerTypeText);
        dest.writeValue(dateCreation);
        dest.writeValue(processStatus);
        dest.writeValue(profitType);
        dest.writeValue(processStatusText);
        dest.writeValue(ownerIsText);
        dest.writeValue(company);
        dest.writeValue(id);
        dest.writeValue(statusText);
        dest.writeValue(profitTypeText);
        dest.writeValue(startDate);
        dest.writeValue(dateConfirm);
        dest.writeValue(status);
        dest.writeValue(ownerIs);
    }

    public int describeContents() {
        return  0;
    }

}
