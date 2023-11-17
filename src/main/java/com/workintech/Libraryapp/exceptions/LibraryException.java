package com.workintech.Libraryapp.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
public class LibraryException extends RuntimeException{
    private HttpStatus httpStatus;

    public LibraryException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
