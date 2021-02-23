package com.example.ejercicio41;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PeliculaDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Pelicula pelicula);

    @Query("DELETE FROM pelicula_table")
    void deleteAll();

    @Query("SELECT * from pelicula_table ORDER BY titulo ASC")
    LiveData<List<Pelicula>> getAllPeliculas();

    @Delete
    void deletePelicula(Pelicula pelicula);
}
