package com.demo_mvvm_dagger.repository;

import com.demo_mvvm_dagger.AthConstants;
import com.demo_mvvm_dagger.api.PopularMoviesAPI;
import com.demo_mvvm_dagger.models.PopularMoviesModel;

import javax.inject.Inject;

import io.reactivex.Single;

public class PopularMoviesRepository {

    private PopularMoviesAPI popularMoviesAPI;

    @Inject
    public PopularMoviesRepository(PopularMoviesAPI popularMoviesAPI) {
        this.popularMoviesAPI = popularMoviesAPI;
    }

    public Single<PopularMoviesModel> moviesModelSingle() {
        return popularMoviesAPI.getPopularMovies(AthConstants.API_KEY);
    }
}
