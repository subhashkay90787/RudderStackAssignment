package com.rudderstack.assignment.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(JsonProcessingException.class)
    public ResponseEntity<String> jsonParseExceptionError(Exception e){
        return new ResponseEntity<>("Invalid JSON object found : "+e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
