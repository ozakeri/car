package gap.com.car.model.carinvoice;

import android.os.Parcel;
import android.os.Parcelable;

public class DailyEventList implements Parcelable {

    private Event event;
    private Line line;
    private int eventPositionEn;
    private String eventPositionEn_text;
    private String fractionWork;
    private String reasonSysParamStr;
    private String dateCreation;

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public int getEventPositionEn() {
        return eventPositionEn;
    }

    public void setEventPositionEn(int eventPositionEn) {
        this.eventPositionEn = eventPositionEn;
    }

    public String getEventPositionEn_text() {
        return eventPositionEn_text;
    }

    public void setEventPositionEn_text(String eventPositionEn_text) {
        this.eventPositionEn_text = eventPositionEn_text;
    }

    public String getFractionWork() {
        return fractionWork;
    }

    public void setFractionWork(String fractionWork) {
        this.fractionWork = fractionWork;
    }

    public String getReasonSysParamStr() {
        return reasonSysParamStr;
    }

    public void setReasonSysParamStr(String reasonSysParamStr) {
        this.reasonSysParamStr = reasonSysParamStr;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    protected DailyEventList(Parcel in) {
        event = in.readParcelable(Event.class.getClassLoader());
        line = in.readParcelable(Line.class.getClassLoader());
        eventPositionEn = in.readInt();
        eventPositionEn_text = in.readString();
        fractionWork = in.readString();
        reasonSysParamStr = in.readString();
        dateCreation = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(event, flags);
        dest.writeParcelable(line, flags);
        dest.writeInt(eventPositionEn);
        dest.writeString(eventPositionEn_text);
        dest.writeString(fractionWork);
        dest.writeString(reasonSysParamStr);
        dest.writeString(dateCreation);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DailyEventList> CREATOR = new Creator<DailyEventList>() {
        @Override
        public DailyEventList createFromParcel(Parcel in) {
            return new DailyEventList(in);
        }

        @Override
        public DailyEventList[] newArray(int size) {
            return new DailyEventList[size];
        }
    };
}
