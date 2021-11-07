package gap.com.car.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by mahdi on 2/26/17.
 */

public class TypeBean implements Parcelable {

    private String type;
    private int id;

    public TypeBean(String type, int id) {
        this.type = type;
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.type);
        dest.writeInt(this.id);
    }

    protected TypeBean(Parcel in) {
        this.type = in.readString();
        this.id = in.readInt();
    }

    public static final Parcelable.Creator<TypeBean> CREATOR = new Parcelable.Creator<TypeBean>() {
        @Override
        public TypeBean createFromParcel(Parcel source) {
            return new TypeBean(source);
        }

        @Override
        public TypeBean[] newArray(int size) {
            return new TypeBean[size];
        }
    };
}
