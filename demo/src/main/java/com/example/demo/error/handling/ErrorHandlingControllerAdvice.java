package com.example.demo.error.handling;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;

@ControllerAdvice
class ErrorHandlingControllerAdvice {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ArrayList<String> onConstraintValidationException(ConstraintViolationException e) {
        var response = new ArrayList<String>();
        for (ConstraintViolation violation : e.getConstraintViolations()) {
            response.add(e.getMessage());
        }
        return response;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ArrayList<String> onMethodArgumentNotValidException(MethodArgumentNotValidException e) {

        var response = new ArrayList<String>();
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            response.add(fieldError.getDefaultMessage());
        }
        return response;
    }
}