package com.example.aop.handler;

import com.example.aop.exception.MaximumRequestsCountException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MaximumRequestsCountExceptionHandler {
    @ExceptionHandler(MaximumRequestsCountException.class)
    public String handleMaximumRequestsCountException(MaximumRequestsCountException exception) {
        return "Error: " + exception.getMessage();
    }
}
