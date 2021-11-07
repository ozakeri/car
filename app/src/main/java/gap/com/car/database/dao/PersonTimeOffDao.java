package gap.com.car.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import gap.com.car.database.entity.PersonTimeOff;

@Dao
public interface PersonTimeOffDao {

    @Query("SELECT * FROM persontimeoff")
    List<PersonTimeOff> getAll();

    @Query("SELECT * FROM persontimeoff WHERE id = :id")
    public PersonTimeOff getPersonTimeOffById(int id);

    @Insert
    void addPersonTimeOff (PersonTimeOff personTimeOff);
}
