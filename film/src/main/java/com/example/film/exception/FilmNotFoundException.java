package com.example.film.exception;

public class FilmNotFoundException extends RuntimeException {
    public FilmNotFoundException(String msg) {
        super(msg);
    }
}
