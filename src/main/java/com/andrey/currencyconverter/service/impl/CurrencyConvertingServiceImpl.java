package com.andrey.currencyconverter.service.impl;

import com.andrey.currencyconverter.model.CurrencyRate;
import com.andrey.currencyconverter.model.dto.CurrencyDto;
import com.andrey.currencyconverter.service.CurrencyConvertingService;

public class CurrencyConvertingServiceImpl implements CurrencyConvertingService {

    @Override
    public CurrencyDto convertCurrency(String rublesQty, CurrencyRate targetCurrencyInfo) {
        double rubles = Double.parseDouble(rublesQty);
        double convertedTargetCurrency = convertBalance(rubles, targetCurrencyInfo.getRate());

        return CurrencyDto.builder()
                .initialAmountOfRubles(rubles)
                .targetCurrency(targetCurrencyInfo.getCode())
                .targetCurrencyRate(targetCurrencyInfo.getRate() * 100)
                .amountOfTargetCurrency(convertedTargetCurrency)
                .build();
    }

    private double convertBalance(double rubs, double targetCurrencyRate) {
        double cost = targetCurrencyRate * 100;
        return rubs / cost;
    }

}
