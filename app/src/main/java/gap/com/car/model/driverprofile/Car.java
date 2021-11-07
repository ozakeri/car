
package gap.com.car.model.driverprofile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Car {

    @SerializedName("deliveryToCompany")
    @Expose
    private String deliveryToCompany;
    @SerializedName("dateCreation")
    @Expose
    private String dateCreation;
    @SerializedName("nameFv")
    @Expose
    private String nameFv;
    @SerializedName("processStatus")
    @Expose
    private Integer processStatus;
    @SerializedName("ageFV")
    @Expose
    private Integer ageFV;
    @SerializedName("vinNo")
    @Expose
    private String vinNo;
    @SerializedName("parkingDefTypeEn")
    @Expose
    private Integer parkingDefTypeEn;
    @SerializedName("usageTypeEn")
    @Expose
    private Integer usageTypeEn;
    @SerializedName("activityStatusCanBeWorkFS")
    @Expose
    private Boolean activityStatusCanBeWorkFS;
    @SerializedName("propertyCode")
    @Expose
    private String propertyCode;
    @SerializedName("engineFuelType")
    @Expose
    private Integer engineFuelType;
    @SerializedName("carStatusInParkDescFV")
    @Expose
    private String carStatusInParkDescFV;
    @SerializedName("currentActStatus_text")
    @Expose
    private String currentActStatusText;
    @SerializedName("activityStatus")
    @Expose
    private Integer activityStatus;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("carMustDispatchForAdvertisement")
    @Expose
    private Boolean carMustDispatchForAdvertisement;
    @SerializedName("cardReaderHave")
    @Expose
    private Integer cardReaderHave;
    @SerializedName("engineNo")
    @Expose
    private String engineNo;
    @SerializedName("fuelCardNo")
    @Expose
    private String fuelCardNo;
    @SerializedName("dateConfirm1")
    @Expose
    private String dateConfirm1;
    @SerializedName("engineFuelType_text")
    @Expose
    private String engineFuelTypeText;
    @SerializedName("showTimeRemainingUpForExpire")
    @Expose
    private Boolean showTimeRemainingUpForExpire;
    @SerializedName("chassis")
    @Expose
    private String chassis;
    @SerializedName("parkingDefTypeEn_text")
    @Expose
    private String parkingDefTypeEnText;
    @SerializedName("carDeliverIs")
    @Expose
    private Integer carDeliverIs;
    @SerializedName("urbanFleetIs")
    @Expose
    private Boolean urbanFleetIs;
    @SerializedName("afcCode")
    @Expose
    private String afcCode;
    @SerializedName("plateText")
    @Expose
    private String plateText;
    @SerializedName("activityStatusIsStopFS")
    @Expose
    private Boolean activityStatusIsStopFS;
    @SerializedName("status_text")
    @Expose
    private String statusText;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("seatTypeEn")
    @Expose
    private Integer seatTypeEn;
    @SerializedName("currentActStatus")
    @Expose
    private Integer currentActStatus;
    @SerializedName("usageTypeEn_text")
    @Expose
    private String usageTypeEnText;
    @SerializedName("gasStationDefTypeEn")
    @Expose
    private Integer gasStationDefTypeEn;
    @SerializedName("dateLastChange")
    @Expose
    private String dateLastChange;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("colorTabLicAttachment")
    @Expose
    private String colorTabLicAttachment;
    @SerializedName("activityStatus_text")
    @Expose
    private String activityStatusText;
    @SerializedName("carStatusInParkNameFV")
    @Expose
    private String carStatusInParkNameFV;
    @SerializedName("productionYear")
    @Expose
    private Integer productionYear;
    @SerializedName("enableDeliverPerson")
    @Expose
    private Integer enableDeliverPerson;
    @SerializedName("carDeliverIs_text")
    @Expose
    private String carDeliverIsText;
    @SerializedName("colorStyleClass")
    @Expose
    private String colorStyleClass;
    @SerializedName("vehicle")
    @Expose
    private Vehicle vehicle;
    @SerializedName("carStatusInPark")
    @Expose
    private Integer carStatusInPark;
    @SerializedName("enableDeliverPerson_text")
    @Expose
    private String enableDeliverPersonText;
    @SerializedName("seatTypeEn_text")
    @Expose
    private String seatTypeEnText;
    @SerializedName("carStatusInPark_text")
    @Expose
    private String carStatusInParkText;
    @SerializedName("deliveryDate")
    @Expose
    private String deliveryDate;
    @SerializedName("autoCompleteLabel")
    @Expose
    private String autoCompleteLabel;
    @SerializedName("plateNo")
    @Expose
    private String plateNo;
    @SerializedName("carStopReasonFV")
    @Expose
    private String carStopReasonFV;
    @SerializedName("coolerStatus")
    @Expose
    private Integer coolerStatus;
    @SerializedName("changeCarPlateIsPossible")
    @Expose
    private Boolean changeCarPlateIsPossible;
    @SerializedName("processStatus_text")
    @Expose
    private String processStatusText;
    @SerializedName("colorTabCar")
    @Expose
    private String colorTabCar;
    @SerializedName("busFleetIs")
    @Expose
    private Boolean busFleetIs;
    @SerializedName("nameFv1")
    @Expose
    private String nameFv1;
    @SerializedName("fuelType")
    @Expose
    private Integer fuelType;
    @SerializedName("carStatusInParkStrFV")
    @Expose
    private String carStatusInParkStrFV;
    @SerializedName("nameFv2")
    @Expose
    private String nameFv2;
    @SerializedName("colorTabCarProfit")
    @Expose
    private String colorTabCarProfit;
    @SerializedName("cardReaderHave_text")
    @Expose
    private String cardReaderHaveText;
    @SerializedName("coolerStatus_text")
    @Expose
    private String coolerStatusText;
    @SerializedName("carStopDescFV")
    @Expose
    private String carStopDescFV;
    @SerializedName("gasStationDefTypeEn_text")
    @Expose
    private String gasStationDefTypeEnText;
    @SerializedName("fuelType_text")
    @Expose
    private String fuelTypeText;
    @SerializedName("colorTabLicCarUF")
    @Expose
    private String colorTabLicCarUF;

    public String getDeliveryToCompany() {
        return deliveryToCompany;
    }

    public void setDeliveryToCompany(String deliveryToCompany) {
        this.deliveryToCompany = deliveryToCompany;
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

    public Integer getAgeFV() {
        return ageFV;
    }

    public void setAgeFV(Integer ageFV) {
        this.ageFV = ageFV;
    }

    public String getVinNo() {
        return vinNo;
    }

    public void setVinNo(String vinNo) {
        this.vinNo = vinNo;
    }

    public Integer getParkingDefTypeEn() {
        return parkingDefTypeEn;
    }

    public void setParkingDefTypeEn(Integer parkingDefTypeEn) {
        this.parkingDefTypeEn = parkingDefTypeEn;
    }

    public Integer getUsageTypeEn() {
        return usageTypeEn;
    }

    public void setUsageTypeEn(Integer usageTypeEn) {
        this.usageTypeEn = usageTypeEn;
    }

    public Boolean getActivityStatusCanBeWorkFS() {
        return activityStatusCanBeWorkFS;
    }

    public void setActivityStatusCanBeWorkFS(Boolean activityStatusCanBeWorkFS) {
        this.activityStatusCanBeWorkFS = activityStatusCanBeWorkFS;
    }

    public String getPropertyCode() {
        return propertyCode;
    }

    public void setPropertyCode(String propertyCode) {
        this.propertyCode = propertyCode;
    }

    public Integer getEngineFuelType() {
        return engineFuelType;
    }

    public void setEngineFuelType(Integer engineFuelType) {
        this.engineFuelType = engineFuelType;
    }

    public String getCarStatusInParkDescFV() {
        return carStatusInParkDescFV;
    }

    public void setCarStatusInParkDescFV(String carStatusInParkDescFV) {
        this.carStatusInParkDescFV = carStatusInParkDescFV;
    }

    public String getCurrentActStatusText() {
        return currentActStatusText;
    }

    public void setCurrentActStatusText(String currentActStatusText) {
        this.currentActStatusText = currentActStatusText;
    }

    public Integer getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(Integer activityStatus) {
        this.activityStatus = activityStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getCarMustDispatchForAdvertisement() {
        return carMustDispatchForAdvertisement;
    }

    public void setCarMustDispatchForAdvertisement(Boolean carMustDispatchForAdvertisement) {
        this.carMustDispatchForAdvertisement = carMustDispatchForAdvertisement;
    }

    public Integer getCardReaderHave() {
        return cardReaderHave;
    }

    public void setCardReaderHave(Integer cardReaderHave) {
        this.cardReaderHave = cardReaderHave;
    }

    public String getEngineNo() {
        return engineNo;
    }

    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo;
    }

    public String getFuelCardNo() {
        return fuelCardNo;
    }

    public void setFuelCardNo(String fuelCardNo) {
        this.fuelCardNo = fuelCardNo;
    }

    public String getDateConfirm1() {
        return dateConfirm1;
    }

    public void setDateConfirm1(String dateConfirm1) {
        this.dateConfirm1 = dateConfirm1;
    }

    public String getEngineFuelTypeText() {
        return engineFuelTypeText;
    }

    public void setEngineFuelTypeText(String engineFuelTypeText) {
        this.engineFuelTypeText = engineFuelTypeText;
    }

    public Boolean getShowTimeRemainingUpForExpire() {
        return showTimeRemainingUpForExpire;
    }

    public void setShowTimeRemainingUpForExpire(Boolean showTimeRemainingUpForExpire) {
        this.showTimeRemainingUpForExpire = showTimeRemainingUpForExpire;
    }

    public String getChassis() {
        return chassis;
    }

    public void setChassis(String chassis) {
        this.chassis = chassis;
    }

    public String getParkingDefTypeEnText() {
        return parkingDefTypeEnText;
    }

    public void setParkingDefTypeEnText(String parkingDefTypeEnText) {
        this.parkingDefTypeEnText = parkingDefTypeEnText;
    }

    public Integer getCarDeliverIs() {
        return carDeliverIs;
    }

    public void setCarDeliverIs(Integer carDeliverIs) {
        this.carDeliverIs = carDeliverIs;
    }

    public Boolean getUrbanFleetIs() {
        return urbanFleetIs;
    }

    public void setUrbanFleetIs(Boolean urbanFleetIs) {
        this.urbanFleetIs = urbanFleetIs;
    }

    public String getAfcCode() {
        return afcCode;
    }

    public void setAfcCode(String afcCode) {
        this.afcCode = afcCode;
    }

    public String getPlateText() {
        return plateText;
    }

    public void setPlateText(String plateText) {
        this.plateText = plateText;
    }

    public Boolean getActivityStatusIsStopFS() {
        return activityStatusIsStopFS;
    }

    public void setActivityStatusIsStopFS(Boolean activityStatusIsStopFS) {
        this.activityStatusIsStopFS = activityStatusIsStopFS;
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

    public Integer getSeatTypeEn() {
        return seatTypeEn;
    }

    public void setSeatTypeEn(Integer seatTypeEn) {
        this.seatTypeEn = seatTypeEn;
    }

    public Integer getCurrentActStatus() {
        return currentActStatus;
    }

    public void setCurrentActStatus(Integer currentActStatus) {
        this.currentActStatus = currentActStatus;
    }

    public String getUsageTypeEnText() {
        return usageTypeEnText;
    }

    public void setUsageTypeEnText(String usageTypeEnText) {
        this.usageTypeEnText = usageTypeEnText;
    }

    public Integer getGasStationDefTypeEn() {
        return gasStationDefTypeEn;
    }

    public void setGasStationDefTypeEn(Integer gasStationDefTypeEn) {
        this.gasStationDefTypeEn = gasStationDefTypeEn;
    }

    public String getDateLastChange() {
        return dateLastChange;
    }

    public void setDateLastChange(String dateLastChange) {
        this.dateLastChange = dateLastChange;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColorTabLicAttachment() {
        return colorTabLicAttachment;
    }

    public void setColorTabLicAttachment(String colorTabLicAttachment) {
        this.colorTabLicAttachment = colorTabLicAttachment;
    }

    public String getActivityStatusText() {
        return activityStatusText;
    }

    public void setActivityStatusText(String activityStatusText) {
        this.activityStatusText = activityStatusText;
    }

    public String getCarStatusInParkNameFV() {
        return carStatusInParkNameFV;
    }

    public void setCarStatusInParkNameFV(String carStatusInParkNameFV) {
        this.carStatusInParkNameFV = carStatusInParkNameFV;
    }

    public Integer getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(Integer productionYear) {
        this.productionYear = productionYear;
    }

    public Integer getEnableDeliverPerson() {
        return enableDeliverPerson;
    }

    public void setEnableDeliverPerson(Integer enableDeliverPerson) {
        this.enableDeliverPerson = enableDeliverPerson;
    }

    public String getCarDeliverIsText() {
        return carDeliverIsText;
    }

    public void setCarDeliverIsText(String carDeliverIsText) {
        this.carDeliverIsText = carDeliverIsText;
    }

    public String getColorStyleClass() {
        return colorStyleClass;
    }

    public void setColorStyleClass(String colorStyleClass) {
        this.colorStyleClass = colorStyleClass;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Integer getCarStatusInPark() {
        return carStatusInPark;
    }

    public void setCarStatusInPark(Integer carStatusInPark) {
        this.carStatusInPark = carStatusInPark;
    }

    public String getEnableDeliverPersonText() {
        return enableDeliverPersonText;
    }

    public void setEnableDeliverPersonText(String enableDeliverPersonText) {
        this.enableDeliverPersonText = enableDeliverPersonText;
    }

    public String getSeatTypeEnText() {
        return seatTypeEnText;
    }

    public void setSeatTypeEnText(String seatTypeEnText) {
        this.seatTypeEnText = seatTypeEnText;
    }

    public String getCarStatusInParkText() {
        return carStatusInParkText;
    }

    public void setCarStatusInParkText(String carStatusInParkText) {
        this.carStatusInParkText = carStatusInParkText;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getAutoCompleteLabel() {
        return autoCompleteLabel;
    }

    public void setAutoCompleteLabel(String autoCompleteLabel) {
        this.autoCompleteLabel = autoCompleteLabel;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public String getCarStopReasonFV() {
        return carStopReasonFV;
    }

    public void setCarStopReasonFV(String carStopReasonFV) {
        this.carStopReasonFV = carStopReasonFV;
    }

    public Integer getCoolerStatus() {
        return coolerStatus;
    }

    public void setCoolerStatus(Integer coolerStatus) {
        this.coolerStatus = coolerStatus;
    }

    public Boolean getChangeCarPlateIsPossible() {
        return changeCarPlateIsPossible;
    }

    public void setChangeCarPlateIsPossible(Boolean changeCarPlateIsPossible) {
        this.changeCarPlateIsPossible = changeCarPlateIsPossible;
    }

    public String getProcessStatusText() {
        return processStatusText;
    }

    public void setProcessStatusText(String processStatusText) {
        this.processStatusText = processStatusText;
    }

    public String getColorTabCar() {
        return colorTabCar;
    }

    public void setColorTabCar(String colorTabCar) {
        this.colorTabCar = colorTabCar;
    }

    public Boolean getBusFleetIs() {
        return busFleetIs;
    }

    public void setBusFleetIs(Boolean busFleetIs) {
        this.busFleetIs = busFleetIs;
    }

    public String getNameFv1() {
        return nameFv1;
    }

    public void setNameFv1(String nameFv1) {
        this.nameFv1 = nameFv1;
    }

    public Integer getFuelType() {
        return fuelType;
    }

    public void setFuelType(Integer fuelType) {
        this.fuelType = fuelType;
    }

    public String getCarStatusInParkStrFV() {
        return carStatusInParkStrFV;
    }

    public void setCarStatusInParkStrFV(String carStatusInParkStrFV) {
        this.carStatusInParkStrFV = carStatusInParkStrFV;
    }

    public String getNameFv2() {
        return nameFv2;
    }

    public void setNameFv2(String nameFv2) {
        this.nameFv2 = nameFv2;
    }

    public String getColorTabCarProfit() {
        return colorTabCarProfit;
    }

    public void setColorTabCarProfit(String colorTabCarProfit) {
        this.colorTabCarProfit = colorTabCarProfit;
    }

    public String getCardReaderHaveText() {
        return cardReaderHaveText;
    }

    public void setCardReaderHaveText(String cardReaderHaveText) {
        this.cardReaderHaveText = cardReaderHaveText;
    }

    public String getCoolerStatusText() {
        return coolerStatusText;
    }

    public void setCoolerStatusText(String coolerStatusText) {
        this.coolerStatusText = coolerStatusText;
    }

    public String getCarStopDescFV() {
        return carStopDescFV;
    }

    public void setCarStopDescFV(String carStopDescFV) {
        this.carStopDescFV = carStopDescFV;
    }

    public String getGasStationDefTypeEnText() {
        return gasStationDefTypeEnText;
    }

    public void setGasStationDefTypeEnText(String gasStationDefTypeEnText) {
        this.gasStationDefTypeEnText = gasStationDefTypeEnText;
    }

    public String getFuelTypeText() {
        return fuelTypeText;
    }

    public void setFuelTypeText(String fuelTypeText) {
        this.fuelTypeText = fuelTypeText;
    }

    public String getColorTabLicCarUF() {
        return colorTabLicCarUF;
    }

    public void setColorTabLicCarUF(String colorTabLicCarUF) {
        this.colorTabLicCarUF = colorTabLicCarUF;
    }
}
