package gap.com.car.model;

import android.os.Parcel;
import android.os.Parcelable;

import gap.com.car.app.CarApplication;
import gap.com.car.util.Util;

/**
 * Created by mahdi on 2/21/17.
 */

public class RequestBaseBean implements Parcelable {

    private DeviceBean device = Util.getDevice();
    private String firebaseTokenId = Util.getToken();
    private String documentUsername = "car";
    private String documentPassword = "GAP!driver@9707";
    private String version = CarApplication.getInstance().getVersionName();

    public RequestBaseBean() {
    }

    public DeviceBean getDevice() {
        return device;
    }

    public String getDocumentUsername() {
        return documentUsername;
    }

    public String getDocumentPassword() {
        return documentPassword;
    }

    public String getVersion() {
        return version;
    }

    public String getToken() {
        return firebaseTokenId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.device, flags);
        dest.writeString(this.documentUsername);
        dest.writeString(this.documentPassword);
        dest.writeString(this.version);
    }

    protected RequestBaseBean(Parcel in) {
        this.device = in.readParcelable(DeviceBean.class.getClassLoader());
        this.documentUsername = in.readString();
        this.documentPassword = in.readString();
        this.version = in.readString();
    }

    public static final Creator<RequestBaseBean> CREATOR = new Creator<RequestBaseBean>() {
        @Override
        public RequestBaseBean createFromParcel(Parcel source) {
            return new RequestBaseBean(source);
        }

        @Override
        public RequestBaseBean[] newArray(int size) {
            return new RequestBaseBean[size];
        }
    };
}
