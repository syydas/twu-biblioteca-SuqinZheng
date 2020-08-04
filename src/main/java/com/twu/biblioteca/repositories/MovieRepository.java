package com.twu.biblioteca.repositories;

import com.twu.biblioteca.entities.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieRepository {

    private static List<Movie> availablemovies = new ArrayList<>();

    public void addMovieToList(Movie movie) {
        availablemovies.add(movie);
    }

    public List<Movie> getMoviesList() {
        return availablemovies;
    }
}
