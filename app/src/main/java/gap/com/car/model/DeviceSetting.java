package gap.com.car.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class DeviceSetting implements Parcelable {

    private Long id;
    private String key;
    private String value;
    private Date dateLastChange;

    private transient Date beforeSyncDate;

    protected DeviceSetting(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        key = in.readString();
        value = in.readString();
    }

    public static final Creator<DeviceSetting> CREATOR = new Creator<DeviceSetting>() {
        @Override
        public DeviceSetting createFromParcel(Parcel in) {
            return new DeviceSetting(in);
        }

        @Override
        public DeviceSetting[] newArray(int size) {
            return new DeviceSetting[size];
        }
    };

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getDateLastChange() {
        return dateLastChange;
    }

    public void setDateLastChange(Date dateLastChange) {
        this.dateLastChange = dateLastChange;
    }

    public Date getBeforeSyncDate() {
        return beforeSyncDate;
    }

    public void setBeforeSyncDate(Date beforeSyncDate) {
        this.beforeSyncDate = beforeSyncDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(id);
        }
        dest.writeString(key);
        dest.writeString(value);
    }
}
