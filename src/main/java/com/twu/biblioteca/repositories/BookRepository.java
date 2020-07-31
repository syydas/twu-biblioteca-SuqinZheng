package com.twu.biblioteca.repositories;

import com.twu.biblioteca.entities.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private static List<Book> checkedOutBooks = new ArrayList<>();
    private static List<Book> availableBooks = new ArrayList<>();

    public BookRepository() {
    }

    public List<Book> getBookList() {
        return availableBooks;
    }

    public List<Book> getCheckedOutBooks() {
        return checkedOutBooks;
    }

    public void addBookToList(Book book) {
        availableBooks.add(book);
    }

    public boolean checkOutBook(String title) {
        Book chosenBook = availableBooks.stream().filter(book -> book.getTitle().equals(title))
                .findFirst().orElse(null);
        if (chosenBook != null) {
            availableBooks.remove(chosenBook);
            checkedOutBooks.add(chosenBook);
            return true;
        } else {
            return false;
        }
    }

}
