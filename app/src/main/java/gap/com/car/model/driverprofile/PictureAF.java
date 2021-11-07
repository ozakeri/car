
package gap.com.car.model.driverprofile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PictureAF {

    @SerializedName("dateCreation")
    @Expose
    private String dateCreation;
    @SerializedName("nameFv")
    @Expose
    private String nameFv;
    @SerializedName("entityNameEn")
    @Expose
    private Integer entityNameEn;
    @SerializedName("typeFV")
    @Expose
    private String typeFV;
    @SerializedName("entityNameEn_text")
    @Expose
    private String entityNameEnText;
    @SerializedName("entityId")
    @Expose
    private Integer entityId;
    @SerializedName("userFileName")
    @Expose
    private String userFileName;
    @SerializedName("nameFv2")
    @Expose
    private String nameFv2;
    @SerializedName("entityStr")
    @Expose
    private String entityStr;
    @SerializedName("pathUrl")
    @Expose
    private String pathUrl;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("status_text")
    @Expose
    private String statusText;
    @SerializedName("attachSizeB")
    @Expose
    private Integer attachSizeB;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("referenceTable")
    @Expose
    private String referenceTable;

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

    public Integer getEntityNameEn() {
        return entityNameEn;
    }

    public void setEntityNameEn(Integer entityNameEn) {
        this.entityNameEn = entityNameEn;
    }

    public String getTypeFV() {
        return typeFV;
    }

    public void setTypeFV(String typeFV) {
        this.typeFV = typeFV;
    }

    public String getEntityNameEnText() {
        return entityNameEnText;
    }

    public void setEntityNameEnText(String entityNameEnText) {
        this.entityNameEnText = entityNameEnText;
    }

    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }

    public String getUserFileName() {
        return userFileName;
    }

    public void setUserFileName(String userFileName) {
        this.userFileName = userFileName;
    }

    public String getNameFv2() {
        return nameFv2;
    }

    public void setNameFv2(String nameFv2) {
        this.nameFv2 = nameFv2;
    }

    public String getEntityStr() {
        return entityStr;
    }

    public void setEntityStr(String entityStr) {
        this.entityStr = entityStr;
    }

    public String getPathUrl() {
        return pathUrl;
    }

    public void setPathUrl(String pathUrl) {
        this.pathUrl = pathUrl;
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

    public Integer getAttachSizeB() {
        return attachSizeB;
    }

    public void setAttachSizeB(Integer attachSizeB) {
        this.attachSizeB = attachSizeB;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getReferenceTable() {
        return referenceTable;
    }

    public void setReferenceTable(String referenceTable) {
        this.referenceTable = referenceTable;
    }
}
