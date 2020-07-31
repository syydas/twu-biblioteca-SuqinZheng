package com.twu.biblioteca;


import com.twu.biblioteca.entities.Book;
import com.twu.biblioteca.repositories.BookRepository;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {
    public static BookRepository bookRepository = new BookRepository();

    public static void main(String[] args) {
        /*List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("book1", "authorA", Year.of(1995)));
        bookList.add(new Book("book2", "authorB", Year.of(1991)));
        bookList.add(new Book("book3", "authorC", Year.of(1997)));
        bookRepository.setBookList(bookList);*/
        printWelcomeMessage();
        //menu();
    }

    public static void printWelcomeMessage() {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    public static void displayBookList() {
        for (Book book : bookRepository.getBookList()) {
            System.out.println(book);
        }
    }

    public static void menu() {
        System.out.println("Enter the number you want to choose");
        System.out.println("1. List of books");
        Scanner printItem = new Scanner(System.in);
        String choice = printItem.next();
        if ("1".equals(choice)) {
            displayBookList();
        } else {
            System.out.println("Sorry, you may have entered a wrong number, please check and enter again");
            menu();
        }
    }
}
