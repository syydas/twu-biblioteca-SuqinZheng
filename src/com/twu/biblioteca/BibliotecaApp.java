package com.twu.biblioteca;


public class BibliotecaApp {

    public static void main(String[] args) {
        printWelcomeMessage();
        displayBookList();
    }

    public static void printWelcomeMessage() {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    public static void displayBookList() {
        String[] bookList = {"book1", "book2", "book3", "..."};
        for (String book : bookList) {
            System.out.println(book);
        }
    }
}
