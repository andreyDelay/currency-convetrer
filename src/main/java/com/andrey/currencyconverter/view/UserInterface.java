package com.andrey.currencyconverter.view;

import com.andrey.currencyconverter.model.dto.CurrencyDto;

public interface UserInterface {

    void showGreeting();
    String requestAmountOfRubles();
    String requestTargetCurrencyType();
    void showErrorMessage(String message);

    void printOperationResult(CurrencyDto result);
}
