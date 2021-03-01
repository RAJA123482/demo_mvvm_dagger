package com.demo_mvvm_dagger.movies;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.demo_mvvm_dagger.BaseApplication;
import com.demo_mvvm_dagger.R;
import com.demo_mvvm_dagger.adapter.PopularMoviesAdapter;
import com.demo_mvvm_dagger.models.MovieDetails;
import com.demo_mvvm_dagger.models.PopularMoviesModel;
import com.demo_mvvm_dagger.view_model.PopularMoviesViewModel;

import java.util.ArrayList;

import javax.inject.Inject;

public class PopularMoviesActivity extends AppCompatActivity {

    static Context context;
    Activity activity;
    SwipeRefreshLayout srlMovies;
    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private PopularMoviesViewModel popularMoviesViewModel;
    private RecyclerView rcvMovies;
    private GridLayoutManager gridLayoutManager;

    private LinearLayout frameEmpty;
    ArrayList<MovieDetails> alMoviewDetails;

    @Inject
    PopularMoviesAdapter moviesAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular_movies);
        setTitle("Popular Movies");
        context = this;
        activity = this;

        ((BaseApplication) getApplication()).getAppComponent().inject(this);

        alMoviewDetails = new ArrayList<>();

        frameEmpty = (LinearLayout) findViewById(R.id.frame_empty);
        rcvMovies = (RecyclerView) findViewById(R.id.rcv_movies);
        srlMovies = (SwipeRefreshLayout) findViewById(R.id.srl_movies);

        gridLayoutManager = new GridLayoutManager(this, 2);
        rcvMovies.setLayoutManager(gridLayoutManager);
        rcvMovies.setAdapter(moviesAdapter);

        if(alMoviewDetails.size() == 0) {
            srlMovies.setRefreshing(true);
            popularMoviesViewModel = ViewModelProviders.of(this, viewModelFactory).get(PopularMoviesViewModel.class);
        }

            popularMoviesViewModel.getModelMutableLiveData().observe(this, new Observer<PopularMoviesModel>() {
                @Override
                public void onChanged(PopularMoviesModel popularMoviesModel) {

                    srlMovies.setRefreshing(false);
                    if(alMoviewDetails.size()<=0) {
                        if(popularMoviesModel.getResults().size() > 0) {
                            alMoviewDetails.clear();
                            alMoviewDetails.addAll(popularMoviesModel.getResults());
                            frameEmpty.setVisibility(View.GONE);
                            rcvMovies.setVisibility(View.VISIBLE);
                            moviesAdapter.setData(alMoviewDetails);
                        } else {
                            rcvMovies.setVisibility(View.GONE);
                            frameEmpty.setVisibility(View.VISIBLE);
                        }
                    }
                }
            });
    }
}
