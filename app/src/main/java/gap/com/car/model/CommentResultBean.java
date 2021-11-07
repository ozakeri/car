package gap.com.car.model;

import android.os.Parcel;
import android.os.Parcelable;

import gap.com.car.database.entity.CommentBean;

/**
 * Created by mahdi on 2/26/17.
 */

public class CommentResultBean implements Parcelable {

    private CommentBean comment;

    public CommentResultBean(CommentBean comment) {
        this.comment = comment;
    }

    protected CommentResultBean(Parcel in) {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CommentResultBean> CREATOR = new Creator<CommentResultBean>() {
        @Override
        public CommentResultBean createFromParcel(Parcel in) {
            return new CommentResultBean(in);
        }

        @Override
        public CommentResultBean[] newArray(int size) {
            return new CommentResultBean[size];
        }
    };

    public CommentBean getComment() {
        return comment;
    }

}
