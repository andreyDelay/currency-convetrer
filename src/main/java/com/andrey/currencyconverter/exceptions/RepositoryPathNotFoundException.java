package com.andrey.currencyconverter.exceptions;

public class RepositoryPathNotFoundException extends Exception {

    private String message;

    public RepositoryPathNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
