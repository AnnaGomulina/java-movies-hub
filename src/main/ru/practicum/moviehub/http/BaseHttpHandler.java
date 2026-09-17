package ru.practicum.moviehub.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

abstract class BaseHttpHandler implements HttpHandler {
    protected static final String CT_JSON = "application/json; charset=UTF-8"; // !!! Укажите содержимое заголовка Content-Type

    protected void sendJson(HttpExchange httpExchange, int status, String json) throws IOException {

        httpExchange.getResponseHeaders().set("Content-Type", CT_JSON);
        byte[] bytes = json.getBytes(StandardCharsets.UTF_8);
        httpExchange.sendResponseHeaders(status, bytes.length);
        try (OutputStream outputStream = httpExchange.getResponseBody()) {
            outputStream.write(bytes);
        }
    }

    protected void sendNoContent(HttpExchange httpExchange) throws java.io.IOException {
        httpExchange.getResponseHeaders().set("Content-Type", CT_JSON);
        httpExchange.sendResponseHeaders(204, -1);
        httpExchange.close();
    }
}