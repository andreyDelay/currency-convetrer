package com.andrey.currencyconverter.exceptions;

public class InputCurrencyDataException extends RuntimeException {
    private String message;

    public InputCurrencyDataException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
