package com.demo_mvvm_dagger.models;

public class MovieDetails {

    String title;
    String poster_path;

    public MovieDetails(String title, String poster_path) {
        this.title = title;
        this.poster_path = poster_path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

}
