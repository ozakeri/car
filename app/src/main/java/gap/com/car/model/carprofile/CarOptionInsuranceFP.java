
package gap.com.car.model.carprofile;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CarOptionInsuranceFP implements Parcelable
{

    @SerializedName("consistencyEntityBaseAndId")
    @Expose
    public Boolean consistencyEntityBaseAndId;
    @SerializedName("baseEntityNameEnOnOptionType_text")
    @Expose
    public String baseEntityNameEnOnOptionTypeText;
    @SerializedName("paramInt2")
    @Expose
    public Integer paramInt2;
    @SerializedName("nameFv")
    @Expose
    public String nameFv;
    @SerializedName("processStatus")
    @Expose
    public Integer processStatus;
    @SerializedName("baseEntityNameEnOnOptionType")
    @Expose
    public Integer baseEntityNameEnOnOptionType;
    @SerializedName("baseEntityEn_text")
    @Expose
    public String baseEntityEnText;
    @SerializedName("baseEntityEn")
    @Expose
    public Integer baseEntityEn;
    @SerializedName("showTimeRemainingUpForExpire")
    @Expose
    public Boolean showTimeRemainingUpForExpire;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("propertyBisChangePossibleForCarOption")
    @Expose
    public Boolean propertyBisChangePossibleForCarOption;
    @SerializedName("processStatus_text")
    @Expose
    public String processStatusText;
    @SerializedName("nameFvCOL")
    @Expose
    public String nameFvCOL;
    @SerializedName("carOptionTypeEn")
    @Expose
    public Integer carOptionTypeEn;
    @SerializedName("statusChangeToActiveIsPossible")
    @Expose
    public Boolean statusChangeToActiveIsPossible;
    @SerializedName("expireDate")
    @Expose
    public String expireDate;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("status_text")
    @Expose
    public String statusText;
    @SerializedName("paramStr1")
    @Expose
    public String paramStr1;
    @SerializedName("carOptionTypeEn_text")
    @Expose
    public String carOptionTypeEnText;
    @SerializedName("startDate")
    @Expose
    public String startDate;
    @SerializedName("dateConfirm")
    @Expose
    public String dateConfirm;
    @SerializedName("status")
    @Expose
    public Integer status;
    public final static Creator<CarOptionInsuranceFP> CREATOR = new Creator<CarOptionInsuranceFP>() {


        @SuppressWarnings({
            "unchecked"
        })
        public CarOptionInsuranceFP createFromParcel(Parcel in) {
            return new CarOptionInsuranceFP(in);
        }

        public CarOptionInsuranceFP[] newArray(int size) {
            return (new CarOptionInsuranceFP[size]);
        }

    }
    ;

    protected CarOptionInsuranceFP(Parcel in) {
        this.consistencyEntityBaseAndId = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.baseEntityNameEnOnOptionTypeText = ((String) in.readValue((String.class.getClassLoader())));
        this.paramInt2 = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.nameFv = ((String) in.readValue((String.class.getClassLoader())));
        this.processStatus = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.baseEntityNameEnOnOptionType = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.baseEntityEnText = ((String) in.readValue((String.class.getClassLoader())));
        this.baseEntityEn = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.showTimeRemainingUpForExpire = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.propertyBisChangePossibleForCarOption = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.processStatusText = ((String) in.readValue((String.class.getClassLoader())));
        this.nameFvCOL = ((String) in.readValue((String.class.getClassLoader())));
        this.carOptionTypeEn = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.statusChangeToActiveIsPossible = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.expireDate = ((String) in.readValue((String.class.getClassLoader())));
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.statusText = ((String) in.readValue((String.class.getClassLoader())));
        this.paramStr1 = ((String) in.readValue((String.class.getClassLoader())));
        this.carOptionTypeEnText = ((String) in.readValue((String.class.getClassLoader())));
        this.startDate = ((String) in.readValue((String.class.getClassLoader())));
        this.dateConfirm = ((String) in.readValue((String.class.getClassLoader())));
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public CarOptionInsuranceFP() {
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(consistencyEntityBaseAndId);
        dest.writeValue(baseEntityNameEnOnOptionTypeText);
        dest.writeValue(paramInt2);
        dest.writeValue(nameFv);
        dest.writeValue(processStatus);
        dest.writeValue(baseEntityNameEnOnOptionType);
        dest.writeValue(baseEntityEnText);
        dest.writeValue(baseEntityEn);
        dest.writeValue(showTimeRemainingUpForExpire);
        dest.writeValue(description);
        dest.writeValue(propertyBisChangePossibleForCarOption);
        dest.writeValue(processStatusText);
        dest.writeValue(nameFvCOL);
        dest.writeValue(carOptionTypeEn);
        dest.writeValue(statusChangeToActiveIsPossible);
        dest.writeValue(expireDate);
        dest.writeValue(id);
        dest.writeValue(statusText);
        dest.writeValue(paramStr1);
        dest.writeValue(carOptionTypeEnText);
        dest.writeValue(startDate);
        dest.writeValue(dateConfirm);
        dest.writeValue(status);
    }

    public int describeContents() {
        return  0;
    }

}
