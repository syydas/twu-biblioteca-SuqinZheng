package com.twu.biblioteca.repositories;

import com.twu.biblioteca.entities.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private static List<Book> checkedOutBooks = new ArrayList<>();
    private static List<Book> availableBooks = new ArrayList<>();

    public void addBookToList(Book book) {
        availableBooks.add(book);
    }

    public boolean checkOutBook(String title, String id) {
        Book chosenBook = availableBooks.stream().filter(book -> book.getTitle().equals(title))
                .findFirst().orElse(null);
        if (chosenBook != null) {
            chosenBook.setUserId(id);
            availableBooks.remove(chosenBook);
            checkedOutBooks.add(chosenBook);
            return true;
        } else {
            return false;
        }
    }

    public boolean returnBook(String title) {
        Book returnBook = checkedOutBooks.stream().filter(book -> book.getTitle().equals(title))
                .findFirst().orElse(null);
        if (returnBook != null) {
            returnBook.setUserId(null);
            availableBooks.add(returnBook);
            checkedOutBooks.remove(returnBook);
            return true;
        } else {
            return false;
        }
    }

    public List<Book> getBookList() {
        return availableBooks;
    }

    public List<Book> getCheckedOutBooks() {
        return checkedOutBooks;
    }
}
