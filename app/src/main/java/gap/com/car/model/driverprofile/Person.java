
package gap.com.car.model.driverprofile;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Person {

    @SerializedName("liveStatus_text")
    @Expose
    private String liveStatusText;
    @SerializedName("fatherName")
    @Expose
    private String fatherName;
    @SerializedName("gender_text")
    @Expose
    private String genderText;
    @SerializedName("nationalCode")
    @Expose
    private String nationalCode;
    @SerializedName("dateCreation")
    @Expose
    private String dateCreation;
    @SerializedName("gender")
    @Expose
    private Integer gender;
    @SerializedName("nameFv")
    @Expose
    private String nameFv;
    @SerializedName("processStatus")
    @Expose
    private Integer processStatus;
    @SerializedName("dateLastChange")
    @Expose
    private String dateLastChange;
    @SerializedName("ageFV")
    @Expose
    private Integer ageFV;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("militaryServiceStatus")
    @Expose
    private Integer militaryServiceStatus;
    @SerializedName("idNo")
    @Expose
    private String idNo;
    @SerializedName("pictureAF")
    @Expose
    private PictureAF pictureAF;
    @SerializedName("employeeCode")
    @Expose
    private String employeeCode;
    @SerializedName("lastEducationField")
    @Expose
    private String lastEducationField;
    @SerializedName("lastEducationUni")
    @Expose
    private String lastEducationUni;
    @SerializedName("birthdayCityProvinceId")
    @Expose
    private Integer birthdayCityProvinceId;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("lastEducationDate")
    @Expose
    private String lastEducationDate;
    @SerializedName("liveStatus")
    @Expose
    private Integer liveStatus;
    @SerializedName("idNoCityId")
    @Expose
    private Integer idNoCityId;
    @SerializedName("idSerial")
    @Expose
    private String idSerial;
    @SerializedName("pictureBytes")
    @Expose
    private List<Integer> pictureBytes = null;
    @SerializedName("autoCompleteLabel")
    @Expose
    private String autoCompleteLabel;
    @SerializedName("address")
    @Expose
    private Address address;
    @SerializedName("birthdayCityId")
    @Expose
    private Integer birthdayCityId;
    @SerializedName("idNoCityProvinceId")
    @Expose
    private Integer idNoCityProvinceId;
    @SerializedName("maritalStatusEn_text")
    @Expose
    private String maritalStatusEnText;
    @SerializedName("processStatus_text")
    @Expose
    private String processStatusText;
    @SerializedName("birthdayDate")
    @Expose
    private String birthdayDate;
    @SerializedName("lastEducationLevel_text")
    @Expose
    private String lastEducationLevelText;
    @SerializedName("insuranceNo")
    @Expose
    private String insuranceNo;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("lastEducationLevel")
    @Expose
    private Integer lastEducationLevel;
    @SerializedName("status_text")
    @Expose
    private String statusText;
    @SerializedName("family")
    @Expose
    private String family;
    @SerializedName("maritalStatusEn")
    @Expose
    private Integer maritalStatusEn;
    @SerializedName("militaryServiceStatus_text")
    @Expose
    private String militaryServiceStatusText;
    @SerializedName("status")
    @Expose
    private Integer status;

    public String getLiveStatusText() {
        return liveStatusText;
    }

    public void setLiveStatusText(String liveStatusText) {
        this.liveStatusText = liveStatusText;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getGenderText() {
        return genderText;
    }

    public void setGenderText(String genderText) {
        this.genderText = genderText;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
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

    public String getDateLastChange() {
        return dateLastChange;
    }

    public void setDateLastChange(String dateLastChange) {
        this.dateLastChange = dateLastChange;
    }

    public Integer getAgeFV() {
        return ageFV;
    }

    public void setAgeFV(Integer ageFV) {
        this.ageFV = ageFV;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMilitaryServiceStatus() {
        return militaryServiceStatus;
    }

    public void setMilitaryServiceStatus(Integer militaryServiceStatus) {
        this.militaryServiceStatus = militaryServiceStatus;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public PictureAF getPictureAF() {
        return pictureAF;
    }

    public void setPictureAF(PictureAF pictureAF) {
        this.pictureAF = pictureAF;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getLastEducationField() {
        return lastEducationField;
    }

    public void setLastEducationField(String lastEducationField) {
        this.lastEducationField = lastEducationField;
    }

    public String getLastEducationUni() {
        return lastEducationUni;
    }

    public void setLastEducationUni(String lastEducationUni) {
        this.lastEducationUni = lastEducationUni;
    }

    public Integer getBirthdayCityProvinceId() {
        return birthdayCityProvinceId;
    }

    public void setBirthdayCityProvinceId(Integer birthdayCityProvinceId) {
        this.birthdayCityProvinceId = birthdayCityProvinceId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastEducationDate() {
        return lastEducationDate;
    }

    public void setLastEducationDate(String lastEducationDate) {
        this.lastEducationDate = lastEducationDate;
    }

    public Integer getLiveStatus() {
        return liveStatus;
    }

    public void setLiveStatus(Integer liveStatus) {
        this.liveStatus = liveStatus;
    }

    public Integer getIdNoCityId() {
        return idNoCityId;
    }

    public void setIdNoCityId(Integer idNoCityId) {
        this.idNoCityId = idNoCityId;
    }

    public String getIdSerial() {
        return idSerial;
    }

    public void setIdSerial(String idSerial) {
        this.idSerial = idSerial;
    }

    public List<Integer> getPictureBytes() {
        return pictureBytes;
    }

    public void setPictureBytes(List<Integer> pictureBytes) {
        this.pictureBytes = pictureBytes;
    }

    public String getAutoCompleteLabel() {
        return autoCompleteLabel;
    }

    public void setAutoCompleteLabel(String autoCompleteLabel) {
        this.autoCompleteLabel = autoCompleteLabel;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getBirthdayCityId() {
        return birthdayCityId;
    }

    public void setBirthdayCityId(Integer birthdayCityId) {
        this.birthdayCityId = birthdayCityId;
    }

    public Integer getIdNoCityProvinceId() {
        return idNoCityProvinceId;
    }

    public void setIdNoCityProvinceId(Integer idNoCityProvinceId) {
        this.idNoCityProvinceId = idNoCityProvinceId;
    }

    public String getMaritalStatusEnText() {
        return maritalStatusEnText;
    }

    public void setMaritalStatusEnText(String maritalStatusEnText) {
        this.maritalStatusEnText = maritalStatusEnText;
    }

    public String getProcessStatusText() {
        return processStatusText;
    }

    public void setProcessStatusText(String processStatusText) {
        this.processStatusText = processStatusText;
    }

    public String getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(String birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public String getLastEducationLevelText() {
        return lastEducationLevelText;
    }

    public void setLastEducationLevelText(String lastEducationLevelText) {
        this.lastEducationLevelText = lastEducationLevelText;
    }

    public String getInsuranceNo() {
        return insuranceNo;
    }

    public void setInsuranceNo(String insuranceNo) {
        this.insuranceNo = insuranceNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLastEducationLevel() {
        return lastEducationLevel;
    }

    public void setLastEducationLevel(Integer lastEducationLevel) {
        this.lastEducationLevel = lastEducationLevel;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public Integer getMaritalStatusEn() {
        return maritalStatusEn;
    }

    public void setMaritalStatusEn(Integer maritalStatusEn) {
        this.maritalStatusEn = maritalStatusEn;
    }

    public String getMilitaryServiceStatusText() {
        return militaryServiceStatusText;
    }

    public void setMilitaryServiceStatusText(String militaryServiceStatusText) {
        this.militaryServiceStatusText = militaryServiceStatusText;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
