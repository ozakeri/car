
package gap.com.car.model.driverprofile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Vehicle {

    @SerializedName("dateCreation")
    @Expose
    private String dateCreation;
    @SerializedName("autoCompleteLabel")
    @Expose
    private String autoCompleteLabel;
    @SerializedName("nameFv")
    @Expose
    private String nameFv;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("doorType")
    @Expose
    private Integer doorType;
    @SerializedName("cabinsNo")
    @Expose
    private Integer cabinsNo;
    @SerializedName("aveFuelUsage")
    @Expose
    private Integer aveFuelUsage;
    @SerializedName("vehicleType_text")
    @Expose
    private String vehicleTypeText;
    @SerializedName("cabinsNo_text")
    @Expose
    private String cabinsNoText;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("groupLevelEn")
    @Expose
    private Integer groupLevelEn;
    @SerializedName("groupLevelEn_text")
    @Expose
    private String groupLevelEnText;
    @SerializedName("minFuelUsage")
    @Expose
    private Integer minFuelUsage;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("status_text")
    @Expose
    private String statusText;
    @SerializedName("maxFuelUsage")
    @Expose
    private Integer maxFuelUsage;
    @SerializedName("doorType_text")
    @Expose
    private String doorTypeText;
    @SerializedName("vehicleType")
    @Expose
    private Integer vehicleType;
    @SerializedName("status")
    @Expose
    private Integer status;

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getAutoCompleteLabel() {
        return autoCompleteLabel;
    }

    public void setAutoCompleteLabel(String autoCompleteLabel) {
        this.autoCompleteLabel = autoCompleteLabel;
    }

    public String getNameFv() {
        return nameFv;
    }

    public void setNameFv(String nameFv) {
        this.nameFv = nameFv;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDoorType() {
        return doorType;
    }

    public void setDoorType(Integer doorType) {
        this.doorType = doorType;
    }

    public Integer getCabinsNo() {
        return cabinsNo;
    }

    public void setCabinsNo(Integer cabinsNo) {
        this.cabinsNo = cabinsNo;
    }

    public Integer getAveFuelUsage() {
        return aveFuelUsage;
    }

    public void setAveFuelUsage(Integer aveFuelUsage) {
        this.aveFuelUsage = aveFuelUsage;
    }

    public String getVehicleTypeText() {
        return vehicleTypeText;
    }

    public void setVehicleTypeText(String vehicleTypeText) {
        this.vehicleTypeText = vehicleTypeText;
    }

    public String getCabinsNoText() {
        return cabinsNoText;
    }

    public void setCabinsNoText(String cabinsNoText) {
        this.cabinsNoText = cabinsNoText;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGroupLevelEn() {
        return groupLevelEn;
    }

    public void setGroupLevelEn(Integer groupLevelEn) {
        this.groupLevelEn = groupLevelEn;
    }

    public String getGroupLevelEnText() {
        return groupLevelEnText;
    }

    public void setGroupLevelEnText(String groupLevelEnText) {
        this.groupLevelEnText = groupLevelEnText;
    }

    public Integer getMinFuelUsage() {
        return minFuelUsage;
    }

    public void setMinFuelUsage(Integer minFuelUsage) {
        this.minFuelUsage = minFuelUsage;
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

    public Integer getMaxFuelUsage() {
        return maxFuelUsage;
    }

    public void setMaxFuelUsage(Integer maxFuelUsage) {
        this.maxFuelUsage = maxFuelUsage;
    }

    public String getDoorTypeText() {
        return doorTypeText;
    }

    public void setDoorTypeText(String doorTypeText) {
        this.doorTypeText = doorTypeText;
    }

    public Integer getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(Integer vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
