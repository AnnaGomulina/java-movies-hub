package ru.practicum.moviehub.store;

import ru.practicum.moviehub.model.Movie;

import java.util.ArrayList;
import java.util.Optional;

public class MoviesStore {
    ArrayList<Movie> movies = new ArrayList<>();

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void removeMovie(Movie movie) {
        movies.remove(movie);
    }

    public Optional<Movie> searchMovie(String name) {
        return movies.stream().filter(movie -> movie.getName().equals(name)).findFirst();
    }

    public ArrayList<Movie> getAllMovies() {
        return movies;
    }

    public void clear() {
        movies.clear();
    }
}