package com.placementportal.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<Map<String,String>> handleStudentNotFoundException(StudentNotFoundException ex){
        Map<String,String> errorResponse=new HashMap<>();

        errorResponse.put("message", ex.getMessage());

        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CompanyNotFoundException.class)
    public ResponseEntity<Map<String,String>> handleCompanyNotFoundException(CompanyNotFoundException ex){
        Map<String,String> errorResponse = new HashMap<>();

        errorResponse.put("message",ex.getMessage());

        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }
}
