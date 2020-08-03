package com.twu.biblioteca;

import com.twu.biblioteca.entities.Book;
import com.twu.biblioteca.repositories.BookRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class BibliotecaAppTest {
    private ByteArrayOutputStream testOut = new ByteArrayOutputStream();

    @Mock
    private BookRepository bookRepository;
    private List<Book> mockBooks = new ArrayList<>();
    private Book mockBook = new Book("book1", "authorA", Year.of(1995));

    @Before
    public void setUpOutput() {
        System.setOut(new PrintStream(testOut));
    }

    @After
    public void restoreSystemInputOutput() {
        System.setOut(System.out);
    }

    @Before
    public void addBooks() {
        mockBooks.add(mockBook);
        Mockito.when(bookRepository.getBookList()).thenReturn(mockBooks);
    }

    @Test
    public void give_welcome_message_when_start_the_application() {
        BibliotecaApp.printWelcomeMessage();
        assertEquals(testOut.toString(), "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n");
    }

    @Test
    public void give_booklist_after_the_welcome_message_appears() {
        BibliotecaApp.displayBookList();
        assertThat(testOut.toString(), containsString(bookRepository.getBookList().get(0).toString()));
    }

    @Test
    public void should_return_booklist_when_select_list_of_book() {
        String input = "1 q";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        BibliotecaApp.menu(new Scanner(System.in));
        assertThat(testOut.toString(), containsString(bookRepository.getBookList().get(0).toString()));
    }

    @Test
    public void should_throw_wrong_message_when_select_wrong() {
        String input = "5 q";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        BibliotecaApp.menu(new Scanner(System.in));
        assertThat(testOut.toString(), containsString("Please select a valid option!"));
    }

    @Test
    public void should_quit_the_app_when_select_quit() {
        String input = "q";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        BibliotecaApp.menu(new Scanner(System.in));
        assertThat(testOut.toString(), containsString("Biblioteca quit!"));
    }

    @Test
    public void should_check_out_books_when_select_available_book() {
        String input = "book1";
        BibliotecaApp.checkOutBook(input);
        assertEquals(testOut.toString(),"Thank you! Enjoy the book\n");
    }

    @Test
    public void should_check_out_books_when_select_unavailable_book() {
        String input = "book4";
        BibliotecaApp.checkOutBook(input);
        assertEquals(testOut.toString(), "Sorry, that book is not available\n");
    }

    @Test
    public void should_return_books_when_select__book() {
        String checkOutInput = "book1";
        BibliotecaApp.checkOutBook(checkOutInput);
        String returnInput = "book1";
        BibliotecaApp.returnBook(returnInput);
        assertThat(testOut.toString(), containsString("true"));
    }
}
