
package gap.com.car.model.carprofile;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LinePrice implements Parcelable
{

    @SerializedName("priceUnitBaseLableFV")
    @Expose
    public String priceUnitBaseLableFV;
    @SerializedName("dateCreation")
    @Expose
    public String dateCreation;
    @SerializedName("processStatus")
    @Expose
    public Integer processStatus;
    @SerializedName("year")
    @Expose
    public Integer year;
    @SerializedName("priceHoliday")
    @Expose
    public Integer priceHoliday;
    @SerializedName("eCardPrice")
    @Expose
    public Integer eCardPrice;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("mainIs")
    @Expose
    public Boolean mainIs;
    @SerializedName("typeEn")
    @Expose
    public Integer typeEn;
    @SerializedName("processStatus_text")
    @Expose
    public String processStatusText;
    @SerializedName("priceUnitSurPlusLableFV")
    @Expose
    public String priceUnitSurPlusLableFV;
    @SerializedName("priceCoFinal")
    @Expose
    public Integer priceCoFinal;
    @SerializedName("priceNight")
    @Expose
    public Integer priceNight;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("status_text")
    @Expose
    public String statusText;
    @SerializedName("typeEn_text")
    @Expose
    public String typeEnText;
    @SerializedName("documentVersionIsRequired")
    @Expose
    public Boolean documentVersionIsRequired;
    @SerializedName("startDate")
    @Expose
    public String startDate;
    @SerializedName("status")
    @Expose
    public Integer status;
    public final static Creator<LinePrice> CREATOR = new Creator<LinePrice>() {


        @SuppressWarnings({
            "unchecked"
        })
        public LinePrice createFromParcel(Parcel in) {
            return new LinePrice(in);
        }

        public LinePrice[] newArray(int size) {
            return (new LinePrice[size]);
        }

    }
    ;

    protected LinePrice(Parcel in) {
        this.priceUnitBaseLableFV = ((String) in.readValue((String.class.getClassLoader())));
        this.dateCreation = ((String) in.readValue((String.class.getClassLoader())));
        this.processStatus = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.year = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.priceHoliday = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.eCardPrice = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.mainIs = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.typeEn = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.processStatusText = ((String) in.readValue((String.class.getClassLoader())));
        this.priceUnitSurPlusLableFV = ((String) in.readValue((String.class.getClassLoader())));
        this.priceCoFinal = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.priceNight = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.statusText = ((String) in.readValue((String.class.getClassLoader())));
        this.typeEnText = ((String) in.readValue((String.class.getClassLoader())));
        this.documentVersionIsRequired = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.startDate = ((String) in.readValue((String.class.getClassLoader())));
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public LinePrice() {
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(priceUnitBaseLableFV);
        dest.writeValue(dateCreation);
        dest.writeValue(processStatus);
        dest.writeValue(year);
        dest.writeValue(priceHoliday);
        dest.writeValue(eCardPrice);
        dest.writeValue(description);
        dest.writeValue(mainIs);
        dest.writeValue(typeEn);
        dest.writeValue(processStatusText);
        dest.writeValue(priceUnitSurPlusLableFV);
        dest.writeValue(priceCoFinal);
        dest.writeValue(priceNight);
        dest.writeValue(id);
        dest.writeValue(statusText);
        dest.writeValue(typeEnText);
        dest.writeValue(documentVersionIsRequired);
        dest.writeValue(startDate);
        dest.writeValue(status);
    }

    public int describeContents() {
        return  0;
    }

}
