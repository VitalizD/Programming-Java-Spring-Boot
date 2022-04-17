package com.example.http.handler;

import com.example.http.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyControllerAdvice {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> customException(CustomException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.valueOf(502));
    }
}
