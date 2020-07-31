package com.twu.biblioteca.repositories;

import com.twu.biblioteca.entities.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private static List<Book> bookList = new ArrayList<>();

    public BookRepository() {
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void addBookToList(Book book) {
        bookList.add(book);
    }
}
