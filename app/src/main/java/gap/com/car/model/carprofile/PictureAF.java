
package gap.com.car.model.carprofile;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PictureAF implements Parcelable
{

    @SerializedName("dateCreation")
    @Expose
    public String dateCreation;
    @SerializedName("nameFv")
    @Expose
    public String nameFv;
    @SerializedName("entityNameEn")
    @Expose
    public Integer entityNameEn;
    @SerializedName("typeFV")
    @Expose
    public String typeFV;
    @SerializedName("entityNameEn_text")
    @Expose
    public String entityNameEnText;
    @SerializedName("entityId")
    @Expose
    public Integer entityId;
    @SerializedName("userFileName")
    @Expose
    public String userFileName;
    @SerializedName("entityStr")
    @Expose
    public String entityStr;
    @SerializedName("nameFv2")
    @Expose
    public String nameFv2;
    @SerializedName("pathUrl")
    @Expose
    public String pathUrl;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("status_text")
    @Expose
    public String statusText;
    @SerializedName("attachSizeB")
    @Expose
    public Integer attachSizeB;
    @SerializedName("status")
    @Expose
    public Integer status;
    @SerializedName("referenceTable")
    @Expose
    public String referenceTable;
    @SerializedName("pictureBytes")
    @Expose
    public List<Integer> pictureBytes = null;


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

    public String getEntityStr() {
        return entityStr;
    }

    public void setEntityStr(String entityStr) {
        this.entityStr = entityStr;
    }

    public String getNameFv2() {
        return nameFv2;
    }

    public void setNameFv2(String nameFv2) {
        this.nameFv2 = nameFv2;
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

    public List<Integer> getPictureBytes() {
        return pictureBytes;
    }

    public void setPictureBytes(List<Integer> pictureBytes) {
        this.pictureBytes = pictureBytes;
    }

    protected PictureAF(Parcel in) {
        dateCreation = in.readString();
        nameFv = in.readString();
        if (in.readByte() == 0) {
            entityNameEn = null;
        } else {
            entityNameEn = in.readInt();
        }
        typeFV = in.readString();
        entityNameEnText = in.readString();
        if (in.readByte() == 0) {
            entityId = null;
        } else {
            entityId = in.readInt();
        }
        userFileName = in.readString();
        entityStr = in.readString();
        nameFv2 = in.readString();
        pathUrl = in.readString();
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        statusText = in.readString();
        if (in.readByte() == 0) {
            attachSizeB = null;
        } else {
            attachSizeB = in.readInt();
        }
        if (in.readByte() == 0) {
            status = null;
        } else {
            status = in.readInt();
        }
        referenceTable = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(dateCreation);
        dest.writeString(nameFv);
        if (entityNameEn == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(entityNameEn);
        }
        dest.writeString(typeFV);
        dest.writeString(entityNameEnText);
        if (entityId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(entityId);
        }
        dest.writeString(userFileName);
        dest.writeString(entityStr);
        dest.writeString(nameFv2);
        dest.writeString(pathUrl);
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        dest.writeString(statusText);
        if (attachSizeB == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(attachSizeB);
        }
        if (status == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(status);
        }
        dest.writeString(referenceTable);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PictureAF> CREATOR = new Creator<PictureAF>() {
        @Override
        public PictureAF createFromParcel(Parcel in) {
            return new PictureAF(in);
        }

        @Override
        public PictureAF[] newArray(int size) {
            return new PictureAF[size];
        }
    };
}
