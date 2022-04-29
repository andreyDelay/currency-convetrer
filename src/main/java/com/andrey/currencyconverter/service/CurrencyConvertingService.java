package com.andrey.currencyconverter.service;

import com.andrey.currencyconverter.model.CurrencyRate;
import com.andrey.currencyconverter.model.dto.CurrencyDto;
import com.andrey.currencyconverter.validators.ValidRublesInputValue;

import javax.validation.Valid;


public interface CurrencyConvertingService {

    CurrencyDto convertCurrency(
            @ValidRublesInputValue @Valid Double rublesQty,
            CurrencyRate targetCurrencyInfo);
}
