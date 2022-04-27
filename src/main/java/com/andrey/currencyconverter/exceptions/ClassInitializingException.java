package com.andrey.currencyconverter.exceptions;

public class ClassInitializingException extends Exception {

    private String message;

    public ClassInitializingException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
