package com.andrey.currencyconverter.model.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CurrencyDto {
    private double initialAmountOfRubles;
    private String targetCurrencyCode;
    private double targetCurrencyRate;
    private double convertedTargetCurrency;

    @Override
    public String toString() {
        return "Target information listed below:\n\n" +
                " - initial amount of RUB = " + initialAmountOfRubles + "\n" +
                " - target currency = " + targetCurrencyCode + "\n" +
                " - target currency rate = " + targetCurrencyRate + "\n" +
                " - amount of target currency you can buy = " + convertedTargetCurrency + "\n";
    }
}
