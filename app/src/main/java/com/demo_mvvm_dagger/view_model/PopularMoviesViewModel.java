package com.demo_mvvm_dagger.view_model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.demo_mvvm_dagger.models.PopularMoviesModel;
import com.demo_mvvm_dagger.repository.PopularMoviesRepository;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class PopularMoviesViewModel extends ViewModel {

    private PopularMoviesRepository popularMoviesRepository;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private MutableLiveData<PopularMoviesModel> modelMutableLiveData = new MutableLiveData<>();

    @Inject
    public PopularMoviesViewModel(PopularMoviesRepository popularMoviesRepository) {
        this.popularMoviesRepository = popularMoviesRepository;
    }

    public MutableLiveData<PopularMoviesModel> getModelMutableLiveData() {
        loadMovies();
        return modelMutableLiveData;
    }

    private void loadMovies() {
        compositeDisposable.add(popularMoviesRepository.moviesModelSingle().subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeWith(new DisposableSingleObserver<PopularMoviesModel>() {
            @Override
            public void onSuccess(PopularMoviesModel popularMoviesModel) {
                getModelMutableLiveData().setValue(popularMoviesModel);
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Error #999 :"+t);
            }
        }));
    }
}
