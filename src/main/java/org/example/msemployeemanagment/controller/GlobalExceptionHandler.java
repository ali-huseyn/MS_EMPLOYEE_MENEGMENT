package org.example.msemployeemanagment.controller;

import org.example.msemployeemanagment.exception.EmployeeNotFoundException;
import org.example.msemployeemanagment.exception.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handleException(EmployeeNotFoundException ex) {

return new ExceptionResponse(ex.getMessage());
    }
}
