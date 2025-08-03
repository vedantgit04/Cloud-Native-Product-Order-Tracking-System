package com.example.ProductService.Exceptions;

// Exception is an inbuild class

public class InvalidProductIdException extends Exception{

    public InvalidProductIdException(String message){
        super(message);
    }
}
