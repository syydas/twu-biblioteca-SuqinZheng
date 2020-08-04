package com.twu.biblioteca.userinterface;

import com.twu.biblioteca.entities.Book;
import com.twu.biblioteca.repositories.BookRepository;

import java.util.Scanner;


public class UserInterface {

    private static final String BOOKLIST = "1";
    private static final String CHECKOUT = "2";
    private static final String RETURN = "3";
    private static final String QUIT = "q";

    private BookRepository bookRepository;
    private Scanner scanner;

    public UserInterface(BookRepository bookRepository, Scanner scanner) {
        this.bookRepository = bookRepository;
        this.scanner = scanner;
    }

    public void printWelcomeMessage() {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    public void displayBookList() {
        for (Book book : bookRepository.getBookList()) {
            System.out.println(book);
        }
    }

    public void menu() {
        while (true) {
            System.out.println("1. List of books\n2. Check out books\n3. return a book\nq. quit\nPlease enter your choice");
            String choice = scanner.next();
            if (QUIT.equals(choice)) {
                System.out.println("Biblioteca quit!");
                break;
            }
            handle(choice);
        }
    }

    public void handle(String choice) {
        Scanner scanner = new Scanner(System.in);
        if (BOOKLIST.equals(choice)) {
            displayBookList();
        } else if (CHECKOUT.equals(choice)) {
            System.out.println("Please enter the title of the book you would like to check out:");
            String title = scanner.next();
            checkOutBook(title);
        } else if (RETURN.equals(choice)) {
            System.out.println("Please enter the title of the book you would like to return:");
            String title = scanner.next();
            returnBook(title);
        } else {
            System.out.println("Please select a valid option!");
        }
    }

    public void checkOutBook(String title) {
        Boolean status = bookRepository.checkOutBook(title);
        System.out.println(status ? "Thank you! Enjoy the book" : "Sorry, that book is not available");
    }

    public void returnBook(String title) {
        Boolean status = bookRepository.returnBook(title);
        System.out.println(status ? "Thank you for returning the book" : "That is not a valid book to return.");
    }
}
