package ru.stepup.homework.hw5.controllers;

import lombok.Data;

@Data
public class SException extends RuntimeException{
    private String HttpMethodType;
    public SException(String errorMessage, Throwable err){
        super(errorMessage, err);
    }

}
