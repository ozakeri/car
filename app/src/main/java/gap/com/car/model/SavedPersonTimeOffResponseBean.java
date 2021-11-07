package gap.com.car.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by GapCom on 08/08/2018.
 */

public class SavedPersonTimeOffResponseBean implements Parcelable {

    private String SUCCESS;
    private SavedPersonTimeOffResultBean RESULT;

    public String getSUCCESS() {
        return SUCCESS;
    }

    public void setSUCCESS(String SUCCESS) {
        this.SUCCESS = SUCCESS;
    }

    public SavedPersonTimeOffResultBean getRESULT() {
        return RESULT;
    }

    public void setRESULT(SavedPersonTimeOffResultBean RESULT) {
        this.RESULT = RESULT;
    }

    protected SavedPersonTimeOffResponseBean(Parcel in) {
        SUCCESS = in.readString();
        RESULT = in.readParcelable(SavedPersonTimeOffResultBean.class.getClassLoader());
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

    public static final Creator<SavedPersonTimeOffResponseBean> CREATOR = new Creator<SavedPersonTimeOffResponseBean>() {
        @Override
        public SavedPersonTimeOffResponseBean createFromParcel(Parcel in) {
            return new SavedPersonTimeOffResponseBean(in);
        }

        @Override
        public SavedPersonTimeOffResponseBean[] newArray(int size) {
            return new SavedPersonTimeOffResponseBean[size];
        }
    };
}
