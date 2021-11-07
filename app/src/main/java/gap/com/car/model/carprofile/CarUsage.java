
package gap.com.car.model.carprofile;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CarUsage implements Parcelable
{

    @SerializedName("dateCreation")
    @Expose
    public String dateCreation;
    @SerializedName("nameFv")
    @Expose
    public String nameFv;
    @SerializedName("processStatus")
    @Expose
    public Integer processStatus;
    @SerializedName("lineStrFV")
    @Expose
    public String lineStrFV;
    @SerializedName("line")
    @Expose
    public Line line;
    @SerializedName("lineStrFV_1")
    @Expose
    public String lineStrFV1;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("processStatus_text")
    @Expose
    public String processStatusText;
    @SerializedName("reserveIs_text")
    @Expose
    public String reserveIsText;
    @SerializedName("reserveIs")
    @Expose
    public Integer reserveIs;
    @SerializedName("car")
    @Expose
    public Car_ car;
    @SerializedName("lineCompanyProfit")
    @Expose
    public LineCompanyProfit lineCompanyProfit;
    @SerializedName("roleForEdit")
    @Expose
    public String roleForEdit;
    @SerializedName("finishDate")
    @Expose
    public String finishDate;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("status_text")
    @Expose
    public String statusText;
    @SerializedName("usageType_text")
    @Expose
    public String usageTypeText;
    @SerializedName("carUsageStrFV")
    @Expose
    public String carUsageStrFV;
    @SerializedName("startDate")
    @Expose
    public String startDate;
    @SerializedName("status")
    @Expose
    public Integer status;
    @SerializedName("usageType")
    @Expose
    public Integer usageType;
    public final static Creator<CarUsage> CREATOR = new Creator<CarUsage>() {


        @SuppressWarnings({
            "unchecked"
        })
        public CarUsage createFromParcel(Parcel in) {
            return new CarUsage(in);
        }

        public CarUsage[] newArray(int size) {
            return (new CarUsage[size]);
        }

    }
    ;

    protected CarUsage(Parcel in) {
        this.dateCreation = ((String) in.readValue((String.class.getClassLoader())));
        this.nameFv = ((String) in.readValue((String.class.getClassLoader())));
        this.processStatus = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.lineStrFV = ((String) in.readValue((String.class.getClassLoader())));
        this.line = ((Line) in.readValue((Line.class.getClassLoader())));
        this.lineStrFV1 = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.processStatusText = ((String) in.readValue((String.class.getClassLoader())));
        this.reserveIsText = ((String) in.readValue((String.class.getClassLoader())));
        this.reserveIs = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.car = ((Car_) in.readValue((Car_.class.getClassLoader())));
        this.lineCompanyProfit = ((LineCompanyProfit) in.readValue((LineCompanyProfit.class.getClassLoader())));
        this.roleForEdit = ((String) in.readValue((String.class.getClassLoader())));
        this.finishDate = ((String) in.readValue((String.class.getClassLoader())));
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.statusText = ((String) in.readValue((String.class.getClassLoader())));
        this.usageTypeText = ((String) in.readValue((String.class.getClassLoader())));
        this.carUsageStrFV = ((String) in.readValue((String.class.getClassLoader())));
        this.startDate = ((String) in.readValue((String.class.getClassLoader())));
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.usageType = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public CarUsage() {
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(dateCreation);
        dest.writeValue(nameFv);
        dest.writeValue(processStatus);
        dest.writeValue(lineStrFV);
        dest.writeValue(line);
        dest.writeValue(lineStrFV1);
        dest.writeValue(description);
        dest.writeValue(processStatusText);
        dest.writeValue(reserveIsText);
        dest.writeValue(reserveIs);
        dest.writeValue(car);
        dest.writeValue(lineCompanyProfit);
        dest.writeValue(roleForEdit);
        dest.writeValue(finishDate);
        dest.writeValue(id);
        dest.writeValue(statusText);
        dest.writeValue(usageTypeText);
        dest.writeValue(carUsageStrFV);
        dest.writeValue(startDate);
        dest.writeValue(status);
        dest.writeValue(usageType);
    }

    public int describeContents() {
        return  0;
    }

}
