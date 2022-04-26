package com.andrey.currencyconverter.exceptions;

public class PropertyValueNotFoundException extends Exception {

    private String message;

    public PropertyValueNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
