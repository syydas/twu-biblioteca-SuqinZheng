package com.twu.biblioteca.entities;

import java.time.Year;

public class Book {

    private String title;
    private String author;
    private Year year;

    public Book(String title, String author, Year year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "title: " + title +
                ", author: " + author +
                ", year: " + year;
    }
}
