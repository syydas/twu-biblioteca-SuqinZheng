package com.twu.biblioteca;


import com.twu.biblioteca.entities.Book;
import com.twu.biblioteca.repositories.BookRepository;
import com.twu.biblioteca.userinterface.UserInterface;

import java.time.Year;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        BookRepository bookRepository = new BookRepository();
        bookRepository.addBookToList(new Book("book1", "authorA", Year.of(1995)));
        bookRepository.addBookToList(new Book("book2", "authorB", Year.of(1991)));
        bookRepository.addBookToList(new Book("book3", "authorC", Year.of(1997)));

        UserInterface userInterface = new UserInterface(bookRepository, new Scanner(System.in));

        userInterface.printWelcomeMessage();
        userInterface.menu();
    }

}
