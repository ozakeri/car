
package gap.com.car.model;

import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SalaryAttribute implements Parcelable {

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("overtimeWork")
    @Expose
    private Integer overtimeWork;
    @SerializedName("processStatus")
    @Expose
    private Integer processStatus;
    @SerializedName("year")
    @Expose
    private Integer year;
    @SerializedName("salaryTypeEn_text")
    @Expose
    private String salaryTypeEnText;
    @SerializedName("salaryTypeEn")
    @Expose
    private Integer salaryTypeEn;
    @SerializedName("fractionPerform")
    @Expose
    private Integer fractionPerform;
    @SerializedName("absentDay")
    @Expose
    private Integer absentDay;
    @SerializedName("lineCompany")
    @Expose
    private LineCompanyMain lineCompany;
    @SerializedName("driverDailyActivity")
    @Expose
    private DriverDailyActivity driverDailyActivity;
    @SerializedName("halfPathNo")
    @Expose
    private Integer halfPathNo;
    @SerializedName("overtimeEncouraged")
    @Expose
    private Integer overtimeEncouraged;
    @SerializedName("workingDayUse")
    @Expose
    private Integer workingDayUse;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("nightWork")
    @Expose
    private Integer nightWork;
    @SerializedName("usefulWork")
    @Expose
    private Integer usefulWork;
    @SerializedName("incidentCount")
    @Expose
    private Integer incidentCount;
    @SerializedName("incidentPrice")
    @Expose
    private Integer incidentPrice;
    @SerializedName("showTimeRemainingUpForExpire")
    @Expose
    private Boolean showTimeRemainingUpForExpire;
    @SerializedName("overtimeWorkReal")
    @Expose
    private Integer overtimeWorkReal;
    @SerializedName("doubleWork")
    @Expose
    private Integer doubleWork;
    @SerializedName("processStatus_text")
    @Expose
    private String processStatusText;
    @SerializedName("fractionWork")
    @Expose
    private Integer fractionWork;
    @SerializedName("timeOffDay")
    @Expose
    private Integer timeOffDay;
    @SerializedName("month")
    @Expose
    private Integer month;
    @SerializedName("dutyWork")
    @Expose
    private Integer dutyWork;
    @SerializedName("workingDayCount")
    @Expose
    private Integer workingDayCount;
    @SerializedName("salaryAttributeList")
    @Expose
    private List<SalaryAttributeList> salaryAttributeList = null;
    @SerializedName("status_text")
    @Expose
    private String statusText;
    @SerializedName("salaryAttributeChildVOListSize")
    @Expose
    private Integer salaryAttributeChildVOListSize;
    @SerializedName("overtimeFinal")
    @Expose
    private Integer overtimeFinal;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("overtimeMonthly")
    @Expose
    private Integer overtimeMonthly;
    @SerializedName("dailyWorkTypeEn")
    @Expose
    private Integer dailyWorkTypeEn;

    @SerializedName("startDate")
    @Expose
    private String startDate;
    @SerializedName("endDate")
    @Expose
    private String endDate;

    public final static Creator<SalaryAttribute> CREATOR = new Creator<SalaryAttribute>() {


        @SuppressWarnings({
                "unchecked"
        })
        public SalaryAttribute createFromParcel(Parcel in) {
            return new SalaryAttribute(in);
        }

        public SalaryAttribute[] newArray(int size) {
            return (new SalaryAttribute[size]);
        }

    };

    protected SalaryAttribute(Parcel in) {
        this.date = ((String) in.readValue((String.class.getClassLoader())));
        this.overtimeWork = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.processStatus = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.year = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.salaryTypeEnText = ((String) in.readValue((String.class.getClassLoader())));
        this.salaryTypeEn = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.fractionPerform = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.absentDay = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.lineCompany = ((LineCompanyMain) in.readValue((LineCompanyMain.class.getClassLoader())));
        this.halfPathNo = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.overtimeEncouraged = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.workingDayUse = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.nightWork = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.usefulWork = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.incidentCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.incidentPrice = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.showTimeRemainingUpForExpire = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.overtimeWorkReal = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.doubleWork = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.processStatusText = ((String) in.readValue((String.class.getClassLoader())));
        this.fractionWork = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.timeOffDay = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.month = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.dutyWork = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.workingDayCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.salaryAttributeList, (SalaryAttributeList.class.getClassLoader()));
        this.statusText = ((String) in.readValue((String.class.getClassLoader())));
        this.salaryAttributeChildVOListSize = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.overtimeFinal = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.overtimeMonthly = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.driverDailyActivity = ((DriverDailyActivity) in.readValue((DriverDailyActivity.class.getClassLoader())));
        this.dailyWorkTypeEn = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.startDate = ((String) in.readValue((Integer.class.getClassLoader())));
        this.endDate = ((String) in.readValue((Integer.class.getClassLoader())));
    }

    public SalaryAttribute() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getOvertimeWork() {
        return overtimeWork;
    }

    public void setOvertimeWork(Integer overtimeWork) {
        this.overtimeWork = overtimeWork;
    }

    public Integer getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(Integer processStatus) {
        this.processStatus = processStatus;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getSalaryTypeEnText() {
        return salaryTypeEnText;
    }

    public void setSalaryTypeEnText(String salaryTypeEnText) {
        this.salaryTypeEnText = salaryTypeEnText;
    }

    public Integer getSalaryTypeEn() {
        return salaryTypeEn;
    }

    public void setSalaryTypeEn(Integer salaryTypeEn) {
        this.salaryTypeEn = salaryTypeEn;
    }

    public Integer getFractionPerform() {
        return fractionPerform;
    }

    public void setFractionPerform(Integer fractionPerform) {
        this.fractionPerform = fractionPerform;
    }

    public Integer getAbsentDay() {
        return absentDay;
    }

    public void setAbsentDay(Integer absentDay) {
        this.absentDay = absentDay;
    }

    public LineCompanyMain getLineCompanyMain() {
        return lineCompany;
    }

    public void setLineCompanyMain(LineCompanyMain lineCompanyMain) {
        this.lineCompany = lineCompanyMain;
    }

    public Integer getHalfPathNo() {
        return halfPathNo;
    }

    public void setHalfPathNo(Integer halfPathNo) {
        this.halfPathNo = halfPathNo;
    }

    public Integer getOvertimeEncouraged() {
        return overtimeEncouraged;
    }

    public void setOvertimeEncouraged(Integer overtimeEncouraged) {
        this.overtimeEncouraged = overtimeEncouraged;
    }

    public Integer getWorkingDayUse() {
        return workingDayUse;
    }

    public void setWorkingDayUse(Integer workingDayUse) {
        this.workingDayUse = workingDayUse;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNightWork() {
        return nightWork;
    }

    public void setNightWork(Integer nightWork) {
        this.nightWork = nightWork;
    }

    public Integer getUsefulWork() {
        return usefulWork;
    }

    public void setUsefulWork(Integer usefulWork) {
        this.usefulWork = usefulWork;
    }

    public Integer getIncidentCount() {
        return incidentCount;
    }

    public void setIncidentCount(Integer incidentCount) {
        this.incidentCount = incidentCount;
    }

    public Integer getIncidentPrice() {
        return incidentPrice;
    }

    public void setIncidentPrice(Integer incidentPrice) {
        this.incidentPrice = incidentPrice;
    }

    public Boolean getShowTimeRemainingUpForExpire() {
        return showTimeRemainingUpForExpire;
    }

    public void setShowTimeRemainingUpForExpire(Boolean showTimeRemainingUpForExpire) {
        this.showTimeRemainingUpForExpire = showTimeRemainingUpForExpire;
    }

    public Integer getOvertimeWorkReal() {
        return overtimeWorkReal;
    }

    public void setOvertimeWorkReal(Integer overtimeWorkReal) {
        this.overtimeWorkReal = overtimeWorkReal;
    }

    public Integer getDoubleWork() {
        return doubleWork;
    }

    public void setDoubleWork(Integer doubleWork) {
        this.doubleWork = doubleWork;
    }

    public String getProcessStatusText() {
        return processStatusText;
    }

    public void setProcessStatusText(String processStatusText) {
        this.processStatusText = processStatusText;
    }

    public Integer getFractionWork() {
        return fractionWork;
    }

    public void setFractionWork(Integer fractionWork) {
        this.fractionWork = fractionWork;
    }

    public Integer getTimeOffDay() {
        return timeOffDay;
    }

    public void setTimeOffDay(Integer timeOffDay) {
        this.timeOffDay = timeOffDay;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDutyWork() {
        return dutyWork;
    }

    public void setDutyWork(Integer dutyWork) {
        this.dutyWork = dutyWork;
    }

    public Integer getWorkingDayCount() {
        return workingDayCount;
    }

    public void setWorkingDayCount(Integer workingDayCount) {
        this.workingDayCount = workingDayCount;
    }

    public List<SalaryAttributeList> getSalaryAttributeList() {
        return salaryAttributeList;
    }

    public void setSalaryAttributeList(List<SalaryAttributeList> salaryAttributeList) {
        this.salaryAttributeList = salaryAttributeList;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public Integer getSalaryAttributeChildVOListSize() {
        return salaryAttributeChildVOListSize;
    }

    public void setSalaryAttributeChildVOListSize(Integer salaryAttributeChildVOListSize) {
        this.salaryAttributeChildVOListSize = salaryAttributeChildVOListSize;
    }

    public Integer getOvertimeFinal() {
        return overtimeFinal;
    }

    public void setOvertimeFinal(Integer overtimeFinal) {
        this.overtimeFinal = overtimeFinal;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOvertimeMonthly() {
        return overtimeMonthly;
    }

    public void setOvertimeMonthly(Integer overtimeMonthly) {
        this.overtimeMonthly = overtimeMonthly;
    }

    public DriverDailyActivity getDriverDailyActivity() {
        return driverDailyActivity;
    }

    public void setDriverDailyActivity(DriverDailyActivity driverDailyActivity) {
        this.driverDailyActivity = driverDailyActivity;
    }

    public Integer getDailyWorkTypeEn() {
        return dailyWorkTypeEn;
    }

    public void setDailyWorkTypeEn(Integer dailyWorkTypeEn) {
        this.dailyWorkTypeEn = dailyWorkTypeEn;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(date);
        dest.writeValue(overtimeWork);
        dest.writeValue(processStatus);
        dest.writeValue(year);
        dest.writeValue(salaryTypeEnText);
        dest.writeValue(salaryTypeEn);
        dest.writeValue(fractionPerform);
        dest.writeValue(absentDay);
        dest.writeValue(lineCompany);
        dest.writeValue(halfPathNo);
        dest.writeValue(overtimeEncouraged);
        dest.writeValue(workingDayUse);
        dest.writeValue(id);
        dest.writeValue(nightWork);
        dest.writeValue(usefulWork);
        dest.writeValue(incidentCount);
        dest.writeValue(incidentPrice);
        dest.writeValue(showTimeRemainingUpForExpire);
        dest.writeValue(overtimeWorkReal);
        dest.writeValue(doubleWork);
        dest.writeValue(processStatusText);
        dest.writeValue(fractionWork);
        dest.writeValue(timeOffDay);
        dest.writeValue(month);
        dest.writeValue(dutyWork);
        dest.writeValue(workingDayCount);
        dest.writeList(salaryAttributeList);
        dest.writeValue(statusText);
        dest.writeValue(salaryAttributeChildVOListSize);
        dest.writeValue(overtimeFinal);
        dest.writeValue(status);
        dest.writeValue(overtimeMonthly);
        dest.writeValue(driverDailyActivity);
        dest.writeValue(dailyWorkTypeEn);
        dest.writeValue(startDate);
        dest.writeValue(endDate);
    }

    public int describeContents() {
        return 0;
    }

}
