package gap.com.car.model;

import android.os.Parcel;
import android.os.Parcelable;

public class ServerDateTimeBean implements Parcelable {

    private String serverDateTime;

    protected ServerDateTimeBean(Parcel in) {
        serverDateTime = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(serverDateTime);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ServerDateTimeBean> CREATOR = new Creator<ServerDateTimeBean>() {
        @Override
        public ServerDateTimeBean createFromParcel(Parcel in) {
            return new ServerDateTimeBean(in);
        }

        @Override
        public ServerDateTimeBean[] newArray(int size) {
            return new ServerDateTimeBean[size];
        }
    };

    public String getServerDateTime() {
        return serverDateTime;
    }

    public void setServerDateTime(String serverDateTime) {
        this.serverDateTime = serverDateTime;
    }
}
