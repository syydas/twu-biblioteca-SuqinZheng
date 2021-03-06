package com.twu.biblioteca;


import com.twu.biblioteca.entities.Book;
import com.twu.biblioteca.entities.Movie;
import com.twu.biblioteca.entities.User;
import com.twu.biblioteca.repositories.BookRepository;
import com.twu.biblioteca.repositories.MovieRepository;
import com.twu.biblioteca.repositories.UserRepository;
import com.twu.biblioteca.userinteraction.UserInteraction;

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

        UserRepository userRepository = new UserRepository();
        userRepository.addUser(new User("user-001", "password1", "name1", "email1@email.com", "131XXXX"));
        userRepository.addUser(new User("user-002", "password2", "name2", "email2@email.com", "132XXXX"));
        userRepository.addUser(new User("user-003", "password3", "name3", "email3@email.com", "133XXXX"));

        UserInteraction userInteraction = new UserInteraction(bookRepository, movieRepository, userRepository, new Scanner(System.in));

        userInteraction.printWelcomeMessage();
        userInteraction.login();
    }

}
