package com.demo_mvvm_dagger.module;

import android.content.Context;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.demo_mvvm_dagger.ViewModelKey;
import com.demo_mvvm_dagger.adapter.PopularMoviesAdapter;
import com.demo_mvvm_dagger.api.PopularMoviesAPI;
import com.demo_mvvm_dagger.models.MovieDetails;
import com.demo_mvvm_dagger.view_model.PopularMoviesViewModel;
import com.demo_mvvm_dagger.view_model.ViewModelFactory;

import java.util.ArrayList;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import retrofit2.Retrofit;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(PopularMoviesViewModel.class)
    abstract ViewModel bindViewModel(PopularMoviesViewModel popularMoviesViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindFactory(ViewModelFactory factory);
}
