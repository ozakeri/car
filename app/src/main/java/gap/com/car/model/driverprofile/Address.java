
package gap.com.car.model.driverprofile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Address {

    @SerializedName("entityName_text")
    @Expose
    private String entityNameText;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("addressType_text")
    @Expose
    private String addressTypeText;
    @SerializedName("entityName")
    @Expose
    private Integer entityName;
    @SerializedName("addressType")
    @Expose
    private Integer addressType;
    @SerializedName("postalCode")
    @Expose
    private String postalCode;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("cityId")
    @Expose
    private Integer cityId;
    @SerializedName("mobileNo")
    @Expose
    private String mobileNo;
    @SerializedName("provinceId")
    @Expose
    private Integer provinceId;
    @SerializedName("entity")
    @Expose
    private Integer entity;
    @SerializedName("telNo")
    @Expose
    private String telNo;

    public String getEntityNameText() {
        return entityNameText;
    }

    public void setEntityNameText(String entityNameText) {
        this.entityNameText = entityNameText;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressTypeText() {
        return addressTypeText;
    }

    public void setAddressTypeText(String addressTypeText) {
        this.addressTypeText = addressTypeText;
    }

    public Integer getEntityName() {
        return entityName;
    }

    public void setEntityName(Integer entityName) {
        this.entityName = entityName;
    }

    public Integer getAddressType() {
        return addressType;
    }

    public void setAddressType(Integer addressType) {
        this.addressType = addressType;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getEntity() {
        return entity;
    }

    public void setEntity(Integer entity) {
        this.entity = entity;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }
}
