
package gap.com.car.model.update;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReportListResponseBean implements Parcelable {

    @SerializedName("SUCCESS")
    @Expose
    private String sUCCESS;
    @SerializedName("RESULT")
    @Expose
    private RESULT rESULT;


    protected ReportListResponseBean(Parcel in) {
        sUCCESS = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(sUCCESS);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ReportListResponseBean> CREATOR = new Creator<ReportListResponseBean>() {
        @Override
        public ReportListResponseBean createFromParcel(Parcel in) {
            return new ReportListResponseBean(in);
        }

        @Override
        public ReportListResponseBean[] newArray(int size) {
            return new ReportListResponseBean[size];
        }
    };

    public String getsUCCESS() {
        return sUCCESS;
    }

    public void setsUCCESS(String sUCCESS) {
        this.sUCCESS = sUCCESS;
    }

    public RESULT getrESULT() {
        return rESULT;
    }

    public void setrESULT(RESULT rESULT) {
        this.rESULT = rESULT;
    }
}
