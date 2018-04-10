package gyakorlas.penz;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface TranzakcioDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void AddTranzakcio(Tranzakcio tranzakcio);

    @Query("select * from tranzakcio")
    public List<Tranzakcio> getAllTranzakcio();

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateTranzakcio(Tranzakcio tranzakcio);

    @Query("delete from tranzakcio")
    void removeAllTranzakcio();
}