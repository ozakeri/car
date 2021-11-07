package gap.com.car.database.entity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

/**
 * Entity mapped to table "DRIVER".
 */

@Entity
public class Report implements Serializable {

    @PrimaryKey()
    private Long id;
    @ColumnInfo(name = "identifier")
    private String identifier;
    @ColumnInfo(name = "entityId")
    private Long entityId;
    @ColumnInfo(name = "entityNameEn")
    private Integer entityNameEn;
    @ColumnInfo(name = "displayName")
    private String displayName;
    @ColumnInfo(name = "reportCode")
    private String reportCode;
    @ColumnInfo(name = "reportStr")
    private String reportStr;
    @ColumnInfo(name = "userReportId")
    private Long userReportId;
    @ColumnInfo(name = "reportDate")
    private String reportDate;
    @ColumnInfo(name = "serverId")
    private Long serverId;
    @ColumnInfo(name = "deliverIs")
    private Boolean deliverIs;
    @ColumnInfo(name = "deliverDate")
    private String deliverDate;
    @ColumnInfo(name = "sendingStatusEn")
    private Integer sendingStatusEn;
    @ColumnInfo(name = "sendingStatusDate")
    private String sendingStatusDate;
/*    @ColumnInfo(name = "xLatitude")
    private String xLatitude;
    @ColumnInfo(name = "yLongitude")
    private String yLongitude;*/

    public Report() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public Integer getEntityNameEn() {
        return entityNameEn;
    }

    public void setEntityNameEn(Integer entityNameEn) {
        this.entityNameEn = entityNameEn;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getReportCode() {
        return reportCode;
    }

    public void setReportCode(String reportCode) {
        this.reportCode = reportCode;
    }

    public String getReportStr() {
        return reportStr;
    }

    public void setReportStr(String reportStr) {
        this.reportStr = reportStr;
    }

    public Long getUserReportId() {
        return userReportId;
    }

    public void setUserReportId(Long userReportId) {
        this.userReportId = userReportId;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    public Long getServerId() {
        return serverId;
    }

    public void setServerId(Long serverId) {
        this.serverId = serverId;
    }

    public Boolean getDeliverIs() {
        return deliverIs;
    }

    public void setDeliverIs(Boolean deliverIs) {
        this.deliverIs = deliverIs;
    }

    public String getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(String deliverDate) {
        this.deliverDate = deliverDate;
    }

    public Integer getSendingStatusEn() {
        return sendingStatusEn;
    }

    public void setSendingStatusEn(Integer sendingStatusEn) {
        this.sendingStatusEn = sendingStatusEn;
    }

    public String getSendingStatusDate() {
        return sendingStatusDate;
    }

    public void setSendingStatusDate(String sendingStatusDate) {
        this.sendingStatusDate = sendingStatusDate;
    }

}
