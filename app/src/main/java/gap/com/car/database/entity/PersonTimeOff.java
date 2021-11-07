
package gap.com.car.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class PersonTimeOff implements Serializable {

    @ColumnInfo(name = "nameFv")
    private String nameFv;
    @ColumnInfo(name = "processStatus")
    private Integer processStatus;
    @ColumnInfo(name = "requestTypeEnText")
    private String requestTypeEnText;
    @ColumnInfo(name = "description")
    private String description;
    @ColumnInfo(name = "dutyIs")
    private Boolean dutyIs;
    @ColumnInfo(name = "processStatusText")
    private String processStatusText;
    @ColumnInfo(name = "absentIsFV")
    private String absentIsFV;
    @ColumnInfo(name = "requestTypeEn")
    private Integer requestTypeEn;
    @ColumnInfo(name = "offOnDay")
    private Boolean offOnDay;
    @ColumnInfo(name = "absentIs")
    private Boolean absentIs;
    @ColumnInfo(name = "finishDate")
    private String finishDate;
    @ColumnInfo(name = "personTimeOffTypeEnText")
    private String personTimeOffTypeEnText;
    @PrimaryKey()
    @ColumnInfo(name = "id")
    private Integer id;
    @ColumnInfo(name = "statusText")
    private String statusText;
    @ColumnInfo(name = "startDate")
    private String startDate;
    @ColumnInfo(name = "status")
    private Integer status;
    @ColumnInfo(name = "offOnDayFV")
    private String offOnDayFV;
    @ColumnInfo(name = "personTimeOffTypeEn")
    private Integer personTimeOffTypeEn;

    public PersonTimeOff() {
    }

    public String getNameFv() {
        return nameFv;
    }

    public void setNameFv(String nameFv) {
        this.nameFv = nameFv;
    }

    public Integer getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(Integer processStatus) {
        this.processStatus = processStatus;
    }

    public String getRequestTypeEnText() {
        return requestTypeEnText;
    }

    public void setRequestTypeEnText(String requestTypeEnText) {
        this.requestTypeEnText = requestTypeEnText;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDutyIs() {
        return dutyIs;
    }

    public void setDutyIs(Boolean dutyIs) {
        this.dutyIs = dutyIs;
    }

    public String getProcessStatusText() {
        return processStatusText;
    }

    public void setProcessStatusText(String processStatusText) {
        this.processStatusText = processStatusText;
    }

    public String getAbsentIsFV() {
        return absentIsFV;
    }

    public void setAbsentIsFV(String absentIsFV) {
        this.absentIsFV = absentIsFV;
    }

    public Integer getRequestTypeEn() {
        return requestTypeEn;
    }

    public void setRequestTypeEn(Integer requestTypeEn) {
        this.requestTypeEn = requestTypeEn;
    }

    public Boolean getOffOnDay() {
        return offOnDay;
    }

    public void setOffOnDay(Boolean offOnDay) {
        this.offOnDay = offOnDay;
    }

    public Boolean getAbsentIs() {
        return absentIs;
    }

    public void setAbsentIs(Boolean absentIs) {
        this.absentIs = absentIs;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public String getPersonTimeOffTypeEnText() {
        return personTimeOffTypeEnText;
    }

    public void setPersonTimeOffTypeEnText(String personTimeOffTypeEnText) {
        this.personTimeOffTypeEnText = personTimeOffTypeEnText;
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getOffOnDayFV() {
        return offOnDayFV;
    }

    public void setOffOnDayFV(String offOnDayFV) {
        this.offOnDayFV = offOnDayFV;
    }

    public Integer getPersonTimeOffTypeEn() {
        return personTimeOffTypeEn;
    }

    public void setPersonTimeOffTypeEn(Integer personTimeOffTypeEn) {
        this.personTimeOffTypeEn = personTimeOffTypeEn;
    }
}
