package com.example.aop.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyControllerAdvice {
    @ExceptionHandler(MaximumRequestsCountException.class)
    public String processMaximumRequestsCountException(MaximumRequestsCountException exception) {
        return "Error: " + exception.getMessage();
    }
}
