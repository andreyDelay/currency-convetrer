package com.andrey.currencyconverter.model.dto;

import com.andrey.currencyconverter.model.CurrencyType;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CurrencyDto {
    private Double initialAmountOfRubles;
    private CurrencyType targetCurrency;
    private Double targetCurrencyRate;
    private Double amountOfTargetCurrency;

    @Override
    public String toString() {
        return "Target information listed below:\n\n" +
                " - initial amount of RUB = " + initialAmountOfRubles + "\n" +
                " - target currency = " + targetCurrency + "\n" +
                " - target currency rate = " + targetCurrencyRate + "\n" +
                " - amount of target currency you can buy = " + amountOfTargetCurrency + "\n";
    }
}
