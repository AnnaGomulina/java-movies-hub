package ru.practicum.moviehub.http;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import ru.practicum.moviehub.store.MoviesStore;

import java.io.IOException;


public class MoviesHandler extends BaseHttpHandler { // Расширьте базовый класс BaseHttpHandler
    MoviesStore moviesStore;

    public MoviesHandler(MoviesStore moviesStore) {
        this.moviesStore = moviesStore;
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String method = httpExchange.getRequestMethod();
        Gson gson = new Gson();
        if (method.equalsIgnoreCase("GET")) {

            sendJson(httpExchange, 200, gson.toJson(moviesStore.getAllMovies()));
        } else {
            sendNoContent(httpExchange);
        }
    }
}
