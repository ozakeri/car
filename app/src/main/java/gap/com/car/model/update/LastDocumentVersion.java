
package gap.com.car.model.update;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LastDocumentVersion {

    @SerializedName("publishIs_text")
    @Expose
    private String publishIsText;
    @SerializedName("autoCompleteLabel")
    @Expose
    private String autoCompleteLabel;
    @SerializedName("nameFv")
    @Expose
    private String nameFv;
    @SerializedName("dbVersion")
    @Expose
    private String dbVersion;
    @SerializedName("letterHave_text")
    @Expose
    private String letterHaveText;
    @SerializedName("versionName")
    @Expose
    private String versionName;
    @SerializedName("versionDate")
    @Expose
    private String versionDate;
    @SerializedName("devicePrm")
    @Expose
    private String devicePrm;
    @SerializedName("letterHave")
    @Expose
    private Integer letterHave;
    @SerializedName("versionNo")
    @Expose
    private String versionNo;
    @SerializedName("pathUrl")
    @Expose
    private String pathUrl;
    @SerializedName("featuredDesc")
    @Expose
    private String featuredDesc;
    @SerializedName("publishIs")
    @Expose
    private Integer publishIs;
    @SerializedName("bugFixedDesc")
    @Expose
    private String bugFixedDesc;

    public String getPublishIsText() {
        return publishIsText;
    }

    public void setPublishIsText(String publishIsText) {
        this.publishIsText = publishIsText;
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

    public String getDbVersion() {
        return dbVersion;
    }

    public void setDbVersion(String dbVersion) {
        this.dbVersion = dbVersion;
    }

    public String getLetterHaveText() {
        return letterHaveText;
    }

    public void setLetterHaveText(String letterHaveText) {
        this.letterHaveText = letterHaveText;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getVersionDate() {
        return versionDate;
    }

    public void setVersionDate(String versionDate) {
        this.versionDate = versionDate;
    }

    public String getDevicePrm() {
        return devicePrm;
    }

    public void setDevicePrm(String devicePrm) {
        this.devicePrm = devicePrm;
    }

    public Integer getLetterHave() {
        return letterHave;
    }

    public void setLetterHave(Integer letterHave) {
        this.letterHave = letterHave;
    }

    public String getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo;
    }

    public String getPathUrl() {
        return pathUrl;
    }

    public void setPathUrl(String pathUrl) {
        this.pathUrl = pathUrl;
    }

    public String getFeaturedDesc() {
        return featuredDesc;
    }

    public void setFeaturedDesc(String featuredDesc) {
        this.featuredDesc = featuredDesc;
    }

    public Integer getPublishIs() {
        return publishIs;
    }

    public void setPublishIs(Integer publishIs) {
        this.publishIs = publishIs;
    }

    public String getBugFixedDesc() {
        return bugFixedDesc;
    }

    public void setBugFixedDesc(String bugFixedDesc) {
        this.bugFixedDesc = bugFixedDesc;
    }
}
