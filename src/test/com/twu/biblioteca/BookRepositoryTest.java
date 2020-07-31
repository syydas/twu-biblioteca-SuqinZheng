package com.twu.biblioteca;

import com.twu.biblioteca.entities.Book;
import com.twu.biblioteca.repositories.BookRepository;
import org.junit.Test;

import java.time.Year;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BookRepositoryTest {
    private BookRepository bookRepository = new BookRepository();

    @Test
    public void should_checkout_book_when_customers_choose_book() {
        Book book = new Book("book1", "authorA",  Year.of(1995));
        bookRepository.addBookToList(book);
        bookRepository.checkOutBook("book1");
        assertFalse(bookRepository.getBookList().contains(book));
        assertTrue(bookRepository.getCheckedOutBooks().contains(book));
    }
}
