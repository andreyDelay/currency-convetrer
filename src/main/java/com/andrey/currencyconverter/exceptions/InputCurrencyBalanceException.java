package com.andrey.currencyconverter.exceptions;

public class InputCurrencyBalanceException extends Throwable {
   /* INCORRECT_AMOUNT("The amount of currency should be a positive number.");*/

    private String message;

    public InputCurrencyBalanceException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
