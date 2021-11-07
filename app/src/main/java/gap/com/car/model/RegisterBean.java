package gap.com.car.model;

import android.os.Parcel;
import android.os.Parcelable;

public class RegisterBean implements Parcelable {

    private String mobileNo;

    protected RegisterBean(Parcel in) {
        mobileNo = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mobileNo);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<RegisterBean> CREATOR = new Creator<RegisterBean>() {
        @Override
        public RegisterBean createFromParcel(Parcel in) {
            return new RegisterBean(in);
        }

        @Override
        public RegisterBean[] newArray(int size) {
            return new RegisterBean[size];
        }
    };

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
}
