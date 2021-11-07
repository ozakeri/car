package gap.com.car.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by mahdi on 2/26/17.
 */

public class SendCommentResponseBean implements Parcelable {

    private String SUCCESS;
    private CommentResultBean RESULT;

    public SendCommentResponseBean(String SUCCESS, CommentResultBean RESULT) {
        this.SUCCESS = SUCCESS;
        this.RESULT = RESULT;
    }

    public String getSUCCESS() {
        return SUCCESS;
    }

    public CommentResultBean getRESULT() {
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

    protected SendCommentResponseBean(Parcel in) {
        this.SUCCESS = in.readString();
        this.RESULT = in.readParcelable(CommentResultBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<SendCommentResponseBean> CREATOR = new Parcelable.Creator<SendCommentResponseBean>() {
        @Override
        public SendCommentResponseBean createFromParcel(Parcel source) {
            return new SendCommentResponseBean(source);
        }

        @Override
        public SendCommentResponseBean[] newArray(int size) {
            return new SendCommentResponseBean[size];
        }
    };
}
