package com.andrey.currencyconverter.validators;

import com.andrey.currencyconverter.exceptions.CurrencyCodeNotFoundException;
import com.andrey.currencyconverter.exceptions.InputCurrencyBalanceException;
import com.andrey.currencyconverter.model.CurrencyType;

public class Validator {

    public void validateParameters(String rublesQty, String targetCurrencyCode)
                                                            throws InputCurrencyBalanceException,
                                                            CurrencyCodeNotFoundException {
        validateAmountOfCurrency(rublesQty);
        validateCurrencyCode(targetCurrencyCode);
    }

    private void validateAmountOfCurrency(String amountOfCurrency) throws InputCurrencyBalanceException {
        double result;
        try {
            result = Double.parseDouble(amountOfCurrency);
            if (result <= 0) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new InputCurrencyBalanceException(e.getMessage());
        }
    }

    private void validateCurrencyCode(String targetCurrencyCode) throws CurrencyCodeNotFoundException {
        try {
            CurrencyType.valueOf(targetCurrencyCode);
        } catch (IllegalArgumentException e) {
            throw new CurrencyCodeNotFoundException(e.getMessage());
        }
    }
}
