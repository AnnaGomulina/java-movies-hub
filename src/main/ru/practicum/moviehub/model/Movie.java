package ru.practicum.moviehub.model;

public class Movie {
    String name;
    String genre;
    double rating;

    public Movie(String name, String genre, double rating) {
        this.name = name;
        this.genre = genre;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }
}