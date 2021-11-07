package gap.com.car.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by GapCom on 08/08/2018.
 */

public class VerifyCodeResponseBean implements Parcelable {

    private String SUCCESS;
    private DriverBean RESULT;


    protected VerifyCodeResponseBean(Parcel in) {
        SUCCESS = in.readString();
        RESULT = in.readParcelable(DriverBean.class.getClassLoader());
    }

    public static final Creator<VerifyCodeResponseBean> CREATOR = new Creator<VerifyCodeResponseBean>() {
        @Override
        public VerifyCodeResponseBean createFromParcel(Parcel in) {
            return new VerifyCodeResponseBean(in);
        }

        @Override
        public VerifyCodeResponseBean[] newArray(int size) {
            return new VerifyCodeResponseBean[size];
        }
    };

    public String getSUCCESS() {
        return SUCCESS;
    }

    public void setSUCCESS(String SUCCESS) {
        this.SUCCESS = SUCCESS;
    }

    public DriverBean getRESULT() {
        return RESULT;
    }

    public void setRESULT(DriverBean RESULT) {
        this.RESULT = RESULT;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(SUCCESS);
        dest.writeParcelable(RESULT, flags);
    }
}
