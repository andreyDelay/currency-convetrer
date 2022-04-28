package com.andrey.currencyconverter.service;

import com.andrey.currencyconverter.model.CurrencyRate;
import com.andrey.currencyconverter.model.dto.CurrencyDto;
import com.andrey.currencyconverter.validators.ValidRublesInputValue;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Validated
public interface CurrencyConvertingService {

    CurrencyDto convertCurrency(@Valid @ValidRublesInputValue Double rublesQty, CurrencyRate targetCurrencyInfo);
}
