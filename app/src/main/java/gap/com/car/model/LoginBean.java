package gap.com.car.model;

import android.os.Parcel;
import android.os.Parcelable;

public class LoginBean implements Parcelable {

    private long driverId;
    private boolean alreadyRegistered;
    private String companyName;
    private String username;
    private String password;

    public boolean getAlreadyRegistered() {
        return alreadyRegistered;
    }

    public void setAlreadyRegistered(boolean alreadyRegistered) {
        this.alreadyRegistered = alreadyRegistered;
    }

    public long getDriverId() {
        return driverId;
    }

    public void setDriverId(long driverId) {
        this.driverId = driverId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    protected LoginBean(Parcel in) {
        driverId = in.readLong();
        alreadyRegistered = in.readByte() != 0;
        companyName = in.readString();
        username = in.readString();
        password = in.readString();
    }

    public static final Creator<LoginBean> CREATOR = new Creator<LoginBean>() {
        @Override
        public LoginBean createFromParcel(Parcel in) {
            return new LoginBean(in);
        }

        @Override
        public LoginBean[] newArray(int size) {
            return new LoginBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(driverId);
        parcel.writeByte((byte) (alreadyRegistered ? 1 : 0));
        parcel.writeString(companyName);
        parcel.writeString(username);
        parcel.writeString(password);
    }
}
