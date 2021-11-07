
package gap.com.car.model.driverprofile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DriverJob {

    @SerializedName("dateCreation")
    @Expose
    private String dateCreation;
    @SerializedName("driverShiftPlanStrFV")
    @Expose
    private String driverShiftPlanStrFV;
    @SerializedName("processStatus")
    @Expose
    private Integer processStatus;
    @SerializedName("type_text")
    @Expose
    private String typeText;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("entityShift")
    @Expose
    private EntityShift entityShift;
    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("carPlanStrFV")
    @Expose
    private String carPlanStrFV;
    @SerializedName("processStatus_text")
    @Expose
    private String processStatusText;
    @SerializedName("driverJobTypeEn")
    @Expose
    private Integer driverJobTypeEn;
    @SerializedName("driverJobTypeEn_text")
    @Expose
    private String driverJobTypeEnText;
    @SerializedName("lineIsShowFV")
    @Expose
    private Boolean lineIsShowFV;
    @SerializedName("car")
    @Expose
    private Car car;
    @SerializedName("linePlanStrFV")
    @Expose
    private String linePlanStrFV;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("status_text")
    @Expose
    private String statusText;
    @SerializedName("startDate")
    @Expose
    private String startDate;
    @SerializedName("status")
    @Expose
    private Integer status;

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getDriverShiftPlanStrFV() {
        return driverShiftPlanStrFV;
    }

    public void setDriverShiftPlanStrFV(String driverShiftPlanStrFV) {
        this.driverShiftPlanStrFV = driverShiftPlanStrFV;
    }

    public Integer getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(Integer processStatus) {
        this.processStatus = processStatus;
    }

    public String getTypeText() {
        return typeText;
    }

    public void setTypeText(String typeText) {
        this.typeText = typeText;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EntityShift getEntityShift() {
        return entityShift;
    }

    public void setEntityShift(EntityShift entityShift) {
        this.entityShift = entityShift;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCarPlanStrFV() {
        return carPlanStrFV;
    }

    public void setCarPlanStrFV(String carPlanStrFV) {
        this.carPlanStrFV = carPlanStrFV;
    }

    public String getProcessStatusText() {
        return processStatusText;
    }

    public void setProcessStatusText(String processStatusText) {
        this.processStatusText = processStatusText;
    }

    public Integer getDriverJobTypeEn() {
        return driverJobTypeEn;
    }

    public void setDriverJobTypeEn(Integer driverJobTypeEn) {
        this.driverJobTypeEn = driverJobTypeEn;
    }

    public String getDriverJobTypeEnText() {
        return driverJobTypeEnText;
    }

    public void setDriverJobTypeEnText(String driverJobTypeEnText) {
        this.driverJobTypeEnText = driverJobTypeEnText;
    }

    public Boolean getLineIsShowFV() {
        return lineIsShowFV;
    }

    public void setLineIsShowFV(Boolean lineIsShowFV) {
        this.lineIsShowFV = lineIsShowFV;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getLinePlanStrFV() {
        return linePlanStrFV;
    }

    public void setLinePlanStrFV(String linePlanStrFV) {
        this.linePlanStrFV = linePlanStrFV;
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
}
