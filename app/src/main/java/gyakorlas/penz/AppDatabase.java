package gyakorlas.penz;


import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.content.Context;


@Database(entities = {Tranzakcio.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract TranzakcioDAO tranzakcioDao();

    public static AppDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context,
                    AppDatabase.class, "database-name").build();
            return INSTANCE;
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
         INSTANCE = null;
    }

}
