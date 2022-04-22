package com.andrey.currencyconverter.utils;

import com.andrey.currencyconverter.exceptions.CurrencyCodeNotFoundException;
import com.andrey.currencyconverter.exceptions.InputCurrencyBalanceException;
import com.andrey.currencyconverter.model.CurrencyType;

public class Utils {

    public static void validateParameters(String amountOfRubles, String targetCurrencyCode)
                                                            throws InputCurrencyBalanceException,
                                                            CurrencyCodeNotFoundException {
        validateAmountOfCurrency(amountOfRubles);
        validateCurrencyCode(targetCurrencyCode);
    }

    private static void validateAmountOfCurrency(String amountOfCurrency) throws InputCurrencyBalanceException {
        double result;
        try {
            result = Double.parseDouble(amountOfCurrency);
            if (result <= 0) {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new InputCurrencyBalanceException(e.getMessage());
        }
    }

    private static void validateCurrencyCode(String targetCurrencyCode) throws CurrencyCodeNotFoundException {
        try {
            CurrencyType.valueOf(targetCurrencyCode);
        } catch (Exception e) {
            throw new CurrencyCodeNotFoundException(e.getMessage());
        }
    }
}
