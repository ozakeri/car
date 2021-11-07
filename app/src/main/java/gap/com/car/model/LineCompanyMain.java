
package gap.com.car.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LineCompanyMain implements Parcelable
{

    @SerializedName("dateCreation")
    @Expose
    private String dateCreation;
    @SerializedName("approvalDate")
    @Expose
    private String approvalDate;
    @SerializedName("serviceTime_text")
    @Expose
    private String serviceTimeText;
    @SerializedName("nameFv")
    @Expose
    private String nameFv;
    @SerializedName("processStatus")
    @Expose
    private Integer processStatus;
    @SerializedName("codeProfitFV")
    @Expose
    private String codeProfitFV;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("capacityProfitNo")
    @Expose
    private Integer capacityProfitNo;
    @SerializedName("codeProfit")
    @Expose
    private String codeProfit;
    @SerializedName("lineCode")
    @Expose
    private String lineCode;
    @SerializedName("forceCarTimeLine")
    @Expose
    private Integer forceCarTimeLine;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("reserveHave_text")
    @Expose
    private String reserveHaveText;
    @SerializedName("autoCompleteLabel")
    @Expose
    private String autoCompleteLabel;
    @SerializedName("companyType")
    @Expose
    private Integer companyType;
    @SerializedName("dailyReportDateTo")
    @Expose
    private String dailyReportDateTo;
    @SerializedName("companyType_text")
    @Expose
    private String companyTypeText;
    @SerializedName("approvalNumber")
    @Expose
    private String approvalNumber;
    @SerializedName("serviceTime")
    @Expose
    private Integer serviceTime;
    @SerializedName("processStatus_text")
    @Expose
    private String processStatusText;
    @SerializedName("status_text")
    @Expose
    private String statusText;
    @SerializedName("forceCarTimeLine_text")
    @Expose
    private String forceCarTimeLineText;
    @SerializedName("reserveHave")
    @Expose
    private Integer reserveHave;
    @SerializedName("startDate")
    @Expose
    private String startDate;
    @SerializedName("status")
    @Expose
    private Integer status;
    public final static Creator<LineCompanyMain> CREATOR = new Creator<LineCompanyMain>() {


        @SuppressWarnings({
            "unchecked"
        })
        public LineCompanyMain createFromParcel(Parcel in) {
            return new LineCompanyMain(in);
        }

        public LineCompanyMain[] newArray(int size) {
            return (new LineCompanyMain[size]);
        }

    }
    ;

    protected LineCompanyMain(Parcel in) {
        this.dateCreation = ((String) in.readValue((String.class.getClassLoader())));
        this.approvalDate = ((String) in.readValue((String.class.getClassLoader())));
        this.serviceTimeText = ((String) in.readValue((String.class.getClassLoader())));
        this.nameFv = ((String) in.readValue((String.class.getClassLoader())));
        this.processStatus = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.codeProfitFV = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.capacityProfitNo = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.codeProfit = ((String) in.readValue((String.class.getClassLoader())));
        this.lineCode = ((String) in.readValue((String.class.getClassLoader())));
        this.forceCarTimeLine = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.reserveHaveText = ((String) in.readValue((String.class.getClassLoader())));
        this.autoCompleteLabel = ((String) in.readValue((String.class.getClassLoader())));
        this.companyType = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.dailyReportDateTo = ((String) in.readValue((String.class.getClassLoader())));
        this.companyTypeText = ((String) in.readValue((String.class.getClassLoader())));
        this.approvalNumber = ((String) in.readValue((String.class.getClassLoader())));
        this.serviceTime = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.processStatusText = ((String) in.readValue((String.class.getClassLoader())));
        this.statusText = ((String) in.readValue((String.class.getClassLoader())));
        this.forceCarTimeLineText = ((String) in.readValue((String.class.getClassLoader())));
        this.reserveHave = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.startDate = ((String) in.readValue((String.class.getClassLoader())));
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public LineCompanyMain() {
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(String approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getServiceTimeText() {
        return serviceTimeText;
    }

    public void setServiceTimeText(String serviceTimeText) {
        this.serviceTimeText = serviceTimeText;
    }

    public String getNameFv() {
        return nameFv;
    }

    public void setNameFv(String nameFv) {
        this.nameFv = nameFv;
    }

    public Integer getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(Integer processStatus) {
        this.processStatus = processStatus;
    }

    public String getCodeProfitFV() {
        return codeProfitFV;
    }

    public void setCodeProfitFV(String codeProfitFV) {
        this.codeProfitFV = codeProfitFV;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCapacityProfitNo() {
        return capacityProfitNo;
    }

    public void setCapacityProfitNo(Integer capacityProfitNo) {
        this.capacityProfitNo = capacityProfitNo;
    }

    public String getCodeProfit() {
        return codeProfit;
    }

    public void setCodeProfit(String codeProfit) {
        this.codeProfit = codeProfit;
    }

    public String getLineCode() {
        return lineCode;
    }

    public void setLineCode(String lineCode) {
        this.lineCode = lineCode;
    }

    public Integer getForceCarTimeLine() {
        return forceCarTimeLine;
    }

    public void setForceCarTimeLine(Integer forceCarTimeLine) {
        this.forceCarTimeLine = forceCarTimeLine;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReserveHaveText() {
        return reserveHaveText;
    }

    public void setReserveHaveText(String reserveHaveText) {
        this.reserveHaveText = reserveHaveText;
    }

    public String getAutoCompleteLabel() {
        return autoCompleteLabel;
    }

    public void setAutoCompleteLabel(String autoCompleteLabel) {
        this.autoCompleteLabel = autoCompleteLabel;
    }

    public Integer getCompanyType() {
        return companyType;
    }

    public void setCompanyType(Integer companyType) {
        this.companyType = companyType;
    }

    public String getDailyReportDateTo() {
        return dailyReportDateTo;
    }

    public void setDailyReportDateTo(String dailyReportDateTo) {
        this.dailyReportDateTo = dailyReportDateTo;
    }

    public String getCompanyTypeText() {
        return companyTypeText;
    }

    public void setCompanyTypeText(String companyTypeText) {
        this.companyTypeText = companyTypeText;
    }

    public String getApprovalNumber() {
        return approvalNumber;
    }

    public void setApprovalNumber(String approvalNumber) {
        this.approvalNumber = approvalNumber;
    }

    public Integer getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(Integer serviceTime) {
        this.serviceTime = serviceTime;
    }

    public String getProcessStatusText() {
        return processStatusText;
    }

    public void setProcessStatusText(String processStatusText) {
        this.processStatusText = processStatusText;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public String getForceCarTimeLineText() {
        return forceCarTimeLineText;
    }

    public void setForceCarTimeLineText(String forceCarTimeLineText) {
        this.forceCarTimeLineText = forceCarTimeLineText;
    }

    public Integer getReserveHave() {
        return reserveHave;
    }

    public void setReserveHave(Integer reserveHave) {
        this.reserveHave = reserveHave;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(dateCreation);
        dest.writeValue(approvalDate);
        dest.writeValue(serviceTimeText);
        dest.writeValue(nameFv);
        dest.writeValue(processStatus);
        dest.writeValue(codeProfitFV);
        dest.writeValue(description);
        dest.writeValue(capacityProfitNo);
        dest.writeValue(codeProfit);
        dest.writeValue(lineCode);
        dest.writeValue(forceCarTimeLine);
        dest.writeValue(id);
        dest.writeValue(reserveHaveText);
        dest.writeValue(autoCompleteLabel);
        dest.writeValue(companyType);
        dest.writeValue(dailyReportDateTo);
        dest.writeValue(companyTypeText);
        dest.writeValue(approvalNumber);
        dest.writeValue(serviceTime);
        dest.writeValue(processStatusText);
        dest.writeValue(statusText);
        dest.writeValue(forceCarTimeLineText);
        dest.writeValue(reserveHave);
        dest.writeValue(startDate);
        dest.writeValue(status);
    }

    public int describeContents() {
        return  0;
    }

}
