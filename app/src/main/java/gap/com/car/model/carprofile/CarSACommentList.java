package gap.com.car.model.carprofile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CarSACommentList {

    @SerializedName("entityNameEn")
    @Expose
    public int entityNameEn;
    @SerializedName("entityNameEn_text")
    @Expose
    public String entityNameEn_text;
    @SerializedName("entityId")
    @Expose
    public int entityId;
    @SerializedName("id")
    @Expose
    public int id;
    @SerializedName("status_text")
    @Expose
    public String status_text;
    @SerializedName("commentText")
    @Expose
    public String commentText;
    @SerializedName("status")
    @Expose
    public int status;
    @SerializedName("dateCreation")
    @Expose
    public String dateCreation;

    public int getEntityNameEn() {
        return entityNameEn;
    }

    public void setEntityNameEn(int entityNameEn) {
        this.entityNameEn = entityNameEn;
    }

    public String getEntityNameEn_text() {
        return entityNameEn_text;
    }

    public void setEntityNameEn_text(String entityNameEn_text) {
        this.entityNameEn_text = entityNameEn_text;
    }

    public int getEntityId() {
        return entityId;
    }

    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus_text() {
        return status_text;
    }

    public void setStatus_text(String status_text) {
        this.status_text = status_text;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }
}
