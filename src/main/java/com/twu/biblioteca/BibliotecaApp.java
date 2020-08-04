package com.twu.biblioteca;


import com.twu.biblioteca.entities.Book;
import com.twu.biblioteca.entities.Movie;
import com.twu.biblioteca.repositories.BookRepository;
import com.twu.biblioteca.repositories.MovieRepository;
import com.twu.biblioteca.userinterface.UserInterface;

import java.time.Year;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        BookRepository bookRepository = new BookRepository();
        bookRepository.addBookToList(new Book("book1", "authorA", Year.of(1995)));
        bookRepository.addBookToList(new Book("book2", "authorB", Year.of(1991)));
        bookRepository.addBookToList(new Book("book3", "authorC", Year.of(1997)));

        MovieRepository movieRepository = new MovieRepository();
        movieRepository.addMovieToList(new Movie("movie1", Year.of(1995), "directorA", "5"));
        movieRepository.addMovieToList(new Movie("movie2", Year.of(1991), "directorB", "10"));
        movieRepository.addMovieToList(new Movie("movie3", Year.of(1997), "directorC", "unrated"));

        UserInterface userInterface = new UserInterface(bookRepository, movieRepository, new Scanner(System.in));

        userInterface.printWelcomeMessage();
        userInterface.menu();
    }

}
