
package gap.com.car.model.carprofile;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LineCompanyProfit implements Parcelable
{

    @SerializedName("dateCreation")
    @Expose
    public String dateCreation;
    @SerializedName("serviceTime_text")
    @Expose
    public String serviceTimeText;
    @SerializedName("approvalDate")
    @Expose
    public String approvalDate;
    @SerializedName("nameFv")
    @Expose
    public String nameFv;
    @SerializedName("processStatus")
    @Expose
    public Integer processStatus;
    @SerializedName("codeProfitFV")
    @Expose
    public String codeProfitFV;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("capacityProfitNo")
    @Expose
    public Integer capacityProfitNo;
    @SerializedName("lineCode")
    @Expose
    public String lineCode;
    @SerializedName("forceCarTimeLine")
    @Expose
    public Integer forceCarTimeLine;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("reserveHave_text")
    @Expose
    public String reserveHaveText;
    @SerializedName("autoCompleteLabel")
    @Expose
    public String autoCompleteLabel;
    @SerializedName("companyType")
    @Expose
    public Integer companyType;
    @SerializedName("companyType_text")
    @Expose
    public String companyTypeText;
    @SerializedName("dailyReportDateTo")
    @Expose
    public String dailyReportDateTo;
    @SerializedName("approvalNumber")
    @Expose
    public String approvalNumber;
    @SerializedName("serviceTime")
    @Expose
    public Integer serviceTime;
    @SerializedName("checkCardReader")
    @Expose
    public Boolean checkCardReader;
    @SerializedName("processStatus_text")
    @Expose
    public String processStatusText;
    @SerializedName("status_text")
    @Expose
    public String statusText;
    @SerializedName("forceCarTimeLine_text")
    @Expose
    public String forceCarTimeLineText;
    @SerializedName("autoCompleteLabel_Exp990203")
    @Expose
    public String autoCompleteLabelExp990203;
    @SerializedName("reserveHave")
    @Expose
    public Integer reserveHave;
    @SerializedName("startDate")
    @Expose
    public String startDate;
    @SerializedName("status")
    @Expose
    public Integer status;
    public final static Creator<LineCompanyProfit> CREATOR = new Creator<LineCompanyProfit>() {


        @SuppressWarnings({
            "unchecked"
        })
        public LineCompanyProfit createFromParcel(Parcel in) {
            return new LineCompanyProfit(in);
        }

        public LineCompanyProfit[] newArray(int size) {
            return (new LineCompanyProfit[size]);
        }

    }
    ;

    protected LineCompanyProfit(Parcel in) {
        this.dateCreation = ((String) in.readValue((String.class.getClassLoader())));
        this.serviceTimeText = ((String) in.readValue((String.class.getClassLoader())));
        this.approvalDate = ((String) in.readValue((String.class.getClassLoader())));
        this.nameFv = ((String) in.readValue((String.class.getClassLoader())));
        this.processStatus = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.codeProfitFV = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.capacityProfitNo = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.lineCode = ((String) in.readValue((String.class.getClassLoader())));
        this.forceCarTimeLine = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.reserveHaveText = ((String) in.readValue((String.class.getClassLoader())));
        this.autoCompleteLabel = ((String) in.readValue((String.class.getClassLoader())));
        this.companyType = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.companyTypeText = ((String) in.readValue((String.class.getClassLoader())));
        this.dailyReportDateTo = ((String) in.readValue((String.class.getClassLoader())));
        this.approvalNumber = ((String) in.readValue((String.class.getClassLoader())));
        this.serviceTime = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.checkCardReader = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.processStatusText = ((String) in.readValue((String.class.getClassLoader())));
        this.statusText = ((String) in.readValue((String.class.getClassLoader())));
        this.forceCarTimeLineText = ((String) in.readValue((String.class.getClassLoader())));
        this.autoCompleteLabelExp990203 = ((String) in.readValue((String.class.getClassLoader())));
        this.reserveHave = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.startDate = ((String) in.readValue((String.class.getClassLoader())));
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public LineCompanyProfit() {
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(dateCreation);
        dest.writeValue(serviceTimeText);
        dest.writeValue(approvalDate);
        dest.writeValue(nameFv);
        dest.writeValue(processStatus);
        dest.writeValue(codeProfitFV);
        dest.writeValue(description);
        dest.writeValue(capacityProfitNo);
        dest.writeValue(lineCode);
        dest.writeValue(forceCarTimeLine);
        dest.writeValue(id);
        dest.writeValue(reserveHaveText);
        dest.writeValue(autoCompleteLabel);
        dest.writeValue(companyType);
        dest.writeValue(companyTypeText);
        dest.writeValue(dailyReportDateTo);
        dest.writeValue(approvalNumber);
        dest.writeValue(serviceTime);
        dest.writeValue(checkCardReader);
        dest.writeValue(processStatusText);
        dest.writeValue(statusText);
        dest.writeValue(forceCarTimeLineText);
        dest.writeValue(autoCompleteLabelExp990203);
        dest.writeValue(reserveHave);
        dest.writeValue(startDate);
        dest.writeValue(status);
    }

    public int describeContents() {
        return  0;
    }

}
