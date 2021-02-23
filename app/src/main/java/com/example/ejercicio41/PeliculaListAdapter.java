package com.example.ejercicio41;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PeliculaListAdapter  extends RecyclerView.Adapter<PeliculaListAdapter.WordViewHolder> {

    private final LayoutInflater mInflater;
    private List<Pelicula> mPeliculas;
    private ImageView mImagen;
    private TextView mTitulo;
    private TextView mAño;

    PeliculaListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new WordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        if (mPeliculas != null) {
            Pelicula current = mPeliculas.get(position);
            holder.wordItemView.setText(current.getTitulo());
        } else {
            // Covers the case of data not being ready yet.
            holder.wordItemView.setText("No Pelicula");
        }
    }

    void setPeliculas(List<Pelicula> peliculas){
        mPeliculas = peliculas;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mPeliculas != null)
            return mPeliculas.size();
        else return 0;
    }

    class WordViewHolder extends RecyclerView.ViewHolder {
        private final TextView wordItemView;

        private WordViewHolder(View itemView) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.textView_titulo);
        }
    }

    public Pelicula getPeliculaAtPosition (int position) {
        return mPeliculas.get(position);
    }
}
