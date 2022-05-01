package com.andrey.currencyconverter.service;

import com.andrey.currencyconverter.dto.CurrencyDto;
import com.andrey.currencyconverter.dto.TokenMoneyDto;
import com.andrey.currencyconverter.model.CurrencyRate;


public interface CurrencyConvertingService {

    CurrencyDto convertCurrency(TokenMoneyDto tokenMoneyDto, CurrencyRate currencyRate);
}
