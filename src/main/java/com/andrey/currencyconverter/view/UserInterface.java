package com.andrey.currencyconverter.view;

import com.andrey.currencyconverter.dto.CurrencyDto;

public interface UserInterface {

    void showGreeting();
    double requestAmountOfRubles();
    String requestTargetCurrencyType();
    void showErrorMessage(String message);
    void printOperationResult(CurrencyDto result);
}
