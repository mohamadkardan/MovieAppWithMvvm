package com.example.simpleappwithmvvm.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.simpleappwithmvvm.Credentials;
import com.example.simpleappwithmvvm.model.Movie;
import com.example.simpleappwithmvvm.model.TVShow;
import com.example.simpleappwithmvvm.model.Trend;
import com.example.simpleappwithmvvm.request.Service;
import com.example.simpleappwithmvvm.response.MovieResponse;
import com.example.simpleappwithmvvm.response.SearchResponse;
import com.example.simpleappwithmvvm.response.TrendingResponse;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {

    public final MutableLiveData<List<Trend>> searchResultMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<List<Movie>> requestPopularMovies() {

        final MutableLiveData<List<Movie>> mutableLiveData = new MutableLiveData<>();
        Call<MovieResponse> call = Service.getApiService().getPopularMovies(Credentials.API_KEY, 1);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(@NotNull Call<MovieResponse> call, @NotNull Response<MovieResponse> response) {
                if (response.isSuccessful() && response.body().getMovies() != null) {
                    mutableLiveData.postValue(response.body().getMovies());
                }
            }

            @Override
            public void onFailure(@NotNull Call<MovieResponse> call, @NotNull Throwable t) {
                Log.e("onFailure", "onFailure: " + t.getMessage());
            }
        });

        return mutableLiveData;
    }

    public MutableLiveData<List<Trend>> requestTrending() {
        final MutableLiveData<List<Trend>> mutableLiveData = new MutableLiveData<>();
        Call<TrendingResponse> call = Service.getApiService().getTrendingMovies("all",
                "week", Credentials.API_KEY);
        call.enqueue(new Callback<TrendingResponse>() {
            @Override
            public void onResponse(@NotNull Call<TrendingResponse> call, @NotNull Response<TrendingResponse> response) {
                if (response.isSuccessful() && response.body().getTrends() != null) {
                    mutableLiveData.postValue(response.body().getTrends());
                }
            }

            @Override
            public void onFailure(@NotNull Call<TrendingResponse> call, @NotNull Throwable t) {
                Log.e("onFailure", "onFailure: " + t.getMessage());
            }
        });

        return mutableLiveData;
    }

    public MutableLiveData<List<Movie>> requestUpcomingMovies() {
        final MutableLiveData<List<Movie>> liveDataUpcomingMovies = new MutableLiveData<>();
        Call<MovieResponse> call = Service.getApiService().getUpcomingMovies(Credentials.API_KEY);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(@NotNull Call<MovieResponse> call, @NotNull Response<MovieResponse> response) {
                if (response.isSuccessful() && response.body().getMovies() != null) {
                    liveDataUpcomingMovies.postValue(response.body().getMovies());
                }
            }

            @Override
            public void onFailure(@NotNull Call<MovieResponse> call, @NotNull Throwable t) {
                Log.e("onFailure", "onFailure: " + t.getMessage());
            }
        });

        return liveDataUpcomingMovies;
    }

    public MutableLiveData<List<Movie>> requestTopRatedMovies() {
        final MutableLiveData<List<Movie>> mutableLiveDataTopRated = new MutableLiveData<>();
        Call<MovieResponse> call = Service.getApiService().getTopRatedMovies(Credentials.API_KEY);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(@NotNull Call<MovieResponse> call, @NotNull Response<MovieResponse> response) {
                if (response.isSuccessful() && response.body().getMovies() != null) {
                    mutableLiveDataTopRated.postValue(response.body().getMovies());
                }
            }

            @Override
            public void onFailure(@NotNull Call<MovieResponse> call, @NotNull Throwable t) {
                Log.e("onFailure", "onFailure: " + t.getMessage());
            }
        });

        return mutableLiveDataTopRated;
    }

    public MutableLiveData<TVShow> requestDetailTVShow(int tvShowID) {
        final MutableLiveData<TVShow> mutableLiveData = new MutableLiveData<>();
        Call<TVShow> call = Service.getApiService().getTVShow(tvShowID, Credentials.API_KEY);
        call.enqueue(new Callback<TVShow>() {
            @Override
            public void onResponse(@NotNull Call<TVShow> call, @NotNull Response<TVShow> response) {
                if (response.isSuccessful() && response.body() != null) {
                    mutableLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(@NotNull Call<TVShow> call, @NotNull Throwable t) {
                Log.e("onFailure", "onFailure: " + t.getMessage());
            }
        });

        return mutableLiveData;
    }

    public MutableLiveData<Movie> requestDetailMovie(int movieID) {
        final MutableLiveData<Movie> mutableLiveData = new MutableLiveData<>();
        Call<Movie> call = Service.getApiService().getMovie(movieID, Credentials.API_KEY);
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(@NotNull Call<Movie> call, @NotNull Response<Movie> response) {
                if (response.isSuccessful() && response.body() != null) {
                    mutableLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(@NotNull Call<Movie> call, @NotNull Throwable t) {
                Log.e("onFailure", "onFailure: " + t.getMessage());
            }
        });

        return mutableLiveData;
    }

    public void requestSearch(String query) {
        Call<SearchResponse> call = Service.getApiService().search(Credentials.API_KEY, query);
        call.enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(@NotNull Call<SearchResponse> call, @NotNull Response<SearchResponse> response) {
                if (response.isSuccessful() && response.body().getTrends() != null) {
                    searchResultMutableLiveData.postValue(response.body().getTrends());
                } else {
                    Log.d("OnResponse", "searchOnClick: " + "trends null");
                }
            }

            @Override
            public void onFailure(@NotNull Call<SearchResponse> call, @NotNull Throwable t) {
                Log.e("onFailure", "onFailure: " + t.getMessage());
            }
        });
    }

}
