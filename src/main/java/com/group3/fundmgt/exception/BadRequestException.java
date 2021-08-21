package com.group3.fundmgt.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.BAD_REQUEST)
public class BadRequestException extends IllegalArgumentException{
    public BadRequestException(String message){
        super(message);
    }
}
