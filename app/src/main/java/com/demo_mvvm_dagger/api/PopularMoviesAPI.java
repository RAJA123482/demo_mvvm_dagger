package com.demo_mvvm_dagger.api;

import com.demo_mvvm_dagger.models.PopularMoviesModel;

import io.reactivex.Single;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface PopularMoviesAPI {
    @POST("movie/popular")
    Single<PopularMoviesModel> getPopularMovies(@Query("api_key") String api_key);
}
