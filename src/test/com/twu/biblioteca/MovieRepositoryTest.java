package com.twu.biblioteca;

import com.twu.biblioteca.entities.Movie;
import com.twu.biblioteca.repositories.MovieRepository;
import org.junit.Before;
import org.junit.Test;

import java.time.Year;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MovieRepositoryTest {

    private MovieRepository movieRepository = new MovieRepository();
    private Movie testMovie = new Movie("movie1",  Year.of(1995), "directorA", "5");

    @Before
    public void addBook() {
        movieRepository.addMovieToList(testMovie);
    }

    @Test
    public void should_have_movie_in_the_list_after_add_movies() {
        assertTrue(movieRepository.getMoviesList().contains(testMovie));
    }

    @Test
    public void should_checkout_book_when_customers_choose_available_movie() {
        movieRepository.checkOutMovie("movie1");
        assertFalse(movieRepository.getMoviesList().contains(testMovie));
        assertTrue(movieRepository.getCheckedOutMovies().contains(testMovie));
    }

    @Test
    public void should_checkout_book_when_customers_choose_unavailable_book() {
        assertFalse(movieRepository.checkOutMovie("movie4"));
    }
}
