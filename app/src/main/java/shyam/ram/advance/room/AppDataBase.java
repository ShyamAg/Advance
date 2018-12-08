package shyam.ram.advance.room;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;

/**
 * Created by SAM on 26-Mar-18.
 */

public class AppDataBase {
    public static ApplicationDataBase applicationDataBase;

    public AppDataBase(Context context) {
    }
    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            // Create the new table
            database.execSQL(
                    "CREATE TABLE Search (text TEXT, id TEXT, dateTime TEXT, PRIMARY KEY(id))");
        }
    };
    public static ApplicationDataBase appDataBaseInstance(Context context){
        if (applicationDataBase==null) {
            applicationDataBase = Room.databaseBuilder(context, ApplicationDataBase.class, "PHP")
                    .allowMainThreadQueries()
                    .addMigrations(MIGRATION_1_2)
                    .build();
        }
        return applicationDataBase;
    }
}
