package com.andrey.currencyconverter.controllers.impl;

import com.andrey.currencyconverter.controllers.Controller;
import com.andrey.currencyconverter.model.CurrencyRate;
import com.andrey.currencyconverter.model.CurrencyType;
import com.andrey.currencyconverter.model.TokenMoney;
import com.andrey.currencyconverter.model.dto.CurrencyDto;
import com.andrey.currencyconverter.repo.JsonFileRepository;

public class ConsoleControllerImpl implements Controller {

    private final JsonFileRepository repository;
    public ConsoleControllerImpl(JsonFileRepository repository) {
        this.repository = repository;
    }
    @Override
    public CurrencyDto convertCurrency(TokenMoney tokenMoney) {
        CurrencyType targetType = tokenMoney.getTargetCurrencyType();
        CurrencyRate rate = repository.getRateByCurrencyCode(targetType.toString());
        double convertedBalance = convertBalance(tokenMoney.getInitialQuantity(), rate.getRate());

        return CurrencyDto.builder()
                .initialAmountOfRubles(tokenMoney.getInitialQuantity())
                .targetCurrency(tokenMoney.getTargetCurrencyType())
                .targetCurrencyRate(rate.getRate() * 100)
                .amountOfTargetCurrency(convertedBalance)
                .build();
    }

    private Double convertBalance(double rubs, double targetCurrencyRate) {
        double cost = targetCurrencyRate * 100;
        return rubs / cost;
    }

}
