package com.andrey.currencyconverter.service.impl;

import com.andrey.currencyconverter.model.CurrencyRate;
import com.andrey.currencyconverter.model.dto.CurrencyDto;
import com.andrey.currencyconverter.service.CurrencyConvertingService;

public class CurrencyConvertingServiceImpl implements CurrencyConvertingService {

    @Override
    public CurrencyDto convertCurrency(double rublesQty, CurrencyRate targetCurrencyInfo) {
        double convertedTargetCurrency = convertBalance(rublesQty, targetCurrencyInfo.getRate());

        return CurrencyDto.builder()
                .initialAmountOfRubles(rublesQty)
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
