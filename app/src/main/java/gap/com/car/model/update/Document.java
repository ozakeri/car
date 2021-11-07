
package gap.com.car.model.update;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Document {

    @SerializedName("documentTypeEn_text")
    @Expose
    private String documentTypeEnText;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("lastDocumentVersion")
    @Expose
    private LastDocumentVersion lastDocumentVersion;
    @SerializedName("autoCompleteLabel")
    @Expose
    private String autoCompleteLabel;
    @SerializedName("nameFv")
    @Expose
    private String nameFv;
    @SerializedName("documentTypeEn")
    @Expose
    private Integer documentTypeEn;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("companyTypeEn")
    @Expose
    private Integer companyTypeEn;
    @SerializedName("companyTypeEn_text")
    @Expose
    private String companyTypeEnText;
    @SerializedName("docDate")
    @Expose
    private String docDate;
    @SerializedName("nameFvApp")
    @Expose
    private String nameFvApp;
    @SerializedName("username")
    @Expose
    private String username;

    public String getDocumentTypeEnText() {
        return documentTypeEnText;
    }

    public void setDocumentTypeEnText(String documentTypeEnText) {
        this.documentTypeEnText = documentTypeEnText;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LastDocumentVersion getLastDocumentVersion() {
        return lastDocumentVersion;
    }

    public void setLastDocumentVersion(LastDocumentVersion lastDocumentVersion) {
        this.lastDocumentVersion = lastDocumentVersion;
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

    public Integer getDocumentTypeEn() {
        return documentTypeEn;
    }

    public void setDocumentTypeEn(Integer documentTypeEn) {
        this.documentTypeEn = documentTypeEn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCompanyTypeEn() {
        return companyTypeEn;
    }

    public void setCompanyTypeEn(Integer companyTypeEn) {
        this.companyTypeEn = companyTypeEn;
    }

    public String getCompanyTypeEnText() {
        return companyTypeEnText;
    }

    public void setCompanyTypeEnText(String companyTypeEnText) {
        this.companyTypeEnText = companyTypeEnText;
    }

    public String getDocDate() {
        return docDate;
    }

    public void setDocDate(String docDate) {
        this.docDate = docDate;
    }

    public String getNameFvApp() {
        return nameFvApp;
    }

    public void setNameFvApp(String nameFvApp) {
        this.nameFvApp = nameFvApp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
