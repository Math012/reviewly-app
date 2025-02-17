package com.math012.reviewly.reviewly_app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RequiredFieldsException.class)
    public ResponseEntity<String> handleRequiredFieldsException(RequiredFieldsException err){
        return new ResponseEntity<>(err.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> handleInvalidCredentialsException(InvalidCredentials err){
        return new ResponseEntity<>(err.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ReviewNotFoundException.class)
    public ResponseEntity<String> handleReviewNotFoundException(ReviewNotFoundException err){
        return new ResponseEntity<>(err.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
