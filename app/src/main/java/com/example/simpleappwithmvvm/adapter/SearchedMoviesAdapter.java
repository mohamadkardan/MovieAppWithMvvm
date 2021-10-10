package com.example.simpleappwithmvvm.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simpleappwithmvvm.R;
import com.example.simpleappwithmvvm.databinding.ItemHorizontalMovieBinding;
import com.example.simpleappwithmvvm.databinding.ItemStandardMovieBinding;
import com.example.simpleappwithmvvm.model.Movie;
import com.example.simpleappwithmvvm.model.Trend;
import com.example.simpleappwithmvvm.viewmodel.MainViewModel;
import com.example.simpleappwithmvvm.viewmodel.SearchViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class SearchedMoviesAdapter extends RecyclerView.Adapter<SearchedMoviesAdapter.ViewHolder> {

    private List<Trend> trendList;

    public SearchedMoviesAdapter() {
        trendList = new ArrayList<>();
    }

    public void addMovieList(List<Trend> trendList) {
        this.trendList = trendList;
    }

    @NonNull
    @NotNull
    @Override
    public SearchedMoviesAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        ItemHorizontalMovieBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_horizontal_movie, parent, false);


        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull SearchedMoviesAdapter.ViewHolder holder, int position) {
        Trend trend = trendList.get(position);
        holder.binding.setModel(trend);
        holder.binding.setViewModel(new SearchViewModel());
    }


    @Override
    public int getItemCount() {
        if (trendList != null) {
            return trendList.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ItemHorizontalMovieBinding binding;

        public ViewHolder(@NonNull @NotNull ItemHorizontalMovieBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


}
