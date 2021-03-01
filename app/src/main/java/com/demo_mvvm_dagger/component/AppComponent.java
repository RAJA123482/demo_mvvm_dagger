package com.demo_mvvm_dagger.component;

import com.demo_mvvm_dagger.module.ContextModule;
import com.demo_mvvm_dagger.module.NetworkModule;
import com.demo_mvvm_dagger.movies.PopularMoviesActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class, ContextModule.class})
public interface AppComponent {

    void inject(PopularMoviesActivity popularMoviesActivity);
}
