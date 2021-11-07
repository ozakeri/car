package gap.com.car.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import gap.com.car.database.entity.Driver;

@Dao
public interface DriverDao {

    @Query("SELECT * FROM driver")
    List<Driver> getAll();

    @Insert
    void insertDriver(Driver driver);
}
