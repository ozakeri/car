
package gap.com.car.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Car implements Parcelable
{

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
    @SerializedName("engineFuelType")
    @Expose
    private Integer engineFuelType;
    @SerializedName("propertyCode")
    @Expose
    private String propertyCode;
    @SerializedName("carCode")
    @Expose
    private Integer carCode;
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
    @SerializedName("vehicleTypeEnFV_text")
    @Expose
    private String vehicleTypeEnFVText;
    @SerializedName("cardReaderHave")
    @Expose
    private Integer cardReaderHave;
    @SerializedName("engineNo")
    @Expose
    private String engineNo;
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
    @SerializedName("gasStationDefTypeEn")
    @Expose
    private Integer gasStationDefTypeEn;
    @SerializedName("usageTypeEn_text")
    @Expose
    private String usageTypeEnText;
    @SerializedName("colorTabLicAttachment")
    @Expose
    private String colorTabLicAttachment;
    @SerializedName("activityStatus_text")
    @Expose
    private String activityStatusText;
    @SerializedName("carDeliverIs_text")
    @Expose
    private String carDeliverIsText;
    @SerializedName("productionYear")
    @Expose
    private Integer productionYear;
    @SerializedName("enableDeliverPerson")
    @Expose
    private Integer enableDeliverPerson;
    @SerializedName("colorStyleClass")
    @Expose
    private String colorStyleClass;
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
    @SerializedName("fuelType")
    @Expose
    private Integer fuelType;
    @SerializedName("nameFv1")
    @Expose
    private String nameFv1;
    @SerializedName("vehicleTypeEnFV")
    @Expose
    private Integer vehicleTypeEnFV;
    @SerializedName("colorTabCarProfit")
    @Expose
    private String colorTabCarProfit;
    @SerializedName("cardReaderHave_text")
    @Expose
    private String cardReaderHaveText;
    @SerializedName("coolerStatus_text")
    @Expose
    private String coolerStatusText;
    @SerializedName("gasStationDefTypeEn_text")
    @Expose
    private String gasStationDefTypeEnText;
    @SerializedName("fuelType_text")
    @Expose
    private String fuelTypeText;
    @SerializedName("colorTabLicCarUF")
    @Expose
    private String colorTabLicCarUF;
    public final static Creator<Car> CREATOR = new Creator<Car>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Car createFromParcel(Parcel in) {
            return new Car(in);
        }

        public Car[] newArray(int size) {
            return (new Car[size]);
        }

    }
    ;

    protected Car(Parcel in) {
        this.deliveryToCompany = ((String) in.readValue((String.class.getClassLoader())));
        this.dateCreation = ((String) in.readValue((String.class.getClassLoader())));
        this.nameFv = ((String) in.readValue((String.class.getClassLoader())));
        this.processStatus = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.ageFV = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.vinNo = ((String) in.readValue((String.class.getClassLoader())));
        this.parkingDefTypeEn = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.usageTypeEn = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.engineFuelType = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.propertyCode = ((String) in.readValue((String.class.getClassLoader())));
        this.carCode = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.currentActStatusText = ((String) in.readValue((String.class.getClassLoader())));
        this.activityStatus = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.carMustDispatchForAdvertisement = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.vehicleTypeEnFVText = ((String) in.readValue((String.class.getClassLoader())));
        this.cardReaderHave = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.engineNo = ((String) in.readValue((String.class.getClassLoader())));
        this.engineFuelTypeText = ((String) in.readValue((String.class.getClassLoader())));
        this.showTimeRemainingUpForExpire = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.chassis = ((String) in.readValue((String.class.getClassLoader())));
        this.parkingDefTypeEnText = ((String) in.readValue((String.class.getClassLoader())));
        this.carDeliverIs = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.urbanFleetIs = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.afcCode = ((String) in.readValue((String.class.getClassLoader())));
        this.plateText = ((String) in.readValue((String.class.getClassLoader())));
        this.statusText = ((String) in.readValue((String.class.getClassLoader())));
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.seatTypeEn = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.currentActStatus = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.gasStationDefTypeEn = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.usageTypeEnText = ((String) in.readValue((String.class.getClassLoader())));
        this.colorTabLicAttachment = ((String) in.readValue((String.class.getClassLoader())));
        this.activityStatusText = ((String) in.readValue((String.class.getClassLoader())));
        this.carDeliverIsText = ((String) in.readValue((String.class.getClassLoader())));
        this.productionYear = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.enableDeliverPerson = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.colorStyleClass = ((String) in.readValue((String.class.getClassLoader())));
        this.carStatusInPark = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.enableDeliverPersonText = ((String) in.readValue((String.class.getClassLoader())));
        this.seatTypeEnText = ((String) in.readValue((String.class.getClassLoader())));
        this.carStatusInParkText = ((String) in.readValue((String.class.getClassLoader())));
        this.deliveryDate = ((String) in.readValue((String.class.getClassLoader())));
        this.autoCompleteLabel = ((String) in.readValue((String.class.getClassLoader())));
        this.plateNo = ((String) in.readValue((String.class.getClassLoader())));
        this.carStopReasonFV = ((String) in.readValue((String.class.getClassLoader())));
        this.coolerStatus = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.changeCarPlateIsPossible = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.processStatusText = ((String) in.readValue((String.class.getClassLoader())));
        this.colorTabCar = ((String) in.readValue((String.class.getClassLoader())));
        this.busFleetIs = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.fuelType = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.nameFv1 = ((String) in.readValue((String.class.getClassLoader())));
        this.vehicleTypeEnFV = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.colorTabCarProfit = ((String) in.readValue((String.class.getClassLoader())));
        this.cardReaderHaveText = ((String) in.readValue((String.class.getClassLoader())));
        this.coolerStatusText = ((String) in.readValue((String.class.getClassLoader())));
        this.gasStationDefTypeEnText = ((String) in.readValue((String.class.getClassLoader())));
        this.fuelTypeText = ((String) in.readValue((String.class.getClassLoader())));
        this.colorTabLicCarUF = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Car() {
    }

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

    public Integer getEngineFuelType() {
        return engineFuelType;
    }

    public void setEngineFuelType(Integer engineFuelType) {
        this.engineFuelType = engineFuelType;
    }

    public String getPropertyCode() {
        return propertyCode;
    }

    public void setPropertyCode(String propertyCode) {
        this.propertyCode = propertyCode;
    }

    public Integer getCarCode() {
        return carCode;
    }

    public void setCarCode(Integer carCode) {
        this.carCode = carCode;
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

    public String getVehicleTypeEnFVText() {
        return vehicleTypeEnFVText;
    }

    public void setVehicleTypeEnFVText(String vehicleTypeEnFVText) {
        this.vehicleTypeEnFVText = vehicleTypeEnFVText;
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

    public Integer getGasStationDefTypeEn() {
        return gasStationDefTypeEn;
    }

    public void setGasStationDefTypeEn(Integer gasStationDefTypeEn) {
        this.gasStationDefTypeEn = gasStationDefTypeEn;
    }

    public String getUsageTypeEnText() {
        return usageTypeEnText;
    }

    public void setUsageTypeEnText(String usageTypeEnText) {
        this.usageTypeEnText = usageTypeEnText;
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

    public String getCarDeliverIsText() {
        return carDeliverIsText;
    }

    public void setCarDeliverIsText(String carDeliverIsText) {
        this.carDeliverIsText = carDeliverIsText;
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

    public String getColorStyleClass() {
        return colorStyleClass;
    }

    public void setColorStyleClass(String colorStyleClass) {
        this.colorStyleClass = colorStyleClass;
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

    public Integer getFuelType() {
        return fuelType;
    }

    public void setFuelType(Integer fuelType) {
        this.fuelType = fuelType;
    }

    public String getNameFv1() {
        return nameFv1;
    }

    public void setNameFv1(String nameFv1) {
        this.nameFv1 = nameFv1;
    }

    public Integer getVehicleTypeEnFV() {
        return vehicleTypeEnFV;
    }

    public void setVehicleTypeEnFV(Integer vehicleTypeEnFV) {
        this.vehicleTypeEnFV = vehicleTypeEnFV;
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

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(deliveryToCompany);
        dest.writeValue(dateCreation);
        dest.writeValue(nameFv);
        dest.writeValue(processStatus);
        dest.writeValue(ageFV);
        dest.writeValue(vinNo);
        dest.writeValue(parkingDefTypeEn);
        dest.writeValue(usageTypeEn);
        dest.writeValue(engineFuelType);
        dest.writeValue(propertyCode);
        dest.writeValue(carCode);
        dest.writeValue(currentActStatusText);
        dest.writeValue(activityStatus);
        dest.writeValue(id);
        dest.writeValue(carMustDispatchForAdvertisement);
        dest.writeValue(vehicleTypeEnFVText);
        dest.writeValue(cardReaderHave);
        dest.writeValue(engineNo);
        dest.writeValue(engineFuelTypeText);
        dest.writeValue(showTimeRemainingUpForExpire);
        dest.writeValue(chassis);
        dest.writeValue(parkingDefTypeEnText);
        dest.writeValue(carDeliverIs);
        dest.writeValue(urbanFleetIs);
        dest.writeValue(afcCode);
        dest.writeValue(plateText);
        dest.writeValue(statusText);
        dest.writeValue(status);
        dest.writeValue(seatTypeEn);
        dest.writeValue(currentActStatus);
        dest.writeValue(gasStationDefTypeEn);
        dest.writeValue(usageTypeEnText);
        dest.writeValue(colorTabLicAttachment);
        dest.writeValue(activityStatusText);
        dest.writeValue(carDeliverIsText);
        dest.writeValue(productionYear);
        dest.writeValue(enableDeliverPerson);
        dest.writeValue(colorStyleClass);
        dest.writeValue(carStatusInPark);
        dest.writeValue(enableDeliverPersonText);
        dest.writeValue(seatTypeEnText);
        dest.writeValue(carStatusInParkText);
        dest.writeValue(deliveryDate);
        dest.writeValue(autoCompleteLabel);
        dest.writeValue(plateNo);
        dest.writeValue(carStopReasonFV);
        dest.writeValue(coolerStatus);
        dest.writeValue(changeCarPlateIsPossible);
        dest.writeValue(processStatusText);
        dest.writeValue(colorTabCar);
        dest.writeValue(busFleetIs);
        dest.writeValue(fuelType);
        dest.writeValue(nameFv1);
        dest.writeValue(vehicleTypeEnFV);
        dest.writeValue(colorTabCarProfit);
        dest.writeValue(cardReaderHaveText);
        dest.writeValue(coolerStatusText);
        dest.writeValue(gasStationDefTypeEnText);
        dest.writeValue(fuelTypeText);
        dest.writeValue(colorTabLicCarUF);
    }

    public int describeContents() {
        return  0;
    }

}
