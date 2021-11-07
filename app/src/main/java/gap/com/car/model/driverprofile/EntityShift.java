
package gap.com.car.model.driverprofile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EntityShift {

    @SerializedName("entityBaseEn_text")
    @Expose
    private String entityBaseEnText;
    @SerializedName("nameFv1")
    @Expose
    private String nameFv1;
    @SerializedName("nameFv")
    @Expose
    private String nameFv;
    @SerializedName("shiftTypeEn")
    @Expose
    private Integer shiftTypeEn;
    @SerializedName("shiftTypeEn_text")
    @Expose
    private String shiftTypeEnText;
    @SerializedName("entityBaseEn")
    @Expose
    private Integer entityBaseEn;
    @SerializedName("shift")
    @Expose
    private Shift shift;
    @SerializedName("timingMethodOnBus")
    @Expose
    private Boolean timingMethodOnBus;
    @SerializedName("startDate")
    @Expose
    private String startDate;
    @SerializedName("rotatoryIs")
    @Expose
    private Boolean rotatoryIs;


    public String getEntityBaseEnText() {
        return entityBaseEnText;
    }

    public void setEntityBaseEnText(String entityBaseEnText) {
        this.entityBaseEnText = entityBaseEnText;
    }

    public String getNameFv1() {
        return nameFv1;
    }

    public void setNameFv1(String nameFv1) {
        this.nameFv1 = nameFv1;
    }

    public String getNameFv() {
        return nameFv;
    }

    public void setNameFv(String nameFv) {
        this.nameFv = nameFv;
    }

    public Integer getShiftTypeEn() {
        return shiftTypeEn;
    }

    public void setShiftTypeEn(Integer shiftTypeEn) {
        this.shiftTypeEn = shiftTypeEn;
    }

    public String getShiftTypeEnText() {
        return shiftTypeEnText;
    }

    public void setShiftTypeEnText(String shiftTypeEnText) {
        this.shiftTypeEnText = shiftTypeEnText;
    }

    public Integer getEntityBaseEn() {
        return entityBaseEn;
    }

    public void setEntityBaseEn(Integer entityBaseEn) {
        this.entityBaseEn = entityBaseEn;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    public Boolean getTimingMethodOnBus() {
        return timingMethodOnBus;
    }

    public void setTimingMethodOnBus(Boolean timingMethodOnBus) {
        this.timingMethodOnBus = timingMethodOnBus;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Boolean getRotatoryIs() {
        return rotatoryIs;
    }

    public void setRotatoryIs(Boolean rotatoryIs) {
        this.rotatoryIs = rotatoryIs;
    }
}
