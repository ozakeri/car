package gap.com.car.model.carinvoice;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CarDailyInfo implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("halfPathAcpt")
    @Expose
    private String halfPathAcpt;
    @SerializedName("timeMinWorkInLine")
    @Expose
    private String timeMinWorkInLine;
    @SerializedName("kmInLineFV")
    @Expose
    private String kmInLineFV;
    @SerializedName("kmAll")
    @Expose
    private String kmAll;
    @SerializedName("fuelValue")
    @Expose
    private String fuelValue;
    @SerializedName("countEtPass")
    @Expose
    private String countEtPass;
    @SerializedName("priceEtPass")
    @Expose
    private String priceEtPass;
    @SerializedName("countEtCash")
    @Expose
    private String countEtCash;
    @SerializedName("processStatus")
    @Expose
    private String processStatus;
    @SerializedName("processStatus_text")
    @Expose
    private String processStatus_text;

    protected CarDailyInfo(Parcel in) {
        id = in.readInt();
        halfPathAcpt = in.readString();
        timeMinWorkInLine = in.readString();
        kmInLineFV = in.readString();
        kmAll = in.readString();
        fuelValue = in.readString();
        countEtPass = in.readString();
        priceEtPass = in.readString();
        countEtCash = in.readString();
        priceEtCash = in.readString();
        etCardNo = in.readString();
        priceEtSumFV = in.readString();
        countEtPassSubPey = in.readString();
        priceSubDF_2 = in.readString();
        dailyEventList = in.createTypedArrayList(DailyEventList.CREATOR);
        gpsHalfPathInfoList = in.createTypedArrayList(HalfPathInfoList.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(halfPathAcpt);
        dest.writeString(timeMinWorkInLine);
        dest.writeString(kmInLineFV);
        dest.writeString(kmAll);
        dest.writeString(fuelValue);
        dest.writeString(countEtPass);
        dest.writeString(priceEtPass);
        dest.writeString(countEtCash);
        dest.writeString(priceEtCash);
        dest.writeString(etCardNo);
        dest.writeString(priceEtSumFV);
        dest.writeString(countEtPassSubPey);
        dest.writeString(priceSubDF_2);
        dest.writeTypedList(dailyEventList);
        dest.writeTypedList(gpsHalfPathInfoList);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CarDailyInfo> CREATOR = new Creator<CarDailyInfo>() {
        @Override
        public CarDailyInfo createFromParcel(Parcel in) {
            return new CarDailyInfo(in);
        }

        @Override
        public CarDailyInfo[] newArray(int size) {
            return new CarDailyInfo[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHalfPathAcpt() {
        return halfPathAcpt;
    }

    public void setHalfPathAcpt(String halfPathAcpt) {
        this.halfPathAcpt = halfPathAcpt;
    }

    public String getTimeMinWorkInLine() {
        return timeMinWorkInLine;
    }

    public void setTimeMinWorkInLine(String timeMinWorkInLine) {
        this.timeMinWorkInLine = timeMinWorkInLine;
    }

    public String getKmInLineFV() {
        return kmInLineFV;
    }

    public void setKmInLineFV(String kmInLineFV) {
        this.kmInLineFV = kmInLineFV;
    }

    public String getKmAll() {
        return kmAll;
    }

    public void setKmAll(String kmAll) {
        this.kmAll = kmAll;
    }

    public String getFuelValue() {
        return fuelValue;
    }

    public void setFuelValue(String fuelValue) {
        this.fuelValue = fuelValue;
    }

    public String getCountEtPass() {
        return countEtPass;
    }

    public void setCountEtPass(String countEtPass) {
        this.countEtPass = countEtPass;
    }

    public String getPriceEtPass() {
        return priceEtPass;
    }

    public void setPriceEtPass(String priceEtPass) {
        this.priceEtPass = priceEtPass;
    }

    public String getCountEtCash() {
        return countEtCash;
    }

    public void setCountEtCash(String countEtCash) {
        this.countEtCash = countEtCash;
    }

    public String getPriceEtCash() {
        return priceEtCash;
    }

    public void setPriceEtCash(String priceEtCash) {
        this.priceEtCash = priceEtCash;
    }

    public String getEtCardNo() {
        return etCardNo;
    }

    public void setEtCardNo(String etCardNo) {
        this.etCardNo = etCardNo;
    }

    public String getPriceEtSumFV() {
        return priceEtSumFV;
    }

    public void setPriceEtSumFV(String priceEtSumFV) {
        this.priceEtSumFV = priceEtSumFV;
    }

    public String getCountEtPassSubPey() {
        return countEtPassSubPey;
    }

    public void setCountEtPassSubPey(String countEtPassSubPey) {
        this.countEtPassSubPey = countEtPassSubPey;
    }

    public String getPriceSubDF_2() {
        return priceSubDF_2;
    }

    public void setPriceSubDF_2(String priceSubDF_2) {
        this.priceSubDF_2 = priceSubDF_2;
    }

    public List<DailyEventList> getDailyEventList() {
        return dailyEventList;
    }

    public void setDailyEventList(List<DailyEventList> dailyEventList) {
        this.dailyEventList = dailyEventList;
    }

    public List<HalfPathInfoList> getGpsHalfPathInfoList() {
        return gpsHalfPathInfoList;
    }

    public void setGpsHalfPathInfoList(List<HalfPathInfoList> gpsHalfPathInfoList) {
        this.gpsHalfPathInfoList = gpsHalfPathInfoList;
    }

    public String getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus;
    }

    public String getProcessStatus_text() {
        return processStatus_text;
    }

    public void setProcessStatus_text(String processStatus_text) {
        this.processStatus_text = processStatus_text;
    }

    @SerializedName("priceEtCash")
    @Expose
    private String priceEtCash;
    @SerializedName("etCardNo")
    @Expose
    private String etCardNo;
    @SerializedName("priceEtSumFV")
    @Expose
    private String priceEtSumFV;
    @SerializedName("countEtPassSubPey")
    @Expose
    private String countEtPassSubPey;
    @SerializedName("priceSubDF_2")
    @Expose
    private String priceSubDF_2;
    @SerializedName("dailyEventList")
    @Expose
    private List<DailyEventList> dailyEventList;
    @SerializedName("gpsHalfPathInfoList")
    @Expose
    private List<HalfPathInfoList> gpsHalfPathInfoList;


}
