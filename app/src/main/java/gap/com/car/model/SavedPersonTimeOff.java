
package gap.com.car.model;

import android.os.Parcel;
import android.os.Parcelable;

import gap.com.car.database.entity.PersonTimeOff;

public class SavedPersonTimeOff implements Parcelable {

    private PersonTimeOff personTimeOff;


    protected SavedPersonTimeOff(Parcel in) {
    }

    public PersonTimeOff getPersonTimeOff() {
        return personTimeOff;
    }

    public void setPersonTimeOff(PersonTimeOff personTimeOff) {
        this.personTimeOff = personTimeOff;
    }

    public static final Creator<SavedPersonTimeOff> CREATOR = new Creator<SavedPersonTimeOff>() {
        @Override
        public SavedPersonTimeOff createFromParcel(Parcel in) {
            return new SavedPersonTimeOff(in);
        }

        @Override
        public SavedPersonTimeOff[] newArray(int size) {
            return new SavedPersonTimeOff[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
