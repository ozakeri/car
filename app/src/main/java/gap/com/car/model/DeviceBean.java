package gap.com.car.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by mahdi on 2/21/17.
 */

public class DeviceBean implements Parcelable {

    private String imei;
    private String macAddress;
    private String deviceName;
    private String osName;
    private String osVersion;

    public DeviceBean(String imei, String macAddress, String deviceName, String osName, String osVersion) {
        this.imei = imei;
        this.macAddress = macAddress;
        this.deviceName = deviceName;
        this.osName = osName;
        this.osVersion = osVersion;
    }

    public String getImei() {
        return imei;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public String getOsName() {
        return osName;
    }

    public String getOsVersion() {
        return osVersion;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.imei);
        dest.writeString(this.macAddress);
        dest.writeString(this.deviceName);
        dest.writeString(this.osName);
        dest.writeString(this.osVersion);
    }

    protected DeviceBean(Parcel in) {
        this.imei = in.readString();
        this.macAddress = in.readString();
        this.deviceName = in.readString();
        this.osName = in.readString();
        this.osVersion = in.readString();
    }

    public static final Parcelable.Creator<DeviceBean> CREATOR = new Parcelable.Creator<DeviceBean>() {
        @Override
        public DeviceBean createFromParcel(Parcel source) {
            return new DeviceBean(source);
        }

        @Override
        public DeviceBean[] newArray(int size) {
            return new DeviceBean[size];
        }
    };
}
