package com.placementportal.backend.exception;

public class CompanyNotFoundException extends RuntimeException{

    public CompanyNotFoundException(String message){
        super(message);
    }
}
