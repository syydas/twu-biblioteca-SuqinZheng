package com.twu.biblioteca.userinterface;

import com.twu.biblioteca.entities.Book;
import com.twu.biblioteca.entities.Movie;
import com.twu.biblioteca.repositories.BookRepository;
import com.twu.biblioteca.repositories.MovieRepository;
import com.twu.biblioteca.repositories.UserRepository;

import java.util.Scanner;


public class UserInterface {

    private static final String BOOKLIST = "1";
    private static final String CHECKOUTBOOK = "2";
    private static final String RETURNBOOK = "3";
    private static final String MOVIELIST = "4";
    private static final String CHECKOUTMOVIE = "5";
    private static final String VIEWOUTBOOKS = "6";
    private static final String VIEWINFO = "7";
    private static final String QUIT = "q";

    private BookRepository bookRepository;
    private MovieRepository movieRepository;
    private UserRepository userRepository;
    private Scanner scanner;
    private String currentUserId;

    public UserInterface(BookRepository bookRepository, MovieRepository movieRepository, UserRepository userRepository, Scanner scanner) {
        this.bookRepository = bookRepository;
        this.movieRepository = movieRepository;
        this.userRepository = userRepository;
        this.scanner = scanner;
    }

    public void printWelcomeMessage() {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    public void login() {
        while (true) {
            System.out.println("Please enter your library id");
            String userId = scanner.next();
            System.out.println("Please enter your password");
            String password = scanner.next();
            Boolean isLogin = userRepository.isLogin(userId, password);
            if (isLogin) {
                currentUserId = userId;
                menu();
                break;
            }
        }
    }

    public void menu() {
        while (true) {
            System.out.println("\nMEAU:\n1. List of books\n2. Check out books\n3. return a book\n" +
                    "4. List of movies\n5. Check out movies\n" +
                    "6. view check out books\n7. view information\n" +
                    "q. quit\nPlease enter your choice: ");
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
        } else if (CHECKOUTBOOK.equals(choice)) {
            System.out.println("Please enter the title of the book you would like to check out:");
            String bookTitle = scanner.next();
            checkOutBook(bookTitle, currentUserId);
        } else if (RETURNBOOK.equals(choice)) {
            System.out.println("Please enter the title of the book you would like to return:");
            String bookTitle = scanner.next();
            returnBook(bookTitle);
        } else if (MOVIELIST.equals(choice)) {
            displayMovieList();
        } else if (CHECKOUTMOVIE.equals(choice)) {
            System.out.println("Please enter the title of the movie you would like to check out:");
            String movieName = scanner.next();
            checkOutMovie(movieName);
        } else if (VIEWOUTBOOKS.equals(choice)) {
            viewCheckedOutBooks();
        } else if (VIEWINFO.equals(choice)) {
            viewUserInfo();
        } else {
            System.out.println("Please select a valid option!");
        }
    }

    public void displayBookList() {
        for (Book book : bookRepository.getBookList()) {
            System.out.println(book);
        }
    }

    public void displayMovieList() {
        for (Movie movie : movieRepository.getMoviesList()) {
            System.out.println(movie);
        }
    }

    public void checkOutBook(String title, String id) {
        Boolean status = bookRepository.checkOutBook(title, id);
        System.out.println(status ? "Thank you! Enjoy the book" : "Sorry, that book is not available");
    }

    public void checkOutMovie(String name) {
        Boolean status = movieRepository.checkOutMovie(name);
        System.out.println(status ? "Thank you! Enjoy the movie" : "Sorry, that movie is not available");
    }

    public void returnBook(String title) {
        Boolean status = bookRepository.returnBook(title);
        System.out.println(status ? "Thank you for returning the book" : "That is not a valid book to return.");
    }

    public void viewCheckedOutBooks() {
        System.out.println(bookRepository.getCheckedOutBooks());
    }

    public void viewUserInfo() {
        System.out.println(userRepository.getUserById(currentUserId));
    }
}
