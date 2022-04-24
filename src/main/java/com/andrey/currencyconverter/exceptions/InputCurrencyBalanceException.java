package com.andrey.currencyconverter.exceptions;

public class InputCurrencyBalanceException extends Exception {

    private String message;

    public InputCurrencyBalanceException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
