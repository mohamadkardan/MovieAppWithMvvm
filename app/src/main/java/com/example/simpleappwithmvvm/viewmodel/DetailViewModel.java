package com.example.simpleappwithmvvm.viewmodel;

import android.view.View;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.navigation.Navigation;

import com.bumptech.glide.Glide;
import com.example.simpleappwithmvvm.model.Movie;
import com.example.simpleappwithmvvm.model.TVShow;
import com.example.simpleappwithmvvm.repository.MovieRepository;
import com.makeramen.roundedimageview.RoundedImageView;

import org.jetbrains.annotations.NotNull;

public class DetailViewModel extends ViewModel {

    private final MovieRepository movieRepository;
    private MutableLiveData<TVShow> tvShowDetailLiveData;
    private MutableLiveData<Movie> movieDetailLiveData;

    public DetailViewModel() {
        movieRepository = new MovieRepository();
    }

    public LiveData<TVShow> getTvShowDetail(int tvShowID) {
        if (tvShowDetailLiveData == null) {
            tvShowDetailLiveData = movieRepository.requestDetailTVShow(tvShowID);
        }
        return tvShowDetailLiveData;
    }

    public LiveData<Movie> getMovieDetail(int movieID) {
        if (movieDetailLiveData == null) {
            movieDetailLiveData = movieRepository.requestDetailMovie(movieID);
        }
        return movieDetailLiveData;
    }

    public void backOnClick(View view) {
        Navigation.findNavController(view).popBackStack();
    }

}
