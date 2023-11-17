package com.workintech.Libraryapp.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<LibraryErrorResponse> handleException(LibraryException libraryException){
        LibraryErrorResponse libraryErrorResponse = new LibraryErrorResponse(
                libraryException.getHttpStatus().value(),libraryException.getMessage(), LocalDateTime.now()
        );
        return new ResponseEntity<>(libraryErrorResponse,libraryException.getHttpStatus());
    }


    @ExceptionHandler
    public ResponseEntity<LibraryErrorResponse> handleException(Exception exception) {
        LibraryErrorResponse plantErrorResponse = new LibraryErrorResponse(
                HttpStatus.BAD_REQUEST.value(), exception.getMessage(), LocalDateTime.now()
        );
        log.error("EXCEPTION OCCURED: " + exception.getMessage());
        return new ResponseEntity<>(plantErrorResponse, HttpStatus.BAD_REQUEST);
    }

}
