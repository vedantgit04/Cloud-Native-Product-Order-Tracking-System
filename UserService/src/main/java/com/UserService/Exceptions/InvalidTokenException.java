package com.UserService.Exceptions;

public class InvalidTokenException extends  Exception{

    public InvalidTokenException(String message){
        super(message);
    }
}
