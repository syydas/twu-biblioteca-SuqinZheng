package com.twu.biblioteca;


import com.twu.biblioteca.entities.Book;
import com.twu.biblioteca.repositories.BookRepository;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        BookRepository bookRepository = new BookRepository();
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("book1", "authorA", Year.of(1995)));
        bookList.add(new Book("book2", "authorB", Year.of(1991)));
        bookList.add(new Book("book3", "authorC", Year.of(1997)));
        bookRepository.setBookList(bookList);
        printWelcomeMessage();
        displayBookList(bookRepository);
    }

    public static void printWelcomeMessage() {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    public static void displayBookList(BookRepository bookRepository) {
        for (Book book : bookRepository.getBookList()) {
            System.out.println(book);
        }
    }
}
