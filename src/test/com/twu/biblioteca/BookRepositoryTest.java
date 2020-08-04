package com.twu.biblioteca;

import com.twu.biblioteca.entities.Book;
import com.twu.biblioteca.repositories.BookRepository;
import org.junit.Before;
import org.junit.Test;

import java.time.Year;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BookRepositoryTest {
    private BookRepository bookRepository = new BookRepository();
    private Book testBook = new Book("book1", "authorA",  Year.of(1995));

    @Before
    public void addBook() {
        bookRepository.addBookToList(testBook);
    }

    @Test
    public void should_have_book_in_the_booklist_after_add_book() {
        assertTrue(bookRepository.getBookList().contains(testBook));
    }

    @Test
    public void should_checkout_book_when_customers_choose_available_book() {
        bookRepository.checkOutBook("book1", "user-001");
        assertFalse(bookRepository.getBookList().contains(testBook));
        assertTrue(bookRepository.getCheckedOutBooks().contains(testBook));
    }

    @Test
    public void should_checkout_book_when_customers_choose_unavailable_book() {
        assertFalse(bookRepository.checkOutBook("book4", "user-001"));
    }

    @Test
    public void should_return_book_when_customers_return_right_book() {
        bookRepository.checkOutBook("book1", "user-001");
        assertFalse(bookRepository.getBookList().contains(testBook));
        bookRepository.returnBook("book1");
        assertTrue(bookRepository.getBookList().contains(testBook));
        assertFalse(bookRepository.getCheckedOutBooks().contains(testBook));
    }

    @Test
    public void should_return_book_when_customers_return_wrong_book() {
        assertFalse(bookRepository.returnBook("book4"));
    }
}
