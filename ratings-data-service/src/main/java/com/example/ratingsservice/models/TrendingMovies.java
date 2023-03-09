package com.example.ratingsservice.models;

import java.util.List;

public class TrendingMovies {
    List<MovieRatingResult> movieRatings;

    public TrendingMovies() {
    }

    public TrendingMovies(List<MovieRatingResult> movieRatings) {
        this.movieRatings = movieRatings;
    }

    public List<MovieRatingResult> getMovies() {
        return movieRatings;
    }

    public void setMovies(List<MovieRatingResult> movieRatings) {
        this.movieRatings = movieRatings;
    }
}
