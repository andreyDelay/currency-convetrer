package com.andrey.currencyconverter.service;

import com.andrey.currencyconverter.model.CurrencyRate;
import com.andrey.currencyconverter.model.dto.CurrencyDto;

public interface CurrencyConvertingService {

    CurrencyDto convertCurrency(String rublesQty, CurrencyRate targetCurrencyInfo);
}
