
package gap.com.car.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DailyEventDetailList {

    @SerializedName("dateCreation")
    @Expose
    private String dateCreation;
    @SerializedName("showTimeRemainingUpForExpire")
    @Expose
    private Boolean showTimeRemainingUpForExpire;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("pathType")
    @Expose
    private Integer pathType;
    @SerializedName("pathType_text")
    @Expose
    private String pathTypeText;
    @SerializedName("inputMethodEn_text")
    @Expose
    private String inputMethodEnText;
    @SerializedName("lineCode")
    @Expose
    private String lineCode;
    @SerializedName("halfPathNo")
    @Expose
    private Integer halfPathNo;
    @SerializedName("inputMethodEn")
    @Expose
    private Integer inputMethodEn;
    @SerializedName("startTime")
    @Expose
    private String startTime;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("endTime")
    @Expose
    private String endTime;
    @SerializedName("status_text")
    @Expose
    private String statusText;
    @SerializedName("status")
    @Expose
    private Integer status;

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Boolean getShowTimeRemainingUpForExpire() {
        return showTimeRemainingUpForExpire;
    }

    public void setShowTimeRemainingUpForExpire(Boolean showTimeRemainingUpForExpire) {
        this.showTimeRemainingUpForExpire = showTimeRemainingUpForExpire;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPathType() {
        return pathType;
    }

    public void setPathType(Integer pathType) {
        this.pathType = pathType;
    }

    public String getPathTypeText() {
        return pathTypeText;
    }

    public void setPathTypeText(String pathTypeText) {
        this.pathTypeText = pathTypeText;
    }

    public String getInputMethodEnText() {
        return inputMethodEnText;
    }

    public void setInputMethodEnText(String inputMethodEnText) {
        this.inputMethodEnText = inputMethodEnText;
    }

    public String getLineCode() {
        return lineCode;
    }

    public void setLineCode(String lineCode) {
        this.lineCode = lineCode;
    }

    public Integer getHalfPathNo() {
        return halfPathNo;
    }

    public void setHalfPathNo(Integer halfPathNo) {
        this.halfPathNo = halfPathNo;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
