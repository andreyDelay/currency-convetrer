package com.andrey.currencyconverter.view;

import com.andrey.currencyconverter.model.dto.CurrencyDto;

public interface UserInterface {

    void showGreeting();
    double requestAmountOfRubles();
    String requestTargetCurrencyType();
    void showErrorMessage(String message);
/*    CurrencyDto convert(String rublesQty, String targetCurrencyCode);*/
    void printOperationResult(CurrencyDto result);
}
