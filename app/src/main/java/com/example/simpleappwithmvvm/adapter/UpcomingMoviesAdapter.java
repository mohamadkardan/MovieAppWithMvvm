package com.example.simpleappwithmvvm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simpleappwithmvvm.R;
import com.example.simpleappwithmvvm.databinding.ItemStandardMovieBinding;
import com.example.simpleappwithmvvm.model.Movie;
import com.example.simpleappwithmvvm.viewmodel.MainViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class UpcomingMoviesAdapter extends RecyclerView.Adapter<UpcomingMoviesAdapter.ViewHolder> {

    private List<Movie> movieList;

    public UpcomingMoviesAdapter() {
        movieList = new ArrayList<>();
    }

    public void addMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @NonNull
    @NotNull
    @Override
    public UpcomingMoviesAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        ItemStandardMovieBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_standard_movie, parent, false);


        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull UpcomingMoviesAdapter.ViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        holder.binding.setMovie(movie);
        holder.binding.setViewModel(new MainViewModel());
    }


    @Override
    public int getItemCount() {
        if (movieList != null) {
            return movieList.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ItemStandardMovieBinding binding;

        public ViewHolder(@NonNull @NotNull ItemStandardMovieBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


}
