package gap.com.car.model.carinvoice;

import android.os.Parcel;
import android.os.Parcelable;

public class HalfPathInfoList implements Parcelable {

    private String pathType_text;
    private String dispatchTypeEn_text;
    private String lineCode;
    private String startTime;
    private String endTime;
    private String planingDate;

    public String getPathType_text() {
        return pathType_text;
    }

    public void setPathType_text(String pathType_text) {
        this.pathType_text = pathType_text;
    }

    public String getDispatchTypeEn_text() {
        return dispatchTypeEn_text;
    }

    public void setDispatchTypeEn_text(String dispatchTypeEn_text) {
        this.dispatchTypeEn_text = dispatchTypeEn_text;
    }

    public String getLineCode() {
        return lineCode;
    }

    public void setLineCode(String lineCode) {
        this.lineCode = lineCode;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getPlaningDate() {
        return planingDate;
    }

    public void setPlaningDate(String planingDate) {
        this.planingDate = planingDate;
    }

    protected HalfPathInfoList(Parcel in) {
        pathType_text = in.readString();
        dispatchTypeEn_text = in.readString();
        lineCode = in.readString();
        startTime = in.readString();
        endTime = in.readString();
        planingDate = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(pathType_text);
        dest.writeString(dispatchTypeEn_text);
        dest.writeString(lineCode);
        dest.writeString(startTime);
        dest.writeString(endTime);
        dest.writeString(planingDate);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<HalfPathInfoList> CREATOR = new Creator<HalfPathInfoList>() {
        @Override
        public HalfPathInfoList createFromParcel(Parcel in) {
            return new HalfPathInfoList(in);
        }

        @Override
        public HalfPathInfoList[] newArray(int size) {
            return new HalfPathInfoList[size];
        }
    };
}
