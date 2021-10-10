package com.example.simpleappwithmvvm.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simpleappwithmvvm.R;
import com.example.simpleappwithmvvm.databinding.ItemGenreBinding;
import com.example.simpleappwithmvvm.databinding.ItemStandardMovieBinding;
import com.example.simpleappwithmvvm.model.Movie;
import com.example.simpleappwithmvvm.model.Trend;
import com.example.simpleappwithmvvm.viewmodel.MainViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class GenreMoviesAdapter extends RecyclerView.Adapter<GenreMoviesAdapter.ViewHolder> {

    private ArrayList<String> genreList;

    public GenreMoviesAdapter() {
        genreList = new ArrayList<>();
    }

    public void addMovieList(ArrayList<String> genreIdsList) {
        this.genreList = genreIdsList;
    }

    @NonNull
    @NotNull
    @Override
    public GenreMoviesAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        ItemGenreBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_genre, parent, false);


        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull GenreMoviesAdapter.ViewHolder holder, int position) {
        String genreTitle = genreList.get(position);
        holder.binding.setTitle(genreTitle);
    }


    @Override
    public int getItemCount() {
        if (genreList != null) {
            return genreList.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ItemGenreBinding binding;

        public ViewHolder(@NonNull @NotNull ItemGenreBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


}
