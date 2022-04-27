package com.andrey.currencyconverter.service;

import com.andrey.currencyconverter.model.dto.CurrencyDto;

public interface CurrencyConvertingService {

    CurrencyDto convertCurrency(double rublesQty, com.andrey.currencyconverter.model.CurrencyRate targetCurrencyInfo);
}
