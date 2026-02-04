package com.eventmanagement.exception;

import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EventNotFoundException.class)
    public String handle(EventNotFoundException ex) {
        return ex.getMessage();
    }
}

