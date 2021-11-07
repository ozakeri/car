package gap.com.car.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import gap.com.car.database.dao.CommentDao;
import gap.com.car.database.dao.DriverDao;
import gap.com.car.database.dao.PersonTimeOffDao;
import gap.com.car.database.dao.ReportDao;
import gap.com.car.database.entity.CommentBean;
import gap.com.car.database.entity.Driver;
import gap.com.car.database.entity.PersonTimeOff;
import gap.com.car.database.entity.Report;

@Database(entities = {PersonTimeOff.class, Driver.class, Report.class, CommentBean.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    public abstract PersonTimeOffDao personTimeOffDao();

    public abstract DriverDao driverDao();

    public abstract ReportDao reportDao();

    public abstract CommentDao commentDao();
}
