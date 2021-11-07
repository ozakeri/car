
package gap.com.car.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import gap.com.car.model.driverprofile.Company;

public class DriverDailyActivity implements Parcelable {

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("dateCreation")
    @Expose
    private String dateCreation;
    @SerializedName("nameFv")
    @Expose
    private String nameFv;
    @SerializedName("processStatus")
    @Expose
    private Integer processStatus;
    @SerializedName("shiftTypeEn")
    @Expose
    private Integer shiftTypeEn;
    @SerializedName("processStatus3_text")
    @Expose
    private String processStatus3Text;
    @SerializedName("endTimeAc")
    @Expose
    private String endTimeAc;
    @SerializedName("entityNameEn_text")
    @Expose
    private String entityNameEnText;
    @SerializedName("colorStyleClass")
    @Expose
    private String colorStyleClass;
    @SerializedName("startTimeAc")
    @Expose
    private String startTimeAc;
    @SerializedName("processStatus2")
    @Expose
    private Integer processStatus2;
    @SerializedName("finishLocateEn_text")
    @Expose
    private String finishLocateEnText;
    @SerializedName("processStatus3")
    @Expose
    private Integer processStatus3;
    @SerializedName("driverJobTypeEn")
    @Expose
    private Integer driverJobTypeEn;
    @SerializedName("driverJobTypeEn_text")
    @Expose
    private String driverJobTypeEnText;
    @SerializedName("processStatus2_text")
    @Expose
    private String processStatus2Text;
    @SerializedName("halfPathNoGps")
    @Expose
    private Integer halfPathNoGps;
    @SerializedName("shiftTypeEn_text")
    @Expose
    private String shiftTypeEnText;
    @SerializedName("tariffActForSalary")
    @Expose
    private Boolean tariffActForSalary;
    @SerializedName("startTime")
    @Expose
    private String startTime;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("entityNameEn")
    @Expose
    private Integer entityNameEn;
    @SerializedName("showTimeRemainingUpForExpire")
    @Expose
    private Boolean showTimeRemainingUpForExpire;
    @SerializedName("dailyEventSOSIs")
    @Expose
    private Boolean dailyEventSOSIs;
    @SerializedName("processStatus_text")
    @Expose
    private String processStatusText;
    @SerializedName("halfPathNoSum")
    @Expose
    private Integer halfPathNoSum;
    @SerializedName("activeDriver")
    @Expose
    private Boolean activeDriver;
    @SerializedName("startLocateEn_text")
    @Expose
    private String startLocateEnText;
    @SerializedName("delayAllowed")
    @Expose
    private Boolean delayAllowed;
    @SerializedName("endTime")
    @Expose
    private String endTime;
    @SerializedName("status_text")
    @Expose
    private String statusText;
    @SerializedName("canBeEvaluateTariff")
    @Expose
    private Boolean canBeEvaluateTariff;
    @SerializedName("finishLocateEn")
    @Expose
    private Integer finishLocateEn;
    @SerializedName("startLocateEn")
    @Expose
    private Integer startLocateEn;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("dailyEventListOld")
    @Expose
    private List<DailyEventListOld> dailyEventListOld = null;
    @SerializedName("carDailyEventList")
    @Expose
    private List<CarDailyEventList> carDailyEventList = null;
    @SerializedName("companyProfit")
    @Expose
    private CompanyProfit companyProfit;
    @SerializedName("companyIsChangedFV")
    @Expose
    private boolean companyIsChangedFV;

    @SerializedName("driverShiftPlanIsChangedFV")
    @Expose
    private boolean driverShiftPlanIsChangedFV;

    @SerializedName("carPlanIsChangedFV")
    @Expose
    private boolean carPlanIsChangedFV;

    @SerializedName("linePlanIsChangedFV")
    @Expose
    private boolean linePlanIsChangedFV;

    @SerializedName("driverShiftChangedStrFV")
    @Expose
    private String driverShiftChangedStrFV;

    @SerializedName("carChangedStrFV")
    @Expose
    private String carChangedStrFV;

    @SerializedName("lineChangedStrFV")
    @Expose
    private String lineChangedStrFV;

    @SerializedName("companyChangedFV")
    @Expose
    private Company companyChangedFV;

    @SerializedName("driverShiftPlanStrFV")
    @Expose
    private String driverShiftPlanStrFV;

    @SerializedName("carPlanStrFV")
    @Expose
    private String carPlanStrFV;

    @SerializedName("linePlanStrFV")
    @Expose
    private String linePlanStrFV;

    //---------------------------

    @SerializedName("showAlertFV")
    @Expose
    public Boolean showAlertFV;


    @SerializedName("driverTariffIsClosedAsWorkOnPSFV")
    @Expose
    public Boolean driverTariffIsClosedAsWorkOnPSFV;


    @SerializedName("lineIsShowFV")
    @Expose
    public Boolean lineIsShowFV;


    @SerializedName("driverEDAList")
    @Expose
    public List<DriverEDAList> driverEDAList = null;

    @SerializedName("driverChangedEDAList")
    @Expose
    public List<DriverChangedEDAList> driverChangedEDALists = null;

    @SerializedName("companyNameFV")
    @Expose
    public String companyNameFV;
    @SerializedName("processStatusChangeToConfirmIsPossible")
    @Expose
    public Boolean processStatusChangeToConfirmIsPossible;

    @SerializedName("driverTariffIsWaitFoDriverEntryOnPS")
    @Expose
    public Boolean driverTariffIsWaitFoDriverEntryOnPS;
    @SerializedName("statusChangeToInactiveIsPossible")
    @Expose
    public Boolean statusChangeToInactiveIsPossible;

    @SerializedName("etCardHalfPathInfoVOListFV_DurationWorkOnMinute")
    @Expose
    public Integer etCardHalfPathInfoVOListFVDurationWorkOnMinute;


    @SerializedName("driverTariffIsOnWorkingOnPSFV")
    @Expose
    public Boolean driverTariffIsOnWorkingOnPSFV;
    @SerializedName("showCompanyController2")
    @Expose
    public Boolean showCompanyController2;


    @SerializedName("dailyEventVOListSize")
    @Expose
    public Integer dailyEventVOListSize;
    @SerializedName("driverTariffChangeShiftDriverTogetherIsPossibleFV")
    @Expose
    public Boolean driverTariffChangeShiftDriverTogetherIsPossibleFV;

    @SerializedName("driverTariffIsOpenFV")
    @Expose
    public Boolean driverTariffIsOpenFV;
    @SerializedName("car")
    @Expose
    public Car car;

    @SerializedName("driverHavePlanFV")
    @Expose
    public Boolean driverHavePlanFV;

    @SerializedName("etCardDataVOList_sumCountEt")
    @Expose
    public Integer etCardDataVOListSumCountEt;

    @SerializedName("personTimeOffMustBeSetFV")
    @Expose
    public Boolean personTimeOffMustBeSetFV;

    @SerializedName("dailyEventListSize")
    @Expose
    public Integer dailyEventListSize;

    protected DriverDailyActivity(Parcel in) {
        date = in.readString();
        dateCreation = in.readString();
        nameFv = in.readString();
        if (in.readByte() == 0) {
            processStatus = null;
        } else {
            processStatus = in.readInt();
        }
        if (in.readByte() == 0) {
            shiftTypeEn = null;
        } else {
            shiftTypeEn = in.readInt();
        }
        processStatus3Text = in.readString();
        endTimeAc = in.readString();
        entityNameEnText = in.readString();
        colorStyleClass = in.readString();
        startTimeAc = in.readString();
        if (in.readByte() == 0) {
            processStatus2 = null;
        } else {
            processStatus2 = in.readInt();
        }
        finishLocateEnText = in.readString();
        if (in.readByte() == 0) {
            processStatus3 = null;
        } else {
            processStatus3 = in.readInt();
        }
        if (in.readByte() == 0) {
            driverJobTypeEn = null;
        } else {
            driverJobTypeEn = in.readInt();
        }
        driverJobTypeEnText = in.readString();
        processStatus2Text = in.readString();
        if (in.readByte() == 0) {
            halfPathNoGps = null;
        } else {
            halfPathNoGps = in.readInt();
        }
        shiftTypeEnText = in.readString();
        byte tmpTariffActForSalary = in.readByte();
        tariffActForSalary = tmpTariffActForSalary == 0 ? null : tmpTariffActForSalary == 1;
        startTime = in.readString();
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        if (in.readByte() == 0) {
            entityNameEn = null;
        } else {
            entityNameEn = in.readInt();
        }
        byte tmpShowTimeRemainingUpForExpire = in.readByte();
        showTimeRemainingUpForExpire = tmpShowTimeRemainingUpForExpire == 0 ? null : tmpShowTimeRemainingUpForExpire == 1;
        byte tmpDailyEventSOSIs = in.readByte();
        dailyEventSOSIs = tmpDailyEventSOSIs == 0 ? null : tmpDailyEventSOSIs == 1;
        processStatusText = in.readString();
        if (in.readByte() == 0) {
            halfPathNoSum = null;
        } else {
            halfPathNoSum = in.readInt();
        }
        byte tmpActiveDriver = in.readByte();
        activeDriver = tmpActiveDriver == 0 ? null : tmpActiveDriver == 1;
        startLocateEnText = in.readString();
        byte tmpDelayAllowed = in.readByte();
        delayAllowed = tmpDelayAllowed == 0 ? null : tmpDelayAllowed == 1;
        endTime = in.readString();
        statusText = in.readString();
        byte tmpCanBeEvaluateTariff = in.readByte();
        canBeEvaluateTariff = tmpCanBeEvaluateTariff == 0 ? null : tmpCanBeEvaluateTariff == 1;
        if (in.readByte() == 0) {
            finishLocateEn = null;
        } else {
            finishLocateEn = in.readInt();
        }
        if (in.readByte() == 0) {
            startLocateEn = null;
        } else {
            startLocateEn = in.readInt();
        }
        if (in.readByte() == 0) {
            status = null;
        } else {
            status = in.readInt();
        }
        description = in.readString();
        dailyEventListOld = in.createTypedArrayList(DailyEventListOld.CREATOR);
        carDailyEventList = in.createTypedArrayList(CarDailyEventList.CREATOR);
        companyIsChangedFV = in.readByte() != 0;
        driverShiftPlanIsChangedFV = in.readByte() != 0;
        carPlanIsChangedFV = in.readByte() != 0;
        linePlanIsChangedFV = in.readByte() != 0;
        driverShiftChangedStrFV = in.readString();
        carChangedStrFV = in.readString();
        lineChangedStrFV = in.readString();
        driverShiftPlanStrFV = in.readString();
        carPlanStrFV = in.readString();
        linePlanStrFV = in.readString();
        byte tmpShowAlertFV = in.readByte();
        showAlertFV = tmpShowAlertFV == 0 ? null : tmpShowAlertFV == 1;
        byte tmpDriverTariffIsClosedAsWorkOnPSFV = in.readByte();
        driverTariffIsClosedAsWorkOnPSFV = tmpDriverTariffIsClosedAsWorkOnPSFV == 0 ? null : tmpDriverTariffIsClosedAsWorkOnPSFV == 1;
        byte tmpLineIsShowFV = in.readByte();
        lineIsShowFV = tmpLineIsShowFV == 0 ? null : tmpLineIsShowFV == 1;
        companyNameFV = in.readString();
        byte tmpProcessStatusChangeToConfirmIsPossible = in.readByte();
        processStatusChangeToConfirmIsPossible = tmpProcessStatusChangeToConfirmIsPossible == 0 ? null : tmpProcessStatusChangeToConfirmIsPossible == 1;
        byte tmpDriverTariffIsWaitFoDriverEntryOnPS = in.readByte();
        driverTariffIsWaitFoDriverEntryOnPS = tmpDriverTariffIsWaitFoDriverEntryOnPS == 0 ? null : tmpDriverTariffIsWaitFoDriverEntryOnPS == 1;
        byte tmpStatusChangeToInactiveIsPossible = in.readByte();
        statusChangeToInactiveIsPossible = tmpStatusChangeToInactiveIsPossible == 0 ? null : tmpStatusChangeToInactiveIsPossible == 1;
        if (in.readByte() == 0) {
            etCardHalfPathInfoVOListFVDurationWorkOnMinute = null;
        } else {
            etCardHalfPathInfoVOListFVDurationWorkOnMinute = in.readInt();
        }
        byte tmpDriverTariffIsOnWorkingOnPSFV = in.readByte();
        driverTariffIsOnWorkingOnPSFV = tmpDriverTariffIsOnWorkingOnPSFV == 0 ? null : tmpDriverTariffIsOnWorkingOnPSFV == 1;
        byte tmpShowCompanyController2 = in.readByte();
        showCompanyController2 = tmpShowCompanyController2 == 0 ? null : tmpShowCompanyController2 == 1;
        if (in.readByte() == 0) {
            dailyEventVOListSize = null;
        } else {
            dailyEventVOListSize = in.readInt();
        }
        byte tmpDriverTariffChangeShiftDriverTogetherIsPossibleFV = in.readByte();
        driverTariffChangeShiftDriverTogetherIsPossibleFV = tmpDriverTariffChangeShiftDriverTogetherIsPossibleFV == 0 ? null : tmpDriverTariffChangeShiftDriverTogetherIsPossibleFV == 1;
        byte tmpDriverTariffIsOpenFV = in.readByte();
        driverTariffIsOpenFV = tmpDriverTariffIsOpenFV == 0 ? null : tmpDriverTariffIsOpenFV == 1;
        car = in.readParcelable(Car.class.getClassLoader());
        byte tmpDriverHavePlanFV = in.readByte();
        driverHavePlanFV = tmpDriverHavePlanFV == 0 ? null : tmpDriverHavePlanFV == 1;
        if (in.readByte() == 0) {
            etCardDataVOListSumCountEt = null;
        } else {
            etCardDataVOListSumCountEt = in.readInt();
        }
        byte tmpPersonTimeOffMustBeSetFV = in.readByte();
        personTimeOffMustBeSetFV = tmpPersonTimeOffMustBeSetFV == 0 ? null : tmpPersonTimeOffMustBeSetFV == 1;
        if (in.readByte() == 0) {
            dailyEventListSize = null;
        } else {
            dailyEventListSize = in.readInt();
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(date);
        dest.writeString(dateCreation);
        dest.writeString(nameFv);
        if (processStatus == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(processStatus);
        }
        if (shiftTypeEn == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(shiftTypeEn);
        }
        dest.writeString(processStatus3Text);
        dest.writeString(endTimeAc);
        dest.writeString(entityNameEnText);
        dest.writeString(colorStyleClass);
        dest.writeString(startTimeAc);
        if (processStatus2 == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(processStatus2);
        }
        dest.writeString(finishLocateEnText);
        if (processStatus3 == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(processStatus3);
        }
        if (driverJobTypeEn == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(driverJobTypeEn);
        }
        dest.writeString(driverJobTypeEnText);
        dest.writeString(processStatus2Text);
        if (halfPathNoGps == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(halfPathNoGps);
        }
        dest.writeString(shiftTypeEnText);
        dest.writeByte((byte) (tariffActForSalary == null ? 0 : tariffActForSalary ? 1 : 2));
        dest.writeString(startTime);
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        if (entityNameEn == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(entityNameEn);
        }
        dest.writeByte((byte) (showTimeRemainingUpForExpire == null ? 0 : showTimeRemainingUpForExpire ? 1 : 2));
        dest.writeByte((byte) (dailyEventSOSIs == null ? 0 : dailyEventSOSIs ? 1 : 2));
        dest.writeString(processStatusText);
        if (halfPathNoSum == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(halfPathNoSum);
        }
        dest.writeByte((byte) (activeDriver == null ? 0 : activeDriver ? 1 : 2));
        dest.writeString(startLocateEnText);
        dest.writeByte((byte) (delayAllowed == null ? 0 : delayAllowed ? 1 : 2));
        dest.writeString(endTime);
        dest.writeString(statusText);
        dest.writeByte((byte) (canBeEvaluateTariff == null ? 0 : canBeEvaluateTariff ? 1 : 2));
        if (finishLocateEn == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(finishLocateEn);
        }
        if (startLocateEn == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(startLocateEn);
        }
        if (status == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(status);
        }
        dest.writeString(description);
        dest.writeTypedList(dailyEventListOld);
        dest.writeTypedList(carDailyEventList);
        dest.writeByte((byte) (companyIsChangedFV ? 1 : 0));
        dest.writeByte((byte) (driverShiftPlanIsChangedFV ? 1 : 0));
        dest.writeByte((byte) (carPlanIsChangedFV ? 1 : 0));
        dest.writeByte((byte) (linePlanIsChangedFV ? 1 : 0));
        dest.writeString(driverShiftChangedStrFV);
        dest.writeString(carChangedStrFV);
        dest.writeString(lineChangedStrFV);
        dest.writeString(driverShiftPlanStrFV);
        dest.writeString(carPlanStrFV);
        dest.writeString(linePlanStrFV);
        dest.writeByte((byte) (showAlertFV == null ? 0 : showAlertFV ? 1 : 2));
        dest.writeByte((byte) (driverTariffIsClosedAsWorkOnPSFV == null ? 0 : driverTariffIsClosedAsWorkOnPSFV ? 1 : 2));
        dest.writeByte((byte) (lineIsShowFV == null ? 0 : lineIsShowFV ? 1 : 2));
        dest.writeString(companyNameFV);
        dest.writeByte((byte) (processStatusChangeToConfirmIsPossible == null ? 0 : processStatusChangeToConfirmIsPossible ? 1 : 2));
        dest.writeByte((byte) (driverTariffIsWaitFoDriverEntryOnPS == null ? 0 : driverTariffIsWaitFoDriverEntryOnPS ? 1 : 2));
        dest.writeByte((byte) (statusChangeToInactiveIsPossible == null ? 0 : statusChangeToInactiveIsPossible ? 1 : 2));
        if (etCardHalfPathInfoVOListFVDurationWorkOnMinute == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(etCardHalfPathInfoVOListFVDurationWorkOnMinute);
        }
        dest.writeByte((byte) (driverTariffIsOnWorkingOnPSFV == null ? 0 : driverTariffIsOnWorkingOnPSFV ? 1 : 2));
        dest.writeByte((byte) (showCompanyController2 == null ? 0 : showCompanyController2 ? 1 : 2));
        if (dailyEventVOListSize == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(dailyEventVOListSize);
        }
        dest.writeByte((byte) (driverTariffChangeShiftDriverTogetherIsPossibleFV == null ? 0 : driverTariffChangeShiftDriverTogetherIsPossibleFV ? 1 : 2));
        dest.writeByte((byte) (driverTariffIsOpenFV == null ? 0 : driverTariffIsOpenFV ? 1 : 2));
        dest.writeParcelable(car, flags);
        dest.writeByte((byte) (driverHavePlanFV == null ? 0 : driverHavePlanFV ? 1 : 2));
        if (etCardDataVOListSumCountEt == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(etCardDataVOListSumCountEt);
        }
        dest.writeByte((byte) (personTimeOffMustBeSetFV == null ? 0 : personTimeOffMustBeSetFV ? 1 : 2));
        if (dailyEventListSize == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(dailyEventListSize);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DriverDailyActivity> CREATOR = new Creator<DriverDailyActivity>() {
        @Override
        public DriverDailyActivity createFromParcel(Parcel in) {
            return new DriverDailyActivity(in);
        }

        @Override
        public DriverDailyActivity[] newArray(int size) {
            return new DriverDailyActivity[size];
        }
    };

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

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

    public Integer getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(Integer processStatus) {
        this.processStatus = processStatus;
    }

    public Integer getShiftTypeEn() {
        return shiftTypeEn;
    }

    public void setShiftTypeEn(Integer shiftTypeEn) {
        this.shiftTypeEn = shiftTypeEn;
    }

    public String getProcessStatus3Text() {
        return processStatus3Text;
    }

    public void setProcessStatus3Text(String processStatus3Text) {
        this.processStatus3Text = processStatus3Text;
    }

    public String getEndTimeAc() {
        return endTimeAc;
    }

    public void setEndTimeAc(String endTimeAc) {
        this.endTimeAc = endTimeAc;
    }

    public String getEntityNameEnText() {
        return entityNameEnText;
    }

    public void setEntityNameEnText(String entityNameEnText) {
        this.entityNameEnText = entityNameEnText;
    }

    public String getColorStyleClass() {
        return colorStyleClass;
    }

    public void setColorStyleClass(String colorStyleClass) {
        this.colorStyleClass = colorStyleClass;
    }

    public String getStartTimeAc() {
        return startTimeAc;
    }

    public void setStartTimeAc(String startTimeAc) {
        this.startTimeAc = startTimeAc;
    }

    public Integer getProcessStatus2() {
        return processStatus2;
    }

    public void setProcessStatus2(Integer processStatus2) {
        this.processStatus2 = processStatus2;
    }

    public String getFinishLocateEnText() {
        return finishLocateEnText;
    }

    public void setFinishLocateEnText(String finishLocateEnText) {
        this.finishLocateEnText = finishLocateEnText;
    }

    public Integer getProcessStatus3() {
        return processStatus3;
    }

    public void setProcessStatus3(Integer processStatus3) {
        this.processStatus3 = processStatus3;
    }

    public Integer getDriverJobTypeEn() {
        return driverJobTypeEn;
    }

    public void setDriverJobTypeEn(Integer driverJobTypeEn) {
        this.driverJobTypeEn = driverJobTypeEn;
    }

    public String getDriverJobTypeEnText() {
        return driverJobTypeEnText;
    }

    public void setDriverJobTypeEnText(String driverJobTypeEnText) {
        this.driverJobTypeEnText = driverJobTypeEnText;
    }

    public String getProcessStatus2Text() {
        return processStatus2Text;
    }

    public void setProcessStatus2Text(String processStatus2Text) {
        this.processStatus2Text = processStatus2Text;
    }

    public Integer getHalfPathNoGps() {
        return halfPathNoGps;
    }

    public void setHalfPathNoGps(Integer halfPathNoGps) {
        this.halfPathNoGps = halfPathNoGps;
    }

    public String getShiftTypeEnText() {
        return shiftTypeEnText;
    }

    public void setShiftTypeEnText(String shiftTypeEnText) {
        this.shiftTypeEnText = shiftTypeEnText;
    }

    public Boolean getTariffActForSalary() {
        return tariffActForSalary;
    }

    public void setTariffActForSalary(Boolean tariffActForSalary) {
        this.tariffActForSalary = tariffActForSalary;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEntityNameEn() {
        return entityNameEn;
    }

    public void setEntityNameEn(Integer entityNameEn) {
        this.entityNameEn = entityNameEn;
    }

    public Boolean getShowTimeRemainingUpForExpire() {
        return showTimeRemainingUpForExpire;
    }

    public void setShowTimeRemainingUpForExpire(Boolean showTimeRemainingUpForExpire) {
        this.showTimeRemainingUpForExpire = showTimeRemainingUpForExpire;
    }

    public Boolean getDailyEventSOSIs() {
        return dailyEventSOSIs;
    }

    public void setDailyEventSOSIs(Boolean dailyEventSOSIs) {
        this.dailyEventSOSIs = dailyEventSOSIs;
    }

    public String getProcessStatusText() {
        return processStatusText;
    }

    public void setProcessStatusText(String processStatusText) {
        this.processStatusText = processStatusText;
    }

    public Integer getHalfPathNoSum() {
        return halfPathNoSum;
    }

    public void setHalfPathNoSum(Integer halfPathNoSum) {
        this.halfPathNoSum = halfPathNoSum;
    }

    public Boolean getActiveDriver() {
        return activeDriver;
    }

    public void setActiveDriver(Boolean activeDriver) {
        this.activeDriver = activeDriver;
    }

    public String getStartLocateEnText() {
        return startLocateEnText;
    }

    public void setStartLocateEnText(String startLocateEnText) {
        this.startLocateEnText = startLocateEnText;
    }

    public Boolean getDelayAllowed() {
        return delayAllowed;
    }

    public void setDelayAllowed(Boolean delayAllowed) {
        this.delayAllowed = delayAllowed;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public Boolean getCanBeEvaluateTariff() {
        return canBeEvaluateTariff;
    }

    public void setCanBeEvaluateTariff(Boolean canBeEvaluateTariff) {
        this.canBeEvaluateTariff = canBeEvaluateTariff;
    }

    public Integer getFinishLocateEn() {
        return finishLocateEn;
    }

    public void setFinishLocateEn(Integer finishLocateEn) {
        this.finishLocateEn = finishLocateEn;
    }

    public Integer getStartLocateEn() {
        return startLocateEn;
    }

    public void setStartLocateEn(Integer startLocateEn) {
        this.startLocateEn = startLocateEn;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<DailyEventListOld> getDailyEventListOld() {
        return dailyEventListOld;
    }

    public void setDailyEventListOld(List<DailyEventListOld> dailyEventListOld) {
        this.dailyEventListOld = dailyEventListOld;
    }

    public List<CarDailyEventList> getCarDailyEventList() {
        return carDailyEventList;
    }

    public void setCarDailyEventList(List<CarDailyEventList> carDailyEventList) {
        this.carDailyEventList = carDailyEventList;
    }

    public CompanyProfit getCompanyProfit() {
        return companyProfit;
    }

    public void setCompanyProfit(CompanyProfit companyProfit) {
        this.companyProfit = companyProfit;
    }

    public boolean isCompanyIsChangedFV() {
        return companyIsChangedFV;
    }

    public void setCompanyIsChangedFV(boolean companyIsChangedFV) {
        this.companyIsChangedFV = companyIsChangedFV;
    }

    public boolean isDriverShiftPlanIsChangedFV() {
        return driverShiftPlanIsChangedFV;
    }

    public void setDriverShiftPlanIsChangedFV(boolean driverShiftPlanIsChangedFV) {
        this.driverShiftPlanIsChangedFV = driverShiftPlanIsChangedFV;
    }

    public boolean isCarPlanIsChangedFV() {
        return carPlanIsChangedFV;
    }

    public void setCarPlanIsChangedFV(boolean carPlanIsChangedFV) {
        this.carPlanIsChangedFV = carPlanIsChangedFV;
    }

    public boolean isLinePlanIsChangedFV() {
        return linePlanIsChangedFV;
    }

    public void setLinePlanIsChangedFV(boolean linePlanIsChangedFV) {
        this.linePlanIsChangedFV = linePlanIsChangedFV;
    }

    public String getDriverShiftChangedStrFV() {
        return driverShiftChangedStrFV;
    }

    public void setDriverShiftChangedStrFV(String driverShiftChangedStrFV) {
        this.driverShiftChangedStrFV = driverShiftChangedStrFV;
    }

    public String getCarChangedStrFV() {
        return carChangedStrFV;
    }

    public void setCarChangedStrFV(String carChangedStrFV) {
        this.carChangedStrFV = carChangedStrFV;
    }

    public String getLineChangedStrFV() {
        return lineChangedStrFV;
    }

    public void setLineChangedStrFV(String lineChangedStrFV) {
        this.lineChangedStrFV = lineChangedStrFV;
    }

    public Company getCompanyChangedFV() {
        return companyChangedFV;
    }

    public void setCompanyChangedFV(Company companyChangedFV) {
        this.companyChangedFV = companyChangedFV;
    }

    public String getDriverShiftPlanStrFV() {
        return driverShiftPlanStrFV;
    }

    public void setDriverShiftPlanStrFV(String driverShiftPlanStrFV) {
        this.driverShiftPlanStrFV = driverShiftPlanStrFV;
    }

    public String getCarPlanStrFV() {
        return carPlanStrFV;
    }

    public void setCarPlanStrFV(String carPlanStrFV) {
        this.carPlanStrFV = carPlanStrFV;
    }

    public String getLinePlanStrFV() {
        return linePlanStrFV;
    }

    public void setLinePlanStrFV(String linePlanStrFV) {
        this.linePlanStrFV = linePlanStrFV;
    }

    public Boolean getShowAlertFV() {
        return showAlertFV;
    }

    public void setShowAlertFV(Boolean showAlertFV) {
        this.showAlertFV = showAlertFV;
    }

    public Boolean getDriverTariffIsClosedAsWorkOnPSFV() {
        return driverTariffIsClosedAsWorkOnPSFV;
    }

    public void setDriverTariffIsClosedAsWorkOnPSFV(Boolean driverTariffIsClosedAsWorkOnPSFV) {
        this.driverTariffIsClosedAsWorkOnPSFV = driverTariffIsClosedAsWorkOnPSFV;
    }

    public Boolean getLineIsShowFV() {
        return lineIsShowFV;
    }

    public void setLineIsShowFV(Boolean lineIsShowFV) {
        this.lineIsShowFV = lineIsShowFV;
    }

    public List<DriverEDAList> getDriverEDAList() {
        return driverEDAList;
    }

    public void setDriverEDAList(List<DriverEDAList> driverEDAList) {
        this.driverEDAList = driverEDAList;
    }

    public List<DriverChangedEDAList> getDriverChangedEDALists() {
        return driverChangedEDALists;
    }

    public void setDriverChangedEDALists(List<DriverChangedEDAList> driverChangedEDALists) {
        this.driverChangedEDALists = driverChangedEDALists;
    }

    public String getCompanyNameFV() {
        return companyNameFV;
    }

    public void setCompanyNameFV(String companyNameFV) {
        this.companyNameFV = companyNameFV;
    }

    public Boolean getProcessStatusChangeToConfirmIsPossible() {
        return processStatusChangeToConfirmIsPossible;
    }

    public void setProcessStatusChangeToConfirmIsPossible(Boolean processStatusChangeToConfirmIsPossible) {
        this.processStatusChangeToConfirmIsPossible = processStatusChangeToConfirmIsPossible;
    }

    public Boolean getDriverTariffIsWaitFoDriverEntryOnPS() {
        return driverTariffIsWaitFoDriverEntryOnPS;
    }

    public void setDriverTariffIsWaitFoDriverEntryOnPS(Boolean driverTariffIsWaitFoDriverEntryOnPS) {
        this.driverTariffIsWaitFoDriverEntryOnPS = driverTariffIsWaitFoDriverEntryOnPS;
    }

    public Boolean getStatusChangeToInactiveIsPossible() {
        return statusChangeToInactiveIsPossible;
    }

    public void setStatusChangeToInactiveIsPossible(Boolean statusChangeToInactiveIsPossible) {
        this.statusChangeToInactiveIsPossible = statusChangeToInactiveIsPossible;
    }

    public Integer getEtCardHalfPathInfoVOListFVDurationWorkOnMinute() {
        return etCardHalfPathInfoVOListFVDurationWorkOnMinute;
    }

    public void setEtCardHalfPathInfoVOListFVDurationWorkOnMinute(Integer etCardHalfPathInfoVOListFVDurationWorkOnMinute) {
        this.etCardHalfPathInfoVOListFVDurationWorkOnMinute = etCardHalfPathInfoVOListFVDurationWorkOnMinute;
    }

    public Boolean getDriverTariffIsOnWorkingOnPSFV() {
        return driverTariffIsOnWorkingOnPSFV;
    }

    public void setDriverTariffIsOnWorkingOnPSFV(Boolean driverTariffIsOnWorkingOnPSFV) {
        this.driverTariffIsOnWorkingOnPSFV = driverTariffIsOnWorkingOnPSFV;
    }

    public Boolean getShowCompanyController2() {
        return showCompanyController2;
    }

    public void setShowCompanyController2(Boolean showCompanyController2) {
        this.showCompanyController2 = showCompanyController2;
    }

    public Integer getDailyEventVOListSize() {
        return dailyEventVOListSize;
    }

    public void setDailyEventVOListSize(Integer dailyEventVOListSize) {
        this.dailyEventVOListSize = dailyEventVOListSize;
    }

    public Boolean getDriverTariffChangeShiftDriverTogetherIsPossibleFV() {
        return driverTariffChangeShiftDriverTogetherIsPossibleFV;
    }

    public void setDriverTariffChangeShiftDriverTogetherIsPossibleFV(Boolean driverTariffChangeShiftDriverTogetherIsPossibleFV) {
        this.driverTariffChangeShiftDriverTogetherIsPossibleFV = driverTariffChangeShiftDriverTogetherIsPossibleFV;
    }

    public Boolean getDriverTariffIsOpenFV() {
        return driverTariffIsOpenFV;
    }

    public void setDriverTariffIsOpenFV(Boolean driverTariffIsOpenFV) {
        this.driverTariffIsOpenFV = driverTariffIsOpenFV;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Boolean getDriverHavePlanFV() {
        return driverHavePlanFV;
    }

    public void setDriverHavePlanFV(Boolean driverHavePlanFV) {
        this.driverHavePlanFV = driverHavePlanFV;
    }

    public Integer getEtCardDataVOListSumCountEt() {
        return etCardDataVOListSumCountEt;
    }

    public void setEtCardDataVOListSumCountEt(Integer etCardDataVOListSumCountEt) {
        this.etCardDataVOListSumCountEt = etCardDataVOListSumCountEt;
    }

    public Boolean getPersonTimeOffMustBeSetFV() {
        return personTimeOffMustBeSetFV;
    }

    public void setPersonTimeOffMustBeSetFV(Boolean personTimeOffMustBeSetFV) {
        this.personTimeOffMustBeSetFV = personTimeOffMustBeSetFV;
    }

    public Integer getDailyEventListSize() {
        return dailyEventListSize;
    }

    public void setDailyEventListSize(Integer dailyEventListSize) {
        this.dailyEventListSize = dailyEventListSize;
    }
}
