package com.andrey.currencyconverter.controllers.impl;

import com.andrey.currencyconverter.controllers.Controller;
import com.andrey.currencyconverter.model.CurrencyRate;
import com.andrey.currencyconverter.model.dto.CurrencyDto;
import com.andrey.currencyconverter.repo.CurrencyRepository;

public class ControllerImpl implements Controller {

    private final CurrencyRepository<CurrencyRate> repository;

    public ControllerImpl(CurrencyRepository repository) {
        this.repository = repository;
    }

    @Override
    public CurrencyDto convertCurrency(String rublesQty, String targetCurrencyCode) {
        double rubles = Double.parseDouble(rublesQty);
        CurrencyRate targetCurrencyInfo = repository.getByCurrencyCode(targetCurrencyCode);
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
