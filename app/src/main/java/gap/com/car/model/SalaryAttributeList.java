
package gap.com.car.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SalaryAttributeList implements Parcelable
{
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
    @SerializedName("endDate")
    @Expose
    private String endDate;
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
    private LineCompany lineCompany;
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
    @SerializedName("driverDailyActivity")
    @Expose
    private DriverDailyActivity driverDailyActivity;
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
    @SerializedName("dailyWorkTypeEn")
    @Expose
    private Integer dailyWorkTypeEn;
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
    @SerializedName("dailyWorkTypeEn_text")
    @Expose
    private String dailyWorkTypeEnText;
    @SerializedName("status_text")
    @Expose
    private String statusText;
    @SerializedName("overtimeFinal")
    @Expose
    private Integer overtimeFinal;
    @SerializedName("startDate")
    @Expose
    private String startDate;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("overtimeMonthly")
    @Expose
    private Integer overtimeMonthly;
    @SerializedName("calender")
    @Expose
    private SalaryCalender calender;

    protected SalaryAttributeList(Parcel in) {
        date = in.readString();
        if (in.readByte() == 0) {
            overtimeWork = null;
        } else {
            overtimeWork = in.readInt();
        }
        if (in.readByte() == 0) {
            processStatus = null;
        } else {
            processStatus = in.readInt();
        }
        if (in.readByte() == 0) {
            year = null;
        } else {
            year = in.readInt();
        }
        salaryTypeEnText = in.readString();
        endDate = in.readString();
        if (in.readByte() == 0) {
            salaryTypeEn = null;
        } else {
            salaryTypeEn = in.readInt();
        }
        if (in.readByte() == 0) {
            fractionPerform = null;
        } else {
            fractionPerform = in.readInt();
        }
        if (in.readByte() == 0) {
            absentDay = null;
        } else {
            absentDay = in.readInt();
        }
        lineCompany = in.readParcelable(LineCompany.class.getClassLoader());
        if (in.readByte() == 0) {
            halfPathNo = null;
        } else {
            halfPathNo = in.readInt();
        }
        if (in.readByte() == 0) {
            overtimeEncouraged = null;
        } else {
            overtimeEncouraged = in.readInt();
        }
        if (in.readByte() == 0) {
            workingDayUse = null;
        } else {
            workingDayUse = in.readInt();
        }
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        if (in.readByte() == 0) {
            nightWork = null;
        } else {
            nightWork = in.readInt();
        }
        if (in.readByte() == 0) {
            usefulWork = null;
        } else {
            usefulWork = in.readInt();
        }
        if (in.readByte() == 0) {
            incidentCount = null;
        } else {
            incidentCount = in.readInt();
        }
        if (in.readByte() == 0) {
            incidentPrice = null;
        } else {
            incidentPrice = in.readInt();
        }
        driverDailyActivity = in.readParcelable(DriverDailyActivity.class.getClassLoader());
        byte tmpShowTimeRemainingUpForExpire = in.readByte();
        showTimeRemainingUpForExpire = tmpShowTimeRemainingUpForExpire == 0 ? null : tmpShowTimeRemainingUpForExpire == 1;
        if (in.readByte() == 0) {
            overtimeWorkReal = null;
        } else {
            overtimeWorkReal = in.readInt();
        }
        if (in.readByte() == 0) {
            doubleWork = null;
        } else {
            doubleWork = in.readInt();
        }
        processStatusText = in.readString();
        if (in.readByte() == 0) {
            dailyWorkTypeEn = null;
        } else {
            dailyWorkTypeEn = in.readInt();
        }
        if (in.readByte() == 0) {
            fractionWork = null;
        } else {
            fractionWork = in.readInt();
        }
        if (in.readByte() == 0) {
            timeOffDay = null;
        } else {
            timeOffDay = in.readInt();
        }
        if (in.readByte() == 0) {
            month = null;
        } else {
            month = in.readInt();
        }
        if (in.readByte() == 0) {
            dutyWork = null;
        } else {
            dutyWork = in.readInt();
        }
        if (in.readByte() == 0) {
            workingDayCount = null;
        } else {
            workingDayCount = in.readInt();
        }
        dailyWorkTypeEnText = in.readString();
        statusText = in.readString();
        if (in.readByte() == 0) {
            overtimeFinal = null;
        } else {
            overtimeFinal = in.readInt();
        }
        startDate = in.readString();
        if (in.readByte() == 0) {
            status = null;
        } else {
            status = in.readInt();
        }
        if (in.readByte() == 0) {
            overtimeMonthly = null;
        } else {
            overtimeMonthly = in.readInt();
        }
        calender = in.readParcelable(SalaryCalender.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(date);
        if (overtimeWork == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(overtimeWork);
        }
        if (processStatus == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(processStatus);
        }
        if (year == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(year);
        }
        dest.writeString(salaryTypeEnText);
        dest.writeString(endDate);
        if (salaryTypeEn == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(salaryTypeEn);
        }
        if (fractionPerform == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(fractionPerform);
        }
        if (absentDay == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(absentDay);
        }
        dest.writeParcelable(lineCompany, flags);
        if (halfPathNo == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(halfPathNo);
        }
        if (overtimeEncouraged == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(overtimeEncouraged);
        }
        if (workingDayUse == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(workingDayUse);
        }
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        if (nightWork == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(nightWork);
        }
        if (usefulWork == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(usefulWork);
        }
        if (incidentCount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(incidentCount);
        }
        if (incidentPrice == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(incidentPrice);
        }
        dest.writeParcelable(driverDailyActivity, flags);
        dest.writeByte((byte) (showTimeRemainingUpForExpire == null ? 0 : showTimeRemainingUpForExpire ? 1 : 2));
        if (overtimeWorkReal == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(overtimeWorkReal);
        }
        if (doubleWork == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(doubleWork);
        }
        dest.writeString(processStatusText);
        if (dailyWorkTypeEn == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(dailyWorkTypeEn);
        }
        if (fractionWork == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(fractionWork);
        }
        if (timeOffDay == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(timeOffDay);
        }
        if (month == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(month);
        }
        if (dutyWork == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(dutyWork);
        }
        if (workingDayCount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(workingDayCount);
        }
        dest.writeString(dailyWorkTypeEnText);
        dest.writeString(statusText);
        if (overtimeFinal == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(overtimeFinal);
        }
        dest.writeString(startDate);
        if (status == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(status);
        }
        if (overtimeMonthly == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(overtimeMonthly);
        }
        dest.writeParcelable(calender, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SalaryAttributeList> CREATOR = new Creator<SalaryAttributeList>() {
        @Override
        public SalaryAttributeList createFromParcel(Parcel in) {
            return new SalaryAttributeList(in);
        }

        @Override
        public SalaryAttributeList[] newArray(int size) {
            return new SalaryAttributeList[size];
        }
    };

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

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
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

    public LineCompany getLineCompany() {
        return lineCompany;
    }

    public void setLineCompany(LineCompany lineCompany) {
        this.lineCompany = lineCompany;
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

    public DriverDailyActivity getDriverDailyActivity() {
        return driverDailyActivity;
    }

    public void setDriverDailyActivity(DriverDailyActivity driverDailyActivity) {
        this.driverDailyActivity = driverDailyActivity;
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

    public Integer getDailyWorkTypeEn() {
        return dailyWorkTypeEn;
    }

    public void setDailyWorkTypeEn(Integer dailyWorkTypeEn) {
        this.dailyWorkTypeEn = dailyWorkTypeEn;
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

    public String getDailyWorkTypeEnText() {
        return dailyWorkTypeEnText;
    }

    public void setDailyWorkTypeEnText(String dailyWorkTypeEnText) {
        this.dailyWorkTypeEnText = dailyWorkTypeEnText;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public Integer getOvertimeFinal() {
        return overtimeFinal;
    }

    public void setOvertimeFinal(Integer overtimeFinal) {
        this.overtimeFinal = overtimeFinal;
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

    public Integer getOvertimeMonthly() {
        return overtimeMonthly;
    }

    public void setOvertimeMonthly(Integer overtimeMonthly) {
        this.overtimeMonthly = overtimeMonthly;
    }

    public SalaryCalender getCalender() {
        return calender;
    }

    public void setCalender(SalaryCalender calender) {
        this.calender = calender;
    }
}
