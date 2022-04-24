package com.andrey.currencyconverter.controllers.impl;

import com.andrey.currencyconverter.controllers.Controller;
import com.andrey.currencyconverter.exceptions.CurrencyCodeNotFoundException;
import com.andrey.currencyconverter.exceptions.InputCurrencyBalanceException;
import com.andrey.currencyconverter.model.CurrencyRate;
import com.andrey.currencyconverter.model.dto.CurrencyDto;
import com.andrey.currencyconverter.repo.CurrencyRepository;
import com.andrey.currencyconverter.validators.Validator;

public class ControllerImpl implements Controller {

    private final CurrencyRepository<CurrencyRate> repository;
    private final Validator validator;

    public ControllerImpl(CurrencyRepository repository, Validator validator) {
        this.repository = repository;
        this.validator = validator;
    }

    @Override
    public CurrencyDto convertCurrency(String rublesQty, String targetCurrencyCode) {
        try {
            validator.validateParameters(rublesQty, targetCurrencyCode);
            double rubles = Double.parseDouble(rublesQty);
            CurrencyRate targetCurrencyInfo = repository.getByCurrencyCode(targetCurrencyCode);
            Double convertedTargetCurrency = convertBalance(rubles, targetCurrencyInfo.getRate());

            return CurrencyDto.builder()
                    .initialAmountOfRubles(rubles)
                    .targetCurrency(targetCurrencyInfo.getCode())
                    .targetCurrencyRate(targetCurrencyInfo.getRate() * 100)
                    .amountOfTargetCurrency(convertedTargetCurrency)
                    .build();
        } catch (CurrencyCodeNotFoundException e) {
            throw new IllegalArgumentException(String.format("Currency with code - %s not found", targetCurrencyCode));
        } catch (InputCurrencyBalanceException e) {
            throw new IllegalArgumentException("Wrong currency input balance");
        }
    }

    private Double convertBalance(double rubs, double targetCurrencyRate) {
        double cost = targetCurrencyRate * 100;
        return rubs / cost;
    }

}
