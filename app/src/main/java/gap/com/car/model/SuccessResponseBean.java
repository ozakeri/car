package gap.com.car.model;

import android.os.Parcel;
import android.os.Parcelable;



public class SuccessResponseBean implements Parcelable {

    private String SUCCESS;
    private RegisterBean RESULT;

    protected SuccessResponseBean(Parcel in) {
        SUCCESS = in.readString();
        RESULT = in.readParcelable(RegisterBean.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(SUCCESS);
        dest.writeParcelable(RESULT, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SuccessResponseBean> CREATOR = new Creator<SuccessResponseBean>() {
        @Override
        public SuccessResponseBean createFromParcel(Parcel in) {
            return new SuccessResponseBean(in);
        }

        @Override
        public SuccessResponseBean[] newArray(int size) {
            return new SuccessResponseBean[size];
        }
    };

    public String getSUCCESS() {
        return SUCCESS;
    }

    public void setSUCCESS(String SUCCESS) {
        this.SUCCESS = SUCCESS;
    }

    public RegisterBean getRESULT() {
        return RESULT;
    }

    public void setRESULT(RegisterBean RESULT) {
        this.RESULT = RESULT;
    }
}
