package com.example.simpleappwithmvvm.viewmodel;

import android.os.Bundle;
import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.navigation.Navigation;

import com.example.simpleappwithmvvm.R;
import com.example.simpleappwithmvvm.model.Movie;
import com.example.simpleappwithmvvm.model.Trend;
import com.example.simpleappwithmvvm.repository.MovieRepository;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {

    private final MovieRepository movieRepository;
    private MutableLiveData<List<Movie>> popularLiveData;
    private MutableLiveData<List<Movie>> upcomingLiveData;
    private MutableLiveData<List<Movie>> topRatedLiveData;
    private MutableLiveData<List<Trend>> trendLiveData;


    public MainViewModel() {
        movieRepository = new MovieRepository();
    }

    public LiveData<List<Movie>> getPopularMovies() {
        if (popularLiveData == null) {
            popularLiveData = movieRepository.requestPopularMovies();
        }
        return popularLiveData;
    }

    public LiveData<List<Trend>> getTrending() {
        if (trendLiveData == null) {
            trendLiveData = movieRepository.requestTrending();
        }
        return trendLiveData;
    }

    public LiveData<List<Movie>> getUpcomingMovies() {
        if (upcomingLiveData == null) {
            upcomingLiveData = movieRepository.requestUpcomingMovies();
        }
        return upcomingLiveData;
    }

    public LiveData<List<Movie>> getTopRatedMovies() {
        if (topRatedLiveData == null) {
            topRatedLiveData = movieRepository.requestTopRatedMovies();
        }
        return topRatedLiveData;
    }

    public void searchButtonOnClick(View view) {
        Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_searchFragment);
    }

    public void trendingItemOnClick(@NotNull Trend trend, View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("id", trend.getId());
        bundle.putString("mediaType", trend.getMediaType());
        bundle.putStringArrayList("genreTitleList", genreTitlesList(trend.getGenreIdList()));
        Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_detailFragment, bundle);
    }

    public void standardItemOnClick(@NotNull Movie movie, View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("id", movie.getId());
        bundle.putString("mediaType", "movie");
        bundle.putStringArrayList("genreTitleList", genreTitlesList(movie.getGenreIdList()));
        Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_detailFragment, bundle);
    }

    public ArrayList<String> genreTitlesList(@NotNull ArrayList<Integer> genresIdList) {
        ArrayList<String> genreTitlesList = new ArrayList<>();

        for (int genreID : genresIdList) {
            switch (genreID) {
                case 28:
                    genreTitlesList.add("Action");
                    break;
                case 12:
                    genreTitlesList.add("Adventure");
                    break;
                case 16:
                    genreTitlesList.add("Animation");
                    break;
                case 35:
                    genreTitlesList.add("Comedy");
                    break;
                case 80:
                    genreTitlesList.add("Crime");
                    break;
                case 99:
                    genreTitlesList.add("Documentary");
                    break;
                case 18:
                    genreTitlesList.add("Drama");
                    break;
                case 10751:
                    genreTitlesList.add("Family");
                    break;
                case 14:
                    genreTitlesList.add("Fantasy");
                    break;
                case 36:
                    genreTitlesList.add("History");
                    break;
                case 27:
                    genreTitlesList.add("Horror");
                    break;
                case 10402:
                    genreTitlesList.add("Music");
                    break;
                case 9648:
                    genreTitlesList.add("Mystery");
                    break;
                case 10749:
                    genreTitlesList.add("Romance");
                    break;
                case 878:
                    genreTitlesList.add("Science Fiction");
                    break;
                case 10770:
                    genreTitlesList.add("TV Movie");
                    break;
                case 53:
                    genreTitlesList.add("Thriller");
                    break;
                case 10752:
                    genreTitlesList.add("War");
                    break;
                case 37:
                    genreTitlesList.add("Western");
                    break;
            }
        }

        return genreTitlesList;
    }

}