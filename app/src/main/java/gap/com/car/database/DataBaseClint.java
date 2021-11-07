package gap.com.car.database;

import androidx.room.Room;
import android.content.Context;

public class DataBaseClint {
    private Context context;
    private static DataBaseClint mInstance;
    private AppDataBase appDataBase;

    public DataBaseClint(Context context) {
        this.context = context;
        appDataBase = Room.databaseBuilder(context, AppDataBase.class, "driverDB").build();
    }

    public static synchronized DataBaseClint getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new DataBaseClint(context);
        }

        return mInstance;
    }

    public AppDataBase getAppDataBase() {
        return appDataBase;
    }
}
