package com.example.simpleappwithmvvm.response;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.simpleappwithmvvm.model.Movie;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieResponse {
    @SerializedName("page")
    @Expose
    int page;
    @SerializedName("results")
    @Expose
    List<Movie> movies;


    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }


    @Override
    public String toString() {
        return "MovieResponse{" +
                "page=" + page +
                ", movies=" + movies +
                '}';
    }
}
