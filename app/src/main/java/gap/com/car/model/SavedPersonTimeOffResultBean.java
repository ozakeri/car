package gap.com.car.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by GapCom on 08/08/2018.
 */

public class SavedPersonTimeOffResultBean implements Parcelable {

    private String SUCCESS;
    private SavedPersonTimeOff savedPersonTimeOff;

    public String getSUCCESS() {
        return SUCCESS;
    }

    public void setSUCCESS(String SUCCESS) {
        this.SUCCESS = SUCCESS;
    }

    public SavedPersonTimeOff getSavedPersonTimeOff() {
        return savedPersonTimeOff;
    }

    public void setSavedPersonTimeOff(SavedPersonTimeOff savedPersonTimeOff) {
        this.savedPersonTimeOff = savedPersonTimeOff;
    }

    protected SavedPersonTimeOffResultBean(Parcel in) {
        SUCCESS = in.readString();
        savedPersonTimeOff = in.readParcelable(SavedPersonTimeOff.class.getClassLoader());
    }

    public static final Creator<SavedPersonTimeOffResultBean> CREATOR = new Creator<SavedPersonTimeOffResultBean>() {
        @Override
        public SavedPersonTimeOffResultBean createFromParcel(Parcel in) {
            return new SavedPersonTimeOffResultBean(in);
        }

        @Override
        public SavedPersonTimeOffResultBean[] newArray(int size) {
            return new SavedPersonTimeOffResultBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(SUCCESS);
        dest.writeParcelable(savedPersonTimeOff, flags);
    }
}
