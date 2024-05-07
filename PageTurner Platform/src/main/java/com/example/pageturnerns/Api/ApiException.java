package com.example.pageturnerns.Api;

public class ApiException extends RuntimeException{
    public ApiException (String message){
        super(message);
    }
}
