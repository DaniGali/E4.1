package com.example.ejercicio41;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class PeliculaRepository {

    private PeliculaDAO mpeliculaDAO;
    private LiveData<List<Pelicula>> mAllPeliculas;

    PeliculaRepository(Application application) {
        PeliculaRoomDatabase db = PeliculaRoomDatabase.getDatabase(application);
        mpeliculaDAO = db.peliculaDao();
        mAllPeliculas = mpeliculaDAO.getAllPeliculas();
    }
    LiveData<List<Pelicula>> getAllPeliculas() {
        return mAllPeliculas;
    }

    public void insert (Pelicula pelicula) {
        new insertAsyncTask(mpeliculaDAO).execute(pelicula);
    }

    private static class insertAsyncTask extends AsyncTask<Pelicula, Void, Void> {

        private PeliculaDAO mAsyncTaskDao;

        insertAsyncTask(PeliculaDAO dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Pelicula... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    private static class deleteAllPeliculasAsyncTask extends AsyncTask<Void, Void, Void> {
        private PeliculaDAO mAsyncTaskDao;

        deleteAllPeliculasAsyncTask(PeliculaDAO dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mAsyncTaskDao.deleteAll();
            return null;
        }
    }

    public void deleteAll()  {
        new deleteAllPeliculasAsyncTask(mpeliculaDAO).execute();
    }

    private static class deletePeliculaAsyncTask extends AsyncTask<Pelicula, Void, Void> {
        private PeliculaDAO mAsyncTaskDao;

        deletePeliculaAsyncTask(PeliculaDAO dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Pelicula... params) {
            mAsyncTaskDao.deletePelicula(params[0]);
            return null;
        }
    }

    public void deletePelicula(Pelicula pelicula)  {
        new deletePeliculaAsyncTask(mpeliculaDAO).execute(pelicula);
    }

}
