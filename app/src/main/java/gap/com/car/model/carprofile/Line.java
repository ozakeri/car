
package gap.com.car.model.carprofile;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Line implements Parcelable
{

    @SerializedName("locatePathType")
    @Expose
    public Integer locatePathType;
    @SerializedName("dateCreation")
    @Expose
    public String dateCreation;
    @SerializedName("regionD_text")
    @Expose
    public String regionDText;
    @SerializedName("code")
    @Expose
    public String code;
    @SerializedName("serviceTime_text")
    @Expose
    public String serviceTimeText;
    @SerializedName("capacityPrivateNightFR")
    @Expose
    public Integer capacityPrivateNightFR;
    @SerializedName("nameFv")
    @Expose
    public String nameFv;
    @SerializedName("establishmentDate")
    @Expose
    public String establishmentDate;
    @SerializedName("capacityDayForAdvertisementFV")
    @Expose
    public Integer capacityDayForAdvertisementFV;
    @SerializedName("dateLastChange")
    @Expose
    public String dateLastChange;
    @SerializedName("actAdvertisement")
    @Expose
    public Boolean actAdvertisement;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("lineProfitCompanyType_text")
    @Expose
    public String lineProfitCompanyTypeText;
    @SerializedName("sosOrVeteransLineFV")
    @Expose
    public Boolean sosOrVeteransLineFV;
    @SerializedName("vehicleTypeEn")
    @Expose
    public Integer vehicleTypeEn;
    @SerializedName("lineProfitCompanyType")
    @Expose
    public Integer lineProfitCompanyType;
    @SerializedName("regionO_text")
    @Expose
    public String regionOText;
    @SerializedName("veteransIs")
    @Expose
    public Boolean veteransIs;
    @SerializedName("lineType")
    @Expose
    public Integer lineType;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("codeLast")
    @Expose
    public String codeLast;
    @SerializedName("lineGrade")
    @Expose
    public Integer lineGrade;
    @SerializedName("lineCompanyController")
    @Expose
    public LineCompanyController lineCompanyController;
    @SerializedName("locatePathType_text")
    @Expose
    public String locatePathTypeText;
    @SerializedName("autoCompleteLabel")
    @Expose
    public String autoCompleteLabel;
    @SerializedName("capacityPrivateDayFR")
    @Expose
    public Integer capacityPrivateDayFR;
    @SerializedName("actReqAdvertisement")
    @Expose
    public Boolean actReqAdvertisement;
    @SerializedName("dateConfirm1")
    @Expose
    public String dateConfirm1;
    @SerializedName("regionO")
    @Expose
    public Integer regionO;
    @SerializedName("lineGrade_text")
    @Expose
    public String lineGradeText;
    @SerializedName("linePrice")
    @Expose
    public LinePrice linePrice;
    @SerializedName("sosIs")
    @Expose
    public Boolean sosIs;
    @SerializedName("pathType")
    @Expose
    public Integer pathType;
    @SerializedName("regionD")
    @Expose
    public Integer regionD;
    @SerializedName("approvalNumber")
    @Expose
    public String approvalNumber;
    @SerializedName("pathType_text")
    @Expose
    public String pathTypeText;
    @SerializedName("serviceTime")
    @Expose
    public Integer serviceTime;
    @SerializedName("capacityAdvert")
    @Expose
    public Integer capacityAdvert;
    @SerializedName("capacityOrgDayFR")
    @Expose
    public Integer capacityOrgDayFR;
    @SerializedName("lineType_text")
    @Expose
    public String lineTypeText;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("status_text")
    @Expose
    public String statusText;
    @SerializedName("capacityOrgNightFR")
    @Expose
    public Integer capacityOrgNightFR;
    @SerializedName("vehicleTypeEn_text")
    @Expose
    public String vehicleTypeEnText;
    @SerializedName("startDate")
    @Expose
    public String startDate;
    @SerializedName("status")
    @Expose
    public Integer status;
    public final static Creator<Line> CREATOR = new Creator<Line>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Line createFromParcel(Parcel in) {
            return new Line(in);
        }

        public Line[] newArray(int size) {
            return (new Line[size]);
        }

    }
    ;

    protected Line(Parcel in) {
        this.locatePathType = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.dateCreation = ((String) in.readValue((String.class.getClassLoader())));
        this.regionDText = ((String) in.readValue((String.class.getClassLoader())));
        this.code = ((String) in.readValue((String.class.getClassLoader())));
        this.serviceTimeText = ((String) in.readValue((String.class.getClassLoader())));
        this.capacityPrivateNightFR = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.nameFv = ((String) in.readValue((String.class.getClassLoader())));
        this.establishmentDate = ((String) in.readValue((String.class.getClassLoader())));
        this.capacityDayForAdvertisementFV = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.dateLastChange = ((String) in.readValue((String.class.getClassLoader())));
        this.actAdvertisement = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.lineProfitCompanyTypeText = ((String) in.readValue((String.class.getClassLoader())));
        this.sosOrVeteransLineFV = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.vehicleTypeEn = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.lineProfitCompanyType = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.regionOText = ((String) in.readValue((String.class.getClassLoader())));
        this.veteransIs = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.lineType = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.codeLast = ((String) in.readValue((String.class.getClassLoader())));
        this.lineGrade = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.lineCompanyController = ((LineCompanyController) in.readValue((LineCompanyController.class.getClassLoader())));
        this.locatePathTypeText = ((String) in.readValue((String.class.getClassLoader())));
        this.autoCompleteLabel = ((String) in.readValue((String.class.getClassLoader())));
        this.capacityPrivateDayFR = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.actReqAdvertisement = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.dateConfirm1 = ((String) in.readValue((String.class.getClassLoader())));
        this.regionO = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.lineGradeText = ((String) in.readValue((String.class.getClassLoader())));
        this.linePrice = ((LinePrice) in.readValue((LinePrice.class.getClassLoader())));
        this.sosIs = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.pathType = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.regionD = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.approvalNumber = ((String) in.readValue((String.class.getClassLoader())));
        this.pathTypeText = ((String) in.readValue((String.class.getClassLoader())));
        this.serviceTime = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.capacityAdvert = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.capacityOrgDayFR = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.lineTypeText = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.statusText = ((String) in.readValue((String.class.getClassLoader())));
        this.capacityOrgNightFR = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.vehicleTypeEnText = ((String) in.readValue((String.class.getClassLoader())));
        this.startDate = ((String) in.readValue((String.class.getClassLoader())));
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public Line() {
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(locatePathType);
        dest.writeValue(dateCreation);
        dest.writeValue(regionDText);
        dest.writeValue(code);
        dest.writeValue(serviceTimeText);
        dest.writeValue(capacityPrivateNightFR);
        dest.writeValue(nameFv);
        dest.writeValue(establishmentDate);
        dest.writeValue(capacityDayForAdvertisementFV);
        dest.writeValue(dateLastChange);
        dest.writeValue(actAdvertisement);
        dest.writeValue(description);
        dest.writeValue(lineProfitCompanyTypeText);
        dest.writeValue(sosOrVeteransLineFV);
        dest.writeValue(vehicleTypeEn);
        dest.writeValue(lineProfitCompanyType);
        dest.writeValue(regionOText);
        dest.writeValue(veteransIs);
        dest.writeValue(lineType);
        dest.writeValue(id);
        dest.writeValue(codeLast);
        dest.writeValue(lineGrade);
        dest.writeValue(lineCompanyController);
        dest.writeValue(locatePathTypeText);
        dest.writeValue(autoCompleteLabel);
        dest.writeValue(capacityPrivateDayFR);
        dest.writeValue(actReqAdvertisement);
        dest.writeValue(dateConfirm1);
        dest.writeValue(regionO);
        dest.writeValue(lineGradeText);
        dest.writeValue(linePrice);
        dest.writeValue(sosIs);
        dest.writeValue(pathType);
        dest.writeValue(regionD);
        dest.writeValue(approvalNumber);
        dest.writeValue(pathTypeText);
        dest.writeValue(serviceTime);
        dest.writeValue(capacityAdvert);
        dest.writeValue(capacityOrgDayFR);
        dest.writeValue(lineTypeText);
        dest.writeValue(name);
        dest.writeValue(statusText);
        dest.writeValue(capacityOrgNightFR);
        dest.writeValue(vehicleTypeEnText);
        dest.writeValue(startDate);
        dest.writeValue(status);
    }

    public int describeContents() {
        return  0;
    }

}
