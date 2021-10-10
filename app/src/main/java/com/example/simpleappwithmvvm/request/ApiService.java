package com.example.simpleappwithmvvm.request;

import com.example.simpleappwithmvvm.model.Movie;
import com.example.simpleappwithmvvm.model.TVShow;
import com.example.simpleappwithmvvm.response.MovieResponse;
import com.example.simpleappwithmvvm.response.SearchResponse;
import com.example.simpleappwithmvvm.response.TrendingResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {


    @GET("3/movie/popular")
    Call<MovieResponse> getPopularMovies(@Query("api_key") String apiKey, @Query("page") int page);

    @GET("3/trending/{media_type}/{time_window}")
    Call<TrendingResponse> getTrendingMovies(@Path("media_type") String mediaType, @Path("time_window") String timeWindow,
                                             @Query("api_key") String apiKey);

    @GET("3/movie/upcoming")
    Call<MovieResponse> getUpcomingMovies(@Query("api_key") String apiKey);

    @GET("3/movie/top_rated")
    Call<MovieResponse> getTopRatedMovies(@Query("api_key") String apiKey);

    @GET("3/search/multi")
    Call<SearchResponse> search(@Query("api_key") String apiKey, @Query("query") String query);

    @GET("3/tv/{tv_id}")
    Call<TVShow> getTVShow(@Path("tv_id") Integer tvID, @Query("api_key") String apiKey);

    @GET("3/movie/{movie_id}")
    Call<Movie> getMovie(@Path("movie_id") Integer movieID, @Query("api_key") String apiKey);

}
