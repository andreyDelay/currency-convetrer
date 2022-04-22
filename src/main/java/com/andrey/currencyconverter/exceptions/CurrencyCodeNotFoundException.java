package com.andrey.currencyconverter.exceptions;

public class CurrencyCodeNotFoundException extends Throwable {
    private String message;

    public CurrencyCodeNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
