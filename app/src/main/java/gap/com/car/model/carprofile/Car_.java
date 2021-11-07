
package gap.com.car.model.carprofile;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Car_ implements Parcelable
{

    @SerializedName("deliveryToCompany")
    @Expose
    public String deliveryToCompany;
    @SerializedName("dateCreation")
    @Expose
    public String dateCreation;
    @SerializedName("nameFv")
    @Expose
    public String nameFv;
    @SerializedName("processStatus")
    @Expose
    public Integer processStatus;
    @SerializedName("ageFV")
    @Expose
    public Integer ageFV;
    @SerializedName("vinNo")
    @Expose
    public String vinNo;
    @SerializedName("parkingDefTypeEn")
    @Expose
    public Integer parkingDefTypeEn;
    @SerializedName("usageTypeEn")
    @Expose
    public Integer usageTypeEn;
    @SerializedName("activityStatusCanBeWorkFS")
    @Expose
    public Boolean activityStatusCanBeWorkFS;
    @SerializedName("engineFuelType")
    @Expose
    public Integer engineFuelType;
    @SerializedName("propertyCode")
    @Expose
    public String propertyCode;
    @SerializedName("carStatusInParkDescFV")
    @Expose
    public String carStatusInParkDescFV;
    @SerializedName("currentActStatus_text")
    @Expose
    public String currentActStatusText;
    @SerializedName("activityStatus")
    @Expose
    public Integer activityStatus;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("carMustDispatchForAdvertisement")
    @Expose
    public Boolean carMustDispatchForAdvertisement;
    @SerializedName("cardReaderHave")
    @Expose
    public Integer cardReaderHave;
    @SerializedName("engineNo")
    @Expose
    public String engineNo;
    @SerializedName("fuelCardNo")
    @Expose
    public String fuelCardNo;
    @SerializedName("dateConfirm1")
    @Expose
    public String dateConfirm1;
    @SerializedName("engineFuelType_text")
    @Expose
    public String engineFuelTypeText;
    @SerializedName("showTimeRemainingUpForExpire")
    @Expose
    public Boolean showTimeRemainingUpForExpire;
    @SerializedName("parkingDefTypeEn_text")
    @Expose
    public String parkingDefTypeEnText;
    @SerializedName("chassis")
    @Expose
    public String chassis;
    @SerializedName("carDeliverIs")
    @Expose
    public Integer carDeliverIs;
    @SerializedName("urbanFleetIs")
    @Expose
    public Boolean urbanFleetIs;
    @SerializedName("plateText")
    @Expose
    public String plateText;
    @SerializedName("afcCode")
    @Expose
    public String afcCode;
    @SerializedName("activityStatusIsStopFS")
    @Expose
    public Boolean activityStatusIsStopFS;
    @SerializedName("status_text")
    @Expose
    public String statusText;
    @SerializedName("status")
    @Expose
    public Integer status;
    @SerializedName("seatTypeEn")
    @Expose
    public Integer seatTypeEn;
    @SerializedName("currentActStatus")
    @Expose
    public Integer currentActStatus;
    @SerializedName("gasStationDefTypeEn")
    @Expose
    public Integer gasStationDefTypeEn;
    @SerializedName("usageTypeEn_text")
    @Expose
    public String usageTypeEnText;
    @SerializedName("dateLastChange")
    @Expose
    public String dateLastChange;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("colorTabLicAttachment")
    @Expose
    public String colorTabLicAttachment;
    @SerializedName("activityStatus_text")
    @Expose
    public String activityStatusText;
    @SerializedName("carStatusInParkNameFV")
    @Expose
    public String carStatusInParkNameFV;
    @SerializedName("enableDeliverPerson")
    @Expose
    public Integer enableDeliverPerson;
    @SerializedName("productionYear")
    @Expose
    public Integer productionYear;
    @SerializedName("carDeliverIs_text")
    @Expose
    public String carDeliverIsText;
    @SerializedName("colorStyleClass")
    @Expose
    public String colorStyleClass;
    @SerializedName("vehicle")
    @Expose
    public Vehicle vehicle;
    @SerializedName("carStatusInPark")
    @Expose
    public Integer carStatusInPark;
    @SerializedName("enableDeliverPerson_text")
    @Expose
    public String enableDeliverPersonText;
    @SerializedName("carStatusInPark_text")
    @Expose
    public String carStatusInParkText;
    @SerializedName("seatTypeEn_text")
    @Expose
    public String seatTypeEnText;
    @SerializedName("deliveryDate")
    @Expose
    public String deliveryDate;
    @SerializedName("autoCompleteLabel")
    @Expose
    public String autoCompleteLabel;
    @SerializedName("plateNo")
    @Expose
    public String plateNo;
    @SerializedName("carStopReasonFV")
    @Expose
    public String carStopReasonFV;
    @SerializedName("coolerStatus")
    @Expose
    public Integer coolerStatus;
    @SerializedName("changeCarPlateIsPossible")
    @Expose
    public Boolean changeCarPlateIsPossible;
    @SerializedName("processStatus_text")
    @Expose
    public String processStatusText;
    @SerializedName("colorTabCar")
    @Expose
    public String colorTabCar;
    @SerializedName("busFleetIs")
    @Expose
    public Boolean busFleetIs;
    @SerializedName("fuelType")
    @Expose
    public Integer fuelType;
    @SerializedName("nameFv1")
    @Expose
    public String nameFv1;
    @SerializedName("carStatusInParkStrFV")
    @Expose
    public String carStatusInParkStrFV;
    @SerializedName("nameFv2")
    @Expose
    public String nameFv2;
    @SerializedName("colorTabCarProfit")
    @Expose
    public String colorTabCarProfit;
    @SerializedName("cardReaderHave_text")
    @Expose
    public String cardReaderHaveText;
    @SerializedName("nameFvOnCode")
    @Expose
    public String nameFvOnCode;
    @SerializedName("coolerStatus_text")
    @Expose
    public String coolerStatusText;
    @SerializedName("carStopDescFV")
    @Expose
    public String carStopDescFV;
    @SerializedName("gasStationDefTypeEn_text")
    @Expose
    public String gasStationDefTypeEnText;
    @SerializedName("fuelType_text")
    @Expose
    public String fuelTypeText;
    @SerializedName("colorTabLicCarUF")
    @Expose
    public String colorTabLicCarUF;
    public final static Creator<Car_> CREATOR = new Creator<Car_>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Car_ createFromParcel(Parcel in) {
            return new Car_(in);
        }

        public Car_[] newArray(int size) {
            return (new Car_[size]);
        }

    }
    ;

    protected Car_(Parcel in) {
        this.deliveryToCompany = ((String) in.readValue((String.class.getClassLoader())));
        this.dateCreation = ((String) in.readValue((String.class.getClassLoader())));
        this.nameFv = ((String) in.readValue((String.class.getClassLoader())));
        this.processStatus = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.ageFV = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.vinNo = ((String) in.readValue((String.class.getClassLoader())));
        this.parkingDefTypeEn = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.usageTypeEn = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.activityStatusCanBeWorkFS = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.engineFuelType = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.propertyCode = ((String) in.readValue((String.class.getClassLoader())));
        this.carStatusInParkDescFV = ((String) in.readValue((String.class.getClassLoader())));
        this.currentActStatusText = ((String) in.readValue((String.class.getClassLoader())));
        this.activityStatus = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.carMustDispatchForAdvertisement = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.cardReaderHave = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.engineNo = ((String) in.readValue((String.class.getClassLoader())));
        this.fuelCardNo = ((String) in.readValue((String.class.getClassLoader())));
        this.dateConfirm1 = ((String) in.readValue((String.class.getClassLoader())));
        this.engineFuelTypeText = ((String) in.readValue((String.class.getClassLoader())));
        this.showTimeRemainingUpForExpire = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.parkingDefTypeEnText = ((String) in.readValue((String.class.getClassLoader())));
        this.chassis = ((String) in.readValue((String.class.getClassLoader())));
        this.carDeliverIs = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.urbanFleetIs = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.plateText = ((String) in.readValue((String.class.getClassLoader())));
        this.afcCode = ((String) in.readValue((String.class.getClassLoader())));
        this.activityStatusIsStopFS = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.statusText = ((String) in.readValue((String.class.getClassLoader())));
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.seatTypeEn = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.currentActStatus = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.gasStationDefTypeEn = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.usageTypeEnText = ((String) in.readValue((String.class.getClassLoader())));
        this.dateLastChange = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.colorTabLicAttachment = ((String) in.readValue((String.class.getClassLoader())));
        this.activityStatusText = ((String) in.readValue((String.class.getClassLoader())));
        this.carStatusInParkNameFV = ((String) in.readValue((String.class.getClassLoader())));
        this.enableDeliverPerson = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.productionYear = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.carDeliverIsText = ((String) in.readValue((String.class.getClassLoader())));
        this.colorStyleClass = ((String) in.readValue((String.class.getClassLoader())));
        this.vehicle = ((Vehicle) in.readValue((Vehicle.class.getClassLoader())));
        this.carStatusInPark = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.enableDeliverPersonText = ((String) in.readValue((String.class.getClassLoader())));
        this.carStatusInParkText = ((String) in.readValue((String.class.getClassLoader())));
        this.seatTypeEnText = ((String) in.readValue((String.class.getClassLoader())));
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
        this.carStatusInParkStrFV = ((String) in.readValue((String.class.getClassLoader())));
        this.nameFv2 = ((String) in.readValue((String.class.getClassLoader())));
        this.colorTabCarProfit = ((String) in.readValue((String.class.getClassLoader())));
        this.cardReaderHaveText = ((String) in.readValue((String.class.getClassLoader())));
        this.nameFvOnCode = ((String) in.readValue((String.class.getClassLoader())));
        this.coolerStatusText = ((String) in.readValue((String.class.getClassLoader())));
        this.carStopDescFV = ((String) in.readValue((String.class.getClassLoader())));
        this.gasStationDefTypeEnText = ((String) in.readValue((String.class.getClassLoader())));
        this.fuelTypeText = ((String) in.readValue((String.class.getClassLoader())));
        this.colorTabLicCarUF = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Car_() {
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
        dest.writeValue(activityStatusCanBeWorkFS);
        dest.writeValue(engineFuelType);
        dest.writeValue(propertyCode);
        dest.writeValue(carStatusInParkDescFV);
        dest.writeValue(currentActStatusText);
        dest.writeValue(activityStatus);
        dest.writeValue(id);
        dest.writeValue(carMustDispatchForAdvertisement);
        dest.writeValue(cardReaderHave);
        dest.writeValue(engineNo);
        dest.writeValue(fuelCardNo);
        dest.writeValue(dateConfirm1);
        dest.writeValue(engineFuelTypeText);
        dest.writeValue(showTimeRemainingUpForExpire);
        dest.writeValue(parkingDefTypeEnText);
        dest.writeValue(chassis);
        dest.writeValue(carDeliverIs);
        dest.writeValue(urbanFleetIs);
        dest.writeValue(plateText);
        dest.writeValue(afcCode);
        dest.writeValue(activityStatusIsStopFS);
        dest.writeValue(statusText);
        dest.writeValue(status);
        dest.writeValue(seatTypeEn);
        dest.writeValue(currentActStatus);
        dest.writeValue(gasStationDefTypeEn);
        dest.writeValue(usageTypeEnText);
        dest.writeValue(dateLastChange);
        dest.writeValue(description);
        dest.writeValue(colorTabLicAttachment);
        dest.writeValue(activityStatusText);
        dest.writeValue(carStatusInParkNameFV);
        dest.writeValue(enableDeliverPerson);
        dest.writeValue(productionYear);
        dest.writeValue(carDeliverIsText);
        dest.writeValue(colorStyleClass);
        dest.writeValue(vehicle);
        dest.writeValue(carStatusInPark);
        dest.writeValue(enableDeliverPersonText);
        dest.writeValue(carStatusInParkText);
        dest.writeValue(seatTypeEnText);
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
        dest.writeValue(carStatusInParkStrFV);
        dest.writeValue(nameFv2);
        dest.writeValue(colorTabCarProfit);
        dest.writeValue(cardReaderHaveText);
        dest.writeValue(nameFvOnCode);
        dest.writeValue(coolerStatusText);
        dest.writeValue(carStopDescFV);
        dest.writeValue(gasStationDefTypeEnText);
        dest.writeValue(fuelTypeText);
        dest.writeValue(colorTabLicCarUF);
    }

    public int describeContents() {
        return  0;
    }

}
