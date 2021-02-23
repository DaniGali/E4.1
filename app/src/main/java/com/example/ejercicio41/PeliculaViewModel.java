package com.example.ejercicio41;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class PeliculaViewModel extends AndroidViewModel {

    private PeliculaRepository mRepository;
    private LiveData<List<Pelicula>> mAllPeliculas;

    public PeliculaViewModel(@NonNull Application application) {
        super(application);
        mRepository= new PeliculaRepository(application);
        mAllPeliculas= mRepository.getAllPeliculas();
    }

    LiveData<List<Pelicula>> getAllPeliculas() {
        return mAllPeliculas;
    }

    public void insert(Pelicula pelicula) {
        mRepository.insert(pelicula);
    }

    public void deleteAll() {mRepository.deleteAll();}

    public void deletePelicula(Pelicula pelicula) {mRepository.deletePelicula(pelicula);}
}
