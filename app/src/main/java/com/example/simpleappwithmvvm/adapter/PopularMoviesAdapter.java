package com.example.simpleappwithmvvm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simpleappwithmvvm.R;
import com.example.simpleappwithmvvm.databinding.ItemCardTrendBinding;
import com.example.simpleappwithmvvm.model.Movie;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class PopularMoviesAdapter extends RecyclerView.Adapter<PopularMoviesAdapter.ViewHolder> {

    private List<Movie> movieList;
    private Context context;

    public PopularMoviesAdapter(Context context) {
        movieList = new ArrayList<>();
        this.context = context;
    }

    public void addMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @NonNull
    @NotNull
    @Override
    public PopularMoviesAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        ItemCardTrendBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_card_trend, parent, false);


        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull PopularMoviesAdapter.ViewHolder holder, int position) {
        Movie movie = movieList.get(position);
//        holder.binding.setMovie(movie);
//        holder.binding.setViewModel(new MainViewModel());
    }


    @Override
    public int getItemCount() {
        if (movieList != null) {
            return movieList.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ItemCardTrendBinding binding;

        public ViewHolder(@NonNull @NotNull ItemCardTrendBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


}
