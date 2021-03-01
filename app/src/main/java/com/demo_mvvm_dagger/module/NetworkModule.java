package com.demo_mvvm_dagger.module;

import android.content.Context;

import com.demo_mvvm_dagger.AthConstants;
import com.demo_mvvm_dagger.adapter.PopularMoviesAdapter;
import com.demo_mvvm_dagger.models.MovieDetails;
import com.demo_mvvm_dagger.module.ViewModelModule;
import com.demo_mvvm_dagger.api.PopularMoviesAPI;

import java.util.ArrayList;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = ViewModelModule.class)
public abstract class NetworkModule {

    @Provides
    @Singleton
    static Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(AthConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    static PopularMoviesAPI providePopularMoviesAPI(Retrofit retrofit) {
        return retrofit.create(PopularMoviesAPI.class);
    }

    @Provides
    static PopularMoviesAdapter popularMoviesAdapter() {
        return new PopularMoviesAdapter();
    }
}
