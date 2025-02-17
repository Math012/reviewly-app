package com.math012.reviewly.reviewly_app.exception;

public class RequiredFieldsException extends RuntimeException{
    public RequiredFieldsException(String err){
        super(err);
    }
}
