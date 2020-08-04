package com.twu.biblioteca.repositories;

import com.twu.biblioteca.entities.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieRepository {
    private static List<Movie> checkedOutMovies = new ArrayList<>();
    private static List<Movie> availableMovies = new ArrayList<>();

    public void addMovieToList(Movie movie) {
        availableMovies.add(movie);
    }

    public List<Movie> getMoviesList() {
        return availableMovies;
    }

    public static List<Movie> getCheckedOutMovies() {
        return checkedOutMovies;
    }

    public boolean checkOutMovie(String name) {
        Movie chosenMovie = availableMovies.stream().filter(movie -> movie.getName().equals(name))
                .findFirst().orElse(null);
        if (chosenMovie != null) {
            availableMovies.remove(chosenMovie);
            checkedOutMovies.add(chosenMovie);
            return true;
        } else {
            return false;
        }
    }
}
