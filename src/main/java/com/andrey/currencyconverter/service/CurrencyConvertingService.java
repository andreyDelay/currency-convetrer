package com.andrey.currencyconverter.service;

import com.andrey.currencyconverter.dto.CurrencyDto;
import com.andrey.currencyconverter.model.CurrencyRate;


public interface CurrencyConvertingService {

    CurrencyDto convertCurrency(Double rublesQty,
            CurrencyRate targetCurrencyInfo);
}
