package com.bjit.ecommerce.exceptions;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    // General Exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleAllExceptions(Exception ex, WebRequest request) {
        return new ResponseEntity<>("Error: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // NullPointer Exceptions
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleNullPointerException(NullPointerException ex, WebRequest request) {
        return new ResponseEntity<>("Null Pointer Exception caught: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
