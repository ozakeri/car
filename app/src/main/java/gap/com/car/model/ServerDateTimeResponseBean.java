package gap.com.car.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by GapCom on 08/08/2018.
 */

public class ServerDateTimeResponseBean implements Parcelable {

    private String SUCCESS;
    private ServerDateTimeBean RESULT;

    public ServerDateTimeResponseBean(String SUCCESS, ServerDateTimeBean RESULT) {
        this.SUCCESS = SUCCESS;
        this.RESULT = RESULT;
    }

    public String getSUCCESS() {
        return SUCCESS;
    }

    public ServerDateTimeBean getRESULT() {
        return RESULT;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.SUCCESS);
        dest.writeParcelable(this.RESULT, flags);
    }

    protected ServerDateTimeResponseBean(Parcel in) {
        this.SUCCESS = in.readString();
        this.RESULT = in.readParcelable(ServerDateTimeBean.class.getClassLoader());
    }

    public static final Creator<VerifyCodeResponseBean> CREATOR = new Creator<VerifyCodeResponseBean>() {
        @Override
        public VerifyCodeResponseBean createFromParcel(Parcel source) {
            return new VerifyCodeResponseBean(source);
        }

        @Override
        public VerifyCodeResponseBean[] newArray(int size) {
            return new VerifyCodeResponseBean[size];
        }
    };
}
