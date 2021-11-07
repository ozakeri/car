
package gap.com.car.model.driverprofile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DriverProfileVO {

    @SerializedName("shiftTypeBaseEnNameFv")
    @Expose
    private String shiftTypeBaseEnNameFv;
    @SerializedName("dateCreation")
    @Expose
    private String dateCreation;
    @SerializedName("trainingDescription")
    @Expose
    private String trainingDescription;
    @SerializedName("driverShiftPlanStrFV")
    @Expose
    private String driverShiftPlanStrFV;
    @SerializedName("trainingDate")
    @Expose
    private String trainingDate;
    @SerializedName("nameFv")
    @Expose
    private String nameFv;
    @SerializedName("processStatus")
    @Expose
    private Integer processStatus;
    @SerializedName("driverLicenceStatus_text")
    @Expose
    private String driverLicenceStatusText;
    @SerializedName("dateLChangeProcessStatus")
    @Expose
    private String dateLChangeProcessStatus;
    @SerializedName("drivingLicence")
    @Expose
    private DrivingLicence drivingLicence;
    @SerializedName("trainingStatus")
    @Expose
    private Integer trainingStatus;
    @SerializedName("trainingStatus_text")
    @Expose
    private String trainingStatusText;
    @SerializedName("driverCode")
    @Expose
    private String driverCode;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("watchingIsLChProcessStatus")
    @Expose
    private Integer watchingIsLChProcessStatus;
    @SerializedName("shiftGroupGEn_text")
    @Expose
    private String shiftGroupGEnText;
    @SerializedName("driverHavePlanFV")
    @Expose
    private Boolean driverHavePlanFV;
    @SerializedName("company")
    @Expose
    private Company company;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("shiftTypeBaseEn")
    @Expose
    private Integer shiftTypeBaseEn;
    @SerializedName("requestedDriveLicenceEn")
    @Expose
    private Integer requestedDriveLicenceEn;
    @SerializedName("shiftTypeBaseEn_text")
    @Expose
    private String shiftTypeBaseEnText;
    @SerializedName("licence")
    @Expose
    private Licence licence;
    @SerializedName("autoCompleteLabel")
    @Expose
    private String autoCompleteLabel;
    @SerializedName("watchingIsLChProcessStatus_text")
    @Expose
    private String watchingIsLChProcessStatusText;
    @SerializedName("employmentDate")
    @Expose
    private String employmentDate;
    @SerializedName("driverLicenceStatus")
    @Expose
    private Integer driverLicenceStatus;
    @SerializedName("showTimeRemainingUpForExpire")
    @Expose
    private Boolean showTimeRemainingUpForExpire;
    @SerializedName("requestedDriveLicenceEn_text")
    @Expose
    private String requestedDriveLicenceEnText;
    @SerializedName("processStatus_text")
    @Expose
    private String processStatusText;
    @SerializedName("busFleetIs")
    @Expose
    private Boolean busFleetIs;
    @SerializedName("shiftGroupGEn")
    @Expose
    private Integer shiftGroupGEn;
    @SerializedName("nameFv1")
    @Expose
    private String nameFv1;
    @SerializedName("urbanFleetIs")
    @Expose
    private Boolean urbanFleetIs;
    @SerializedName("backIsLChProcessStatus")
    @Expose
    private Integer backIsLChProcessStatus;
    @SerializedName("person")
    @Expose
    private Person person;
    @SerializedName("backIsLChProcessStatus_text")
    @Expose
    private String backIsLChProcessStatusText;
    @SerializedName("driverJob")
    @Expose
    private DriverJob driverJob;
    @SerializedName("status_text")
    @Expose
    private String statusText;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("username")
    @Expose
    private String username;


    public String getShiftTypeBaseEnNameFv() {
        return shiftTypeBaseEnNameFv;
    }

    public void setShiftTypeBaseEnNameFv(String shiftTypeBaseEnNameFv) {
        this.shiftTypeBaseEnNameFv = shiftTypeBaseEnNameFv;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getTrainingDescription() {
        return trainingDescription;
    }

    public void setTrainingDescription(String trainingDescription) {
        this.trainingDescription = trainingDescription;
    }

    public String getDriverShiftPlanStrFV() {
        return driverShiftPlanStrFV;
    }

    public void setDriverShiftPlanStrFV(String driverShiftPlanStrFV) {
        this.driverShiftPlanStrFV = driverShiftPlanStrFV;
    }

    public String getTrainingDate() {
        return trainingDate;
    }

    public void setTrainingDate(String trainingDate) {
        this.trainingDate = trainingDate;
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

    public String getDriverLicenceStatusText() {
        return driverLicenceStatusText;
    }

    public void setDriverLicenceStatusText(String driverLicenceStatusText) {
        this.driverLicenceStatusText = driverLicenceStatusText;
    }

    public String getDateLChangeProcessStatus() {
        return dateLChangeProcessStatus;
    }

    public void setDateLChangeProcessStatus(String dateLChangeProcessStatus) {
        this.dateLChangeProcessStatus = dateLChangeProcessStatus;
    }

    public DrivingLicence getDrivingLicence() {
        return drivingLicence;
    }

    public void setDrivingLicence(DrivingLicence drivingLicence) {
        this.drivingLicence = drivingLicence;
    }

    public Integer getTrainingStatus() {
        return trainingStatus;
    }

    public void setTrainingStatus(Integer trainingStatus) {
        this.trainingStatus = trainingStatus;
    }

    public String getTrainingStatusText() {
        return trainingStatusText;
    }

    public void setTrainingStatusText(String trainingStatusText) {
        this.trainingStatusText = trainingStatusText;
    }

    public String getDriverCode() {
        return driverCode;
    }

    public void setDriverCode(String driverCode) {
        this.driverCode = driverCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getWatchingIsLChProcessStatus() {
        return watchingIsLChProcessStatus;
    }

    public void setWatchingIsLChProcessStatus(Integer watchingIsLChProcessStatus) {
        this.watchingIsLChProcessStatus = watchingIsLChProcessStatus;
    }

    public String getShiftGroupGEnText() {
        return shiftGroupGEnText;
    }

    public void setShiftGroupGEnText(String shiftGroupGEnText) {
        this.shiftGroupGEnText = shiftGroupGEnText;
    }

    public Boolean getDriverHavePlanFV() {
        return driverHavePlanFV;
    }

    public void setDriverHavePlanFV(Boolean driverHavePlanFV) {
        this.driverHavePlanFV = driverHavePlanFV;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShiftTypeBaseEn() {
        return shiftTypeBaseEn;
    }

    public void setShiftTypeBaseEn(Integer shiftTypeBaseEn) {
        this.shiftTypeBaseEn = shiftTypeBaseEn;
    }

    public Integer getRequestedDriveLicenceEn() {
        return requestedDriveLicenceEn;
    }

    public void setRequestedDriveLicenceEn(Integer requestedDriveLicenceEn) {
        this.requestedDriveLicenceEn = requestedDriveLicenceEn;
    }

    public String getShiftTypeBaseEnText() {
        return shiftTypeBaseEnText;
    }

    public void setShiftTypeBaseEnText(String shiftTypeBaseEnText) {
        this.shiftTypeBaseEnText = shiftTypeBaseEnText;
    }

    public Licence getLicence() {
        return licence;
    }

    public void setLicence(Licence licence) {
        this.licence = licence;
    }

    public String getAutoCompleteLabel() {
        return autoCompleteLabel;
    }

    public void setAutoCompleteLabel(String autoCompleteLabel) {
        this.autoCompleteLabel = autoCompleteLabel;
    }

    public String getWatchingIsLChProcessStatusText() {
        return watchingIsLChProcessStatusText;
    }

    public void setWatchingIsLChProcessStatusText(String watchingIsLChProcessStatusText) {
        this.watchingIsLChProcessStatusText = watchingIsLChProcessStatusText;
    }

    public String getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(String employmentDate) {
        this.employmentDate = employmentDate;
    }

    public Integer getDriverLicenceStatus() {
        return driverLicenceStatus;
    }

    public void setDriverLicenceStatus(Integer driverLicenceStatus) {
        this.driverLicenceStatus = driverLicenceStatus;
    }

    public Boolean getShowTimeRemainingUpForExpire() {
        return showTimeRemainingUpForExpire;
    }

    public void setShowTimeRemainingUpForExpire(Boolean showTimeRemainingUpForExpire) {
        this.showTimeRemainingUpForExpire = showTimeRemainingUpForExpire;
    }

    public String getRequestedDriveLicenceEnText() {
        return requestedDriveLicenceEnText;
    }

    public void setRequestedDriveLicenceEnText(String requestedDriveLicenceEnText) {
        this.requestedDriveLicenceEnText = requestedDriveLicenceEnText;
    }

    public String getProcessStatusText() {
        return processStatusText;
    }

    public void setProcessStatusText(String processStatusText) {
        this.processStatusText = processStatusText;
    }

    public Boolean getBusFleetIs() {
        return busFleetIs;
    }

    public void setBusFleetIs(Boolean busFleetIs) {
        this.busFleetIs = busFleetIs;
    }

    public Integer getShiftGroupGEn() {
        return shiftGroupGEn;
    }

    public void setShiftGroupGEn(Integer shiftGroupGEn) {
        this.shiftGroupGEn = shiftGroupGEn;
    }

    public String getNameFv1() {
        return nameFv1;
    }

    public void setNameFv1(String nameFv1) {
        this.nameFv1 = nameFv1;
    }

    public Boolean getUrbanFleetIs() {
        return urbanFleetIs;
    }

    public void setUrbanFleetIs(Boolean urbanFleetIs) {
        this.urbanFleetIs = urbanFleetIs;
    }

    public Integer getBackIsLChProcessStatus() {
        return backIsLChProcessStatus;
    }

    public void setBackIsLChProcessStatus(Integer backIsLChProcessStatus) {
        this.backIsLChProcessStatus = backIsLChProcessStatus;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getBackIsLChProcessStatusText() {
        return backIsLChProcessStatusText;
    }

    public void setBackIsLChProcessStatusText(String backIsLChProcessStatusText) {
        this.backIsLChProcessStatusText = backIsLChProcessStatusText;
    }

    public DriverJob getDriverJob() {
        return driverJob;
    }

    public void setDriverJob(DriverJob driverJob) {
        this.driverJob = driverJob;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
