package com.example.http.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdviceController {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> customException() {
        return new ResponseEntity<>("Error: my custom exception", HttpStatus.valueOf(502));
    }
}
