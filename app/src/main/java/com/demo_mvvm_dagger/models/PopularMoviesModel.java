package com.demo_mvvm_dagger.models;

import java.util.ArrayList;

public class PopularMoviesModel {

    int page;
    ArrayList<MovieDetails> results;

    public PopularMoviesModel(int page, ArrayList<MovieDetails> results) {
        this.page = page;
        this.results = results;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public ArrayList<MovieDetails> getResults() {
        return results;
    }

    public void setResults(ArrayList<MovieDetails> results) {
        this.results = results;
    }

}
