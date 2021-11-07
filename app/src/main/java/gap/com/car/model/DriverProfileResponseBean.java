package gap.com.car.model;

import android.os.Parcel;
import android.os.Parcelable;

import gap.com.car.model.driverprofile.RESULTBean;

/**
 * Created by GapCom on 08/08/2018.
 */

public class DriverProfileResponseBean implements Parcelable {

    protected DriverProfileResponseBean(Parcel in) {
        SUCCESS = in.readString();
        RESULT = in.readParcelable(RESULTBean.class.getClassLoader());
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    public static final Creator<DriverProfileResponseBean> CREATOR = new Creator<DriverProfileResponseBean>() {
        @Override
        public DriverProfileResponseBean createFromParcel(Parcel in) {
            return new DriverProfileResponseBean(in);
        }

        @Override
        public DriverProfileResponseBean[] newArray(int size) {
            return new DriverProfileResponseBean[size];
        }
    };

    public String getSUCCESS() {
        return SUCCESS;
    }

    public void setSUCCESS(String SUCCESS) {
        this.SUCCESS = SUCCESS;
    }

    public RESULTBean getRESULT() {
        return RESULT;
    }

    public void setRESULT(RESULTBean RESULT) {
        this.RESULT = RESULT;
    }

    private String SUCCESS;
    private RESULTBean RESULT;
}
