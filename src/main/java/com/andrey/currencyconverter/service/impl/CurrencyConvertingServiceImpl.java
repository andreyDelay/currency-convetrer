package com.andrey.currencyconverter.service.impl;

import com.andrey.currencyconverter.model.CurrencyRate;
import com.andrey.currencyconverter.model.dto.CurrencyDto;
import com.andrey.currencyconverter.service.CurrencyConvertingService;
import org.springframework.stereotype.Service;

@Service
public class CurrencyConvertingServiceImpl implements CurrencyConvertingService {

    @Override
    public CurrencyDto convertCurrency(double rublesQty, CurrencyRate targetCurrencyInfo) {
        double convertedTargetCurrency = convertBalance(rublesQty, targetCurrencyInfo.getValue());

        return CurrencyDto.builder()
                .initialAmountOfRubles(rublesQty)
                .targetCurrencyCode(targetCurrencyInfo.getCharCode())
                .targetCurrencyRate(targetCurrencyInfo.getValue())
                .convertedTargetCurrency(convertedTargetCurrency)
                .build();
    }

    private double convertBalance(double rubs, double targetCurrencyRate) {
        return rubs / targetCurrencyRate;
    }

}
