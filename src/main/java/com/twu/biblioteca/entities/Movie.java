package com.twu.biblioteca.entities;

import java.time.Year;

public class Movie {
    private String name;
    private Year year;
    private String director;
    private String rating;

    public Movie(String name, Year year, String director, String rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "name: " + name +
                ", year: " + year +
                ", director: " + director +
                ", rating: " + rating;
    }
}
