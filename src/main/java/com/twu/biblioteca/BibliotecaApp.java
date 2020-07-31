package com.twu.biblioteca;


import com.twu.biblioteca.entities.Book;
import com.twu.biblioteca.repositories.BookRepository;

import java.time.Year;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {
    public static BookRepository bookRepository = new BookRepository();
    private static final String BOOKLIST = "1";
    private static final List<Book> BOOKS;

    static {
        bookRepository.addBookToList(new Book("book1", "authorA", Year.of(1995)));
        bookRepository.addBookToList(new Book("book2", "authorB", Year.of(1991)));
        bookRepository.addBookToList(new Book("book3", "authorC", Year.of(1997)));
        BOOKS = bookRepository.getBookList();
    }

    public static void main(String[] args) {
        printWelcomeMessage();
        menu();
    }

    public static void printWelcomeMessage() {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    public static void displayBookList() {
        for (Book book : BOOKS) {
            System.out.println(book);
        }
    }

    public static void menu() {
        System.out.println("Enter the number you want to choose");
        System.out.println("1. List of books");
        Scanner printItem = new Scanner(System.in);
        String choice = printItem.next();
        if (BOOKLIST.equals(choice)) {
            displayBookList();
        } else {
            System.out.println("Sorry, you may have entered a wrong number, please check and enter again");
            menu();
        }
    }
}
