
package gap.com.car.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DailyEventListOld implements Parcelable
{

    @SerializedName("eventId")
    @Expose
    private Integer eventId;
    @SerializedName("dateCreation")
    @Expose
    private String dateCreation;
    @SerializedName("nameFv")
    @Expose
    private String nameFv;
    @SerializedName("processStatus")
    @Expose
    private Integer processStatus;
    @SerializedName("showTimeRemainingUpForExpire")
    @Expose
    private Boolean showTimeRemainingUpForExpire;
    @SerializedName("maxAcceptDateForStartTime")
    @Expose
    private String maxAcceptDateForStartTime;
    @SerializedName("nameFvBefore")
    @Expose
    private String nameFvBefore;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("planIs")
    @Expose
    private Boolean planIs;
    @SerializedName("inputMethodEn_text")
    @Expose
    private String inputMethodEnText;
    @SerializedName("processStatus_text")
    @Expose
    private String processStatusText;
    @SerializedName("reasonSysParamStr")
    @Expose
    private String reasonSysParamStr;
    @SerializedName("inputMethodEn")
    @Expose
    private Integer inputMethodEn;
    @SerializedName("startTime")
    @Expose
    private String startTime;
    @SerializedName("eventPositionEn")
    @Expose
    private Integer eventPositionEn;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("status_text")
    @Expose
    private String statusText;
    @SerializedName("eventPositionEn_text")
    @Expose
    private String eventPositionEnText;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("endTime")
    @Expose
    private String endTime;
    @SerializedName("sysParamStr")
    @Expose
    private String sysParamStr;
    @SerializedName("pathTypeOnPositionEn_text")
    @Expose
    private String pathTypeOnPositionEnText;
    @SerializedName("pathTypeOnPositionEn")
    @Expose
    private Integer pathTypeOnPositionEn;
    @SerializedName("car")
    @Expose
    private Car car;

    protected DailyEventListOld(Parcel in) {
        if (in.readByte() == 0) {
            eventId = null;
        } else {
            eventId = in.readInt();
        }
        dateCreation = in.readString();
        nameFv = in.readString();
        if (in.readByte() == 0) {
            processStatus = null;
        } else {
            processStatus = in.readInt();
        }
        byte tmpShowTimeRemainingUpForExpire = in.readByte();
        showTimeRemainingUpForExpire = tmpShowTimeRemainingUpForExpire == 0 ? null : tmpShowTimeRemainingUpForExpire == 1;
        maxAcceptDateForStartTime = in.readString();
        nameFvBefore = in.readString();
        description = in.readString();
        byte tmpPlanIs = in.readByte();
        planIs = tmpPlanIs == 0 ? null : tmpPlanIs == 1;
        inputMethodEnText = in.readString();
        processStatusText = in.readString();
        reasonSysParamStr = in.readString();
        if (in.readByte() == 0) {
            inputMethodEn = null;
        } else {
            inputMethodEn = in.readInt();
        }
        startTime = in.readString();
        if (in.readByte() == 0) {
            eventPositionEn = null;
        } else {
            eventPositionEn = in.readInt();
        }
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        statusText = in.readString();
        eventPositionEnText = in.readString();
        if (in.readByte() == 0) {
            status = null;
        } else {
            status = in.readInt();
        }
        endTime = in.readString();
        sysParamStr = in.readString();
        pathTypeOnPositionEnText = in.readString();
        if (in.readByte() == 0) {
            pathTypeOnPositionEn = null;
        } else {
            pathTypeOnPositionEn = in.readInt();
        }
        car = in.readParcelable(Car.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (eventId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(eventId);
        }
        dest.writeString(dateCreation);
        dest.writeString(nameFv);
        if (processStatus == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(processStatus);
        }
        dest.writeByte((byte) (showTimeRemainingUpForExpire == null ? 0 : showTimeRemainingUpForExpire ? 1 : 2));
        dest.writeString(maxAcceptDateForStartTime);
        dest.writeString(nameFvBefore);
        dest.writeString(description);
        dest.writeByte((byte) (planIs == null ? 0 : planIs ? 1 : 2));
        dest.writeString(inputMethodEnText);
        dest.writeString(processStatusText);
        dest.writeString(reasonSysParamStr);
        if (inputMethodEn == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(inputMethodEn);
        }
        dest.writeString(startTime);
        if (eventPositionEn == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(eventPositionEn);
        }
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        dest.writeString(statusText);
        dest.writeString(eventPositionEnText);
        if (status == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(status);
        }
        dest.writeString(endTime);
        dest.writeString(sysParamStr);
        dest.writeString(pathTypeOnPositionEnText);
        if (pathTypeOnPositionEn == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(pathTypeOnPositionEn);
        }
        dest.writeParcelable(car, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DailyEventListOld> CREATOR = new Creator<DailyEventListOld>() {
        @Override
        public DailyEventListOld createFromParcel(Parcel in) {
            return new DailyEventListOld(in);
        }

        @Override
        public DailyEventListOld[] newArray(int size) {
            return new DailyEventListOld[size];
        }
    };

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
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

    public Boolean getShowTimeRemainingUpForExpire() {
        return showTimeRemainingUpForExpire;
    }

    public void setShowTimeRemainingUpForExpire(Boolean showTimeRemainingUpForExpire) {
        this.showTimeRemainingUpForExpire = showTimeRemainingUpForExpire;
    }

    public String getMaxAcceptDateForStartTime() {
        return maxAcceptDateForStartTime;
    }

    public void setMaxAcceptDateForStartTime(String maxAcceptDateForStartTime) {
        this.maxAcceptDateForStartTime = maxAcceptDateForStartTime;
    }

    public String getNameFvBefore() {
        return nameFvBefore;
    }

    public void setNameFvBefore(String nameFvBefore) {
        this.nameFvBefore = nameFvBefore;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getPlanIs() {
        return planIs;
    }

    public void setPlanIs(Boolean planIs) {
        this.planIs = planIs;
    }

    public String getInputMethodEnText() {
        return inputMethodEnText;
    }

    public void setInputMethodEnText(String inputMethodEnText) {
        this.inputMethodEnText = inputMethodEnText;
    }

    public String getProcessStatusText() {
        return processStatusText;
    }

    public void setProcessStatusText(String processStatusText) {
        this.processStatusText = processStatusText;
    }

    public String getReasonSysParamStr() {
        return reasonSysParamStr;
    }

    public void setReasonSysParamStr(String reasonSysParamStr) {
        this.reasonSysParamStr = reasonSysParamStr;
    }

    public Integer getInputMethodEn() {
        return inputMethodEn;
    }

    public void setInputMethodEn(Integer inputMethodEn) {
        this.inputMethodEn = inputMethodEn;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Integer getEventPositionEn() {
        return eventPositionEn;
    }

    public void setEventPositionEn(Integer eventPositionEn) {
        this.eventPositionEn = eventPositionEn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public String getEventPositionEnText() {
        return eventPositionEnText;
    }

    public void setEventPositionEnText(String eventPositionEnText) {
        this.eventPositionEnText = eventPositionEnText;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getSysParamStr() {
        return sysParamStr;
    }

    public void setSysParamStr(String sysParamStr) {
        this.sysParamStr = sysParamStr;
    }

    public String getPathTypeOnPositionEnText() {
        return pathTypeOnPositionEnText;
    }

    public void setPathTypeOnPositionEnText(String pathTypeOnPositionEnText) {
        this.pathTypeOnPositionEnText = pathTypeOnPositionEnText;
    }

    public Integer getPathTypeOnPositionEn() {
        return pathTypeOnPositionEn;
    }

    public void setPathTypeOnPositionEn(Integer pathTypeOnPositionEn) {
        this.pathTypeOnPositionEn = pathTypeOnPositionEn;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
