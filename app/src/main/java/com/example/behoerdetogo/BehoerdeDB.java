package com.example.behoerdetogo;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

@Database(entities = {User.class}, version = 1)
public abstract class BehoerdeDB extends RoomDatabase {
    public abstract UserDao userDao();

    private static volatile BehoerdeDB INSTANCE;

    public static BehoerdeDB getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (BehoerdeDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    BehoerdeDB.class, "behoerde.db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}