
package gap.com.car.model.carprofile;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Company implements Parcelable
{

    @SerializedName("tariffBusIsLive")
    @Expose
    public Boolean tariffBusIsLive;
    @SerializedName("companyTypeIsLocal")
    @Expose
    public Boolean companyTypeIsLocal;
    @SerializedName("dateCreation")
    @Expose
    public String dateCreation;
    @SerializedName("code")
    @Expose
    public String code;
    @SerializedName("ownerCompanyIs_text")
    @Expose
    public String ownerCompanyIsText;
    @SerializedName("nameFv")
    @Expose
    public String nameFv;
    @SerializedName("processStatus")
    @Expose
    public Integer processStatus;
    @SerializedName("disableForPrivateCoAndCityRegion")
    @Expose
    public Boolean disableForPrivateCoAndCityRegion;
    @SerializedName("userSuperiorNoMax")
    @Expose
    public Integer userSuperiorNoMax;
    @SerializedName("ownerCompanyIs")
    @Expose
    public Integer ownerCompanyIs;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("companyIsOperationalBus")
    @Expose
    public Boolean companyIsOperationalBus;
    @SerializedName("sOSCompanyId")
    @Expose
    public Integer sOSCompanyId;
    @SerializedName("mainCompanyId")
    @Expose
    public Integer mainCompanyId;
    @SerializedName("userNoMax")
    @Expose
    public Integer userNoMax;
    @SerializedName("codeInTree")
    @Expose
    public String codeInTree;
    @SerializedName("carNo")
    @Expose
    public Integer carNo;
    @SerializedName("companyIsSOS")
    @Expose
    public Boolean companyIsSOS;
    @SerializedName("legalTypeEn_text")
    @Expose
    public String legalTypeEnText;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("legalTypeSysParamValue")
    @Expose
    public String legalTypeSysParamValue;
    @SerializedName("companyIsMain")
    @Expose
    public Boolean companyIsMain;
    @SerializedName("disableForOtherParent")
    @Expose
    public Boolean disableForOtherParent;
    @SerializedName("autoCompleteLabel")
    @Expose
    public String autoCompleteLabel;
    @SerializedName("disableForPrivateCo")
    @Expose
    public Boolean disableForPrivateCo;
    @SerializedName("companyIsInternal")
    @Expose
    public Boolean companyIsInternal;
    @SerializedName("companyType")
    @Expose
    public Integer companyType;
    @SerializedName("companyType_text")
    @Expose
    public String companyTypeText;
    @SerializedName("processStatus_text")
    @Expose
    public String processStatusText;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("legalTypeEn")
    @Expose
    public Integer legalTypeEn;
    @SerializedName("status_text")
    @Expose
    public String statusText;
    @SerializedName("status")
    @Expose
    public Integer status;
    public final static Creator<Company> CREATOR = new Creator<Company>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Company createFromParcel(Parcel in) {
            return new Company(in);
        }

        public Company[] newArray(int size) {
            return (new Company[size]);
        }

    }
    ;

    protected Company(Parcel in) {
        this.tariffBusIsLive = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.companyTypeIsLocal = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.dateCreation = ((String) in.readValue((String.class.getClassLoader())));
        this.code = ((String) in.readValue((String.class.getClassLoader())));
        this.ownerCompanyIsText = ((String) in.readValue((String.class.getClassLoader())));
        this.nameFv = ((String) in.readValue((String.class.getClassLoader())));
        this.processStatus = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.disableForPrivateCoAndCityRegion = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.userSuperiorNoMax = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.ownerCompanyIs = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.companyIsOperationalBus = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.sOSCompanyId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.mainCompanyId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.userNoMax = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.codeInTree = ((String) in.readValue((String.class.getClassLoader())));
        this.carNo = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.companyIsSOS = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.legalTypeEnText = ((String) in.readValue((String.class.getClassLoader())));
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.legalTypeSysParamValue = ((String) in.readValue((String.class.getClassLoader())));
        this.companyIsMain = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.disableForOtherParent = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.autoCompleteLabel = ((String) in.readValue((String.class.getClassLoader())));
        this.disableForPrivateCo = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.companyIsInternal = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.companyType = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.companyTypeText = ((String) in.readValue((String.class.getClassLoader())));
        this.processStatusText = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.legalTypeEn = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.statusText = ((String) in.readValue((String.class.getClassLoader())));
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public Company() {
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(tariffBusIsLive);
        dest.writeValue(companyTypeIsLocal);
        dest.writeValue(dateCreation);
        dest.writeValue(code);
        dest.writeValue(ownerCompanyIsText);
        dest.writeValue(nameFv);
        dest.writeValue(processStatus);
        dest.writeValue(disableForPrivateCoAndCityRegion);
        dest.writeValue(userSuperiorNoMax);
        dest.writeValue(ownerCompanyIs);
        dest.writeValue(description);
        dest.writeValue(companyIsOperationalBus);
        dest.writeValue(sOSCompanyId);
        dest.writeValue(mainCompanyId);
        dest.writeValue(userNoMax);
        dest.writeValue(codeInTree);
        dest.writeValue(carNo);
        dest.writeValue(companyIsSOS);
        dest.writeValue(legalTypeEnText);
        dest.writeValue(id);
        dest.writeValue(legalTypeSysParamValue);
        dest.writeValue(companyIsMain);
        dest.writeValue(disableForOtherParent);
        dest.writeValue(autoCompleteLabel);
        dest.writeValue(disableForPrivateCo);
        dest.writeValue(companyIsInternal);
        dest.writeValue(companyType);
        dest.writeValue(companyTypeText);
        dest.writeValue(processStatusText);
        dest.writeValue(name);
        dest.writeValue(legalTypeEn);
        dest.writeValue(statusText);
        dest.writeValue(status);
    }

    public int describeContents() {
        return  0;
    }

}
