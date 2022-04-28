package com.andrey.currencyconverter.validators;

import com.andrey.currencyconverter.exceptions.CurrencyCodeNotFoundException;
import com.andrey.currencyconverter.exceptions.InputCurrencyBalanceException;
import org.springframework.stereotype.Component;

@Component
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
        } catch (Exception e) {
            throw new InputCurrencyBalanceException(
                    String.format("Wrong incoming currency balance value - %s",amountOfCurrency));
        }
    }

    private void validateCurrencyCode(String targetCurrencyCode) throws CurrencyCodeNotFoundException {
        try {
            int initLength = targetCurrencyCode.length();
            int lengthAfterReplacement = targetCurrencyCode
                    .replaceAll("[^A-Za-z]", "")
                    .length();
            if (targetCurrencyCode.length() == 0 ||
                initLength != lengthAfterReplacement ||
                targetCurrencyCode.length() != 3) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new CurrencyCodeNotFoundException(
                    String.format("Wrong currency code - %s", targetCurrencyCode));
        }
    }
}
