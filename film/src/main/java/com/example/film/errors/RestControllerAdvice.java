package com.example.film.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.RestControllerAdvice
public class RestControllerAdvice {
    @ExceptionHandler({NotFoundException.class, NumberFormatException.class})
    public ResponseEntity handleNotFoundException(NotFoundException ex) {

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
