package com.twu.biblioteca;

import com.twu.biblioteca.entities.Book;
import com.twu.biblioteca.entities.Movie;
import com.twu.biblioteca.repositories.BookRepository;
import com.twu.biblioteca.repositories.MovieRepository;
import com.twu.biblioteca.userinterface.UserInterface;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class UserInterfaceTest {
    private ByteArrayOutputStream testOut = new ByteArrayOutputStream();

    @Mock
    private BookRepository bookRepository;

    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private UserInterface userInterface;

    private List<Book> mockBooks = new ArrayList<>();
    private Book mockBook = new Book("book1", "authorA", Year.of(1995));


    private List<Movie> mockMovies = new ArrayList<>();
    private Movie mockMovie = new Movie("movie1", Year.of(1995), "directorA", "5");

    @Before
    public void setUpOutput() {
        System.setOut(new PrintStream(testOut));
    }

    @Before
    public void addBooks() {
        mockBooks.add(mockBook);
        Mockito.when(bookRepository.getBookList()).thenReturn(mockBooks);
    }

    @Before
    public void addMovies() {
        mockMovies.add(mockMovie);
        Mockito.when(movieRepository.getMoviesList()).thenReturn(mockMovies);
    }

    @After
    public void restoreSystemInputOutput() {
        System.setOut(System.out);
    }

    @Test
    public void give_welcome_message_when_start_the_application() {
        userInterface.printWelcomeMessage();
        assertEquals(testOut.toString(), "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n");
    }

    @Test
    public void should_return_booklist_when_select_list_of_book() {
        userInterface.displayBookList();
        assertThat(testOut.toString(), containsString(bookRepository.getBookList().get(0).toString()));
    }

    @Test
    public void should_return_movielist_when_select_list_of_movie() {
        userInterface.displayMovieList();
        assertThat(testOut.toString(), containsString(movieRepository.getMoviesList().get(0).toString()));
    }

    /*@Test
    public void should_return_booklist_when_select_list_of_book() {
        String input = "1 q";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner mockScanner = new Scanner(System.in);
        UserInterface userInterface = new UserInterface(bookRepository, movieRepository, mockScanner);
        userInterface.menu();
        assertThat(testOut.toString(), containsString(bookRepository.getBookList().get(0).toString()));
    }

    @Test
    public void should_return_movielist_when_select_list_of_book() {
        String input = "4 q";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner mockScanner = new Scanner(System.in);
        UserInterface userInterface = new UserInterface(bookRepository, movieRepository, mockScanner);
        userInterface.menu();
        assertThat(testOut.toString(), containsString(movieRepository.getMoviesList().get(0).toString()));
    }*/

    @Test
    public void should_throw_wrong_message_when_select_wrong() {
        String input = "10 q";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner mockScanner = new Scanner(System.in);
        UserInterface userInterface = new UserInterface(bookRepository, movieRepository, mockScanner);
        userInterface.menu();
        assertThat(testOut.toString(), containsString("Please select a valid option!"));
    }

    @Test
    public void should_quit_the_app_when_select_quit() {
        String input = "q";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner mockScanner = new Scanner(System.in);
        UserInterface userInterface = new UserInterface(bookRepository, movieRepository, mockScanner);
        userInterface.menu();
        assertThat(testOut.toString(), containsString("Biblioteca quit!"));
    }

    @Test
    public void should_check_out_books_when_select_available_book() {
        String input = "book1";
        userInterface.checkOutBook(input);
        Mockito.verify(bookRepository, times(1)).checkOutBook("book1");
        //assertFalse(bookRepository.getBookList().contains(mockBook));
        //assertTrue(bookRepository.getCheckedOutBooks().contains(mockBook));
    }

    @Test
    public void should_not_check_out_books_when_select_unavailable_book() {
        String input = "book4";
        userInterface.checkOutBook(input);
        Mockito.verify(bookRepository, times(1)).checkOutBook("book4");
        //assertFalse(bookRepository.getCheckedOutBooks().contains(mockBook));
        //assertTrue(bookRepository.getBookList().contains(mockBook));
    }

    @Test
    public void should_check_out_movies_when_select_available_book() {
        String input = "movie1";
        userInterface.checkOutMovie(input);
        Mockito.verify(movieRepository, times(1)).checkOutMovie("movie1");
    }

    @Test
    public void should_check_out_movies_when_select_unavailable_book() {
        String input = "movie4";
        userInterface.checkOutMovie(input);
        Mockito.verify(movieRepository, times(1)).checkOutMovie("movie4");
    }

    @Test
    public void should_return_books_when_return_right_book() {
        String checkOutInput = "book1";
        userInterface.checkOutBook(checkOutInput);
        String returnInput = "book1";
        userInterface.returnBook(returnInput);
        Mockito.verify(bookRepository, times(1)).returnBook("book1");
        //assertTrue(bookRepository.getBookList().contains(mockBook));
        //assertFalse(bookRepository.getCheckedOutBooks().contains(mockBook));
    }

    @Test
    public void should_not_return_books_when_return_wrong_book() {
        String checkOutInput = "book1";
        userInterface.checkOutBook(checkOutInput);
        String returnInput = "book4";
        userInterface.returnBook(returnInput);
        Mockito.verify(bookRepository, times(1)).returnBook("book4");
        //assertThat(testOut.toString(), containsString("That is not a valid book to return."));
    }
}
