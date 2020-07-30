package com.twu.biblioteca.repositories;

import com.twu.biblioteca.entities.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private static List<Book> bookList = new ArrayList<>();

    public static List<Book> getBookList() {
        return bookList;
    }

    public static void setBookList(List<Book> bookList) {
        BookRepository.bookList = bookList;
    }

}
