package com.example.ejercicio41;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Pelicula.class}, version = 1, exportSchema = false)
public abstract class PeliculaRoomDatabase extends RoomDatabase {
    public abstract PeliculaDAO peliculaDao();

    private static PeliculaRoomDatabase INSTANCE;

    public static PeliculaRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (PeliculaRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            PeliculaRoomDatabase.class, "pelicula_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    
                }
            };

}
