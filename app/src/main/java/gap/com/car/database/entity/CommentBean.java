package gap.com.car.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class CommentBean implements Serializable {

    @PrimaryKey()
    @ColumnInfo(name = "id")
    private Integer id;
    @ColumnInfo(name = "status_text")
    private String status_text;
    @ColumnInfo(name = "entityNameEn_text")
    private String entityNameEn_text;
    @ColumnInfo(name = "commentDate")
    private String commentDate;
    @ColumnInfo(name = "commentTime")
    private String commentTime;
    @ColumnInfo(name = "status")
    private Integer status;
    @ColumnInfo(name = "entityId")
    private Integer entityId;
    @ColumnInfo(name = "commentStr")
    private String commentStr;
    @ColumnInfo(name = "commentTypeEn_text")
    private String commentTypeEn_text;
    @ColumnInfo(name = "entityNameEn")
    private Integer entityNameEn;
    @ColumnInfo(name = "commentTypeEn")
    private Integer commentTypeEn;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus_text() {
        return status_text;
    }

    public void setStatus_text(String status_text) {
        this.status_text = status_text;
    }

    public String getEntityNameEn_text() {
        return entityNameEn_text;
    }

    public void setEntityNameEn_text(String entityNameEn_text) {
        this.entityNameEn_text = entityNameEn_text;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }

    public String getCommentStr() {
        return commentStr;
    }

    public void setCommentStr(String commentStr) {
        this.commentStr = commentStr;
    }

    public String getCommentTypeEn_text() {
        return commentTypeEn_text;
    }

    public void setCommentTypeEn_text(String commentTypeEn_text) {
        this.commentTypeEn_text = commentTypeEn_text;
    }

    public Integer getEntityNameEn() {
        return entityNameEn;
    }

    public void setEntityNameEn(Integer entityNameEn) {
        this.entityNameEn = entityNameEn;
    }

    public Integer getCommentTypeEn() {
        return commentTypeEn;
    }

    public void setCommentTypeEn(Integer commentTypeEn) {
        this.commentTypeEn = commentTypeEn;
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }
}
