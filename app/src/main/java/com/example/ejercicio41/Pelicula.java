package com.example.ejercicio41;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "pelicula_table")
public class Pelicula {

    @PrimaryKey
    @NonNull
    private String titulo;
    private String año;
    private String imagen;

    public Pelicula(String titulo, String año, String imagen){
        this.titulo=titulo;
        this.año=año;
        this.imagen=imagen;
    }


    public String getTitulo() {
        return titulo;
    }

    public String getAño() {
        return año;
    }

    public String getImagen() {
        return imagen;
    }
}


