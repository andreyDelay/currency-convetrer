package com.andrey.currencyconverter.service.impl;

import com.andrey.currencyconverter.dto.TokenMoneyDto;
import com.andrey.currencyconverter.model.CurrencyRate;
import com.andrey.currencyconverter.dto.CurrencyDto;
import com.andrey.currencyconverter.service.CurrencyConvertingService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;


@Service
@Validated
public class CurrencyConvertingServiceImpl implements CurrencyConvertingService {

    @Override
    public CurrencyDto convertCurrency(TokenMoneyDto tokenMoneyDto, CurrencyRate currencyRate) {
        double convertedTargetCurrency = convertBalance(tokenMoneyDto.getRublesQty(), currencyRate.getRate());

        return CurrencyDto.builder()
                .initialAmountOfRubles(tokenMoneyDto.getRublesQty())
                .targetCurrencyCode(currencyRate.getCharCode())
                .targetCurrencyRate(currencyRate.getRate())
                .convertedTargetCurrency(convertedTargetCurrency)
                .build();
    }

    private double convertBalance(double rubs, double targetCurrencyRate) {
        return rubs / targetCurrencyRate;
    }

}
