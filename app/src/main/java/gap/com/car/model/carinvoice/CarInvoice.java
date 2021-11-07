package gap.com.car.model.carinvoice;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CarInvoice implements Parcelable {

    @SerializedName("halfPathNO")
    @Expose
    private int halfPathNO;
    @SerializedName("timeMinInLine")
    @Expose
    private int timeMinInLine;
    @SerializedName("kmInLineFV")
    @Expose
    private int kmInLineFV;
    @SerializedName("fuelValue")
    @Expose
    private int fuelValue;
    @SerializedName("countEtPass")
    @Expose
    private int countEtPass;
    @SerializedName("priceEtPass")
    @Expose
    private int priceEtPass;
    @SerializedName("etCardNo")
    @Expose
    private int etCardNo;
    @SerializedName("carDailyInfoList")
    @Expose
    private List<CarDailyInfoList> carDailyInfoList;
    @SerializedName("priceEtSumFV")
    @Expose
    private int priceEtSumFV;
    @SerializedName("dayActNo")
    @Expose
    private int dayActNo;
    @SerializedName("priceSubDF_2")
    @Expose
    private int priceSubDF_2;
    @SerializedName("priceIncomeFV")
    @Expose
    private int priceIncomeFV;
    @SerializedName("priceIncomeEstimateFV")
    @Expose
    private int priceIncomeEstimateFV;
    @SerializedName("calender")
    @Expose
    private Calender calender;

    public int getHalfPathNO() {
        return halfPathNO;
    }

    public void setHalfPathNO(int halfPathNO) {
        this.halfPathNO = halfPathNO;
    }

    public int getTimeMinInLine() {
        return timeMinInLine;
    }

    public void setTimeMinInLine(int timeMinInLine) {
        this.timeMinInLine = timeMinInLine;
    }

    public int getKmInLineFV() {
        return kmInLineFV;
    }

    public void setKmInLineFV(int kmInLineFV) {
        this.kmInLineFV = kmInLineFV;
    }

    public int getFuelValue() {
        return fuelValue;
    }

    public void setFuelValue(int fuelValue) {
        this.fuelValue = fuelValue;
    }

    public int getCountEtPass() {
        return countEtPass;
    }

    public void setCountEtPass(int countEtPass) {
        this.countEtPass = countEtPass;
    }

    public int getPriceEtPass() {
        return priceEtPass;
    }

    public void setPriceEtPass(int priceEtPass) {
        this.priceEtPass = priceEtPass;
    }

    public int getEtCardNo() {
        return etCardNo;
    }

    public void setEtCardNo(int etCardNo) {
        this.etCardNo = etCardNo;
    }

    public List<CarDailyInfoList> getCarDailyInfoList() {
        return carDailyInfoList;
    }

    public void setCarDailyInfoList(List<CarDailyInfoList> carDailyInfoList) {
        this.carDailyInfoList = carDailyInfoList;
    }

    public int getPriceEtSumFV() {
        return priceEtSumFV;
    }

    public void setPriceEtSumFV(int priceEtSumFV) {
        this.priceEtSumFV = priceEtSumFV;
    }

    public int getDayActNo() {
        return dayActNo;
    }

    public void setDayActNo(int dayActNo) {
        this.dayActNo = dayActNo;
    }

    public int getPriceSubDF_2() {
        return priceSubDF_2;
    }

    public void setPriceSubDF_2(int priceSubDF_2) {
        this.priceSubDF_2 = priceSubDF_2;
    }

    public int getPriceIncomeFV() {
        return priceIncomeFV;
    }

    public void setPriceIncomeFV(int priceIncomeFV) {
        this.priceIncomeFV = priceIncomeFV;
    }

    public int getPriceIncomeEstimateFV() {
        return priceIncomeEstimateFV;
    }

    public void setPriceIncomeEstimateFV(int priceIncomeEstimateFV) {
        this.priceIncomeEstimateFV = priceIncomeEstimateFV;
    }

    public Calender getCalender() {
        return calender;
    }

    public void setCalender(Calender calender) {
        this.calender = calender;
    }

    protected CarInvoice(Parcel in) {
        halfPathNO = in.readInt();
        timeMinInLine = in.readInt();
        kmInLineFV = in.readInt();
        fuelValue = in.readInt();
        countEtPass = in.readInt();
        priceEtPass = in.readInt();
        etCardNo = in.readInt();
        carDailyInfoList = in.createTypedArrayList(CarDailyInfoList.CREATOR);
        priceEtSumFV = in.readInt();
        dayActNo = in.readInt();
        priceSubDF_2 = in.readInt();
        priceIncomeFV = in.readInt();
        priceIncomeEstimateFV = in.readInt();
        calender = in.readParcelable(Calender.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(halfPathNO);
        dest.writeInt(timeMinInLine);
        dest.writeInt(kmInLineFV);
        dest.writeInt(fuelValue);
        dest.writeInt(countEtPass);
        dest.writeInt(priceEtPass);
        dest.writeInt(etCardNo);
        dest.writeTypedList(carDailyInfoList);
        dest.writeInt(priceEtSumFV);
        dest.writeInt(dayActNo);
        dest.writeInt(priceSubDF_2);
        dest.writeInt(priceIncomeFV);
        dest.writeInt(priceIncomeEstimateFV);
        dest.writeParcelable(calender, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CarInvoice> CREATOR = new Creator<CarInvoice>() {
        @Override
        public CarInvoice createFromParcel(Parcel in) {
            return new CarInvoice(in);
        }

        @Override
        public CarInvoice[] newArray(int size) {
            return new CarInvoice[size];
        }
    };
}
