package com.andrey.currencyconverter.service;

import com.andrey.currencyconverter.model.dto.CurrencyDto;
import org.springframework.stereotype.Service;

@Service
public interface CurrencyConvertingService {

    CurrencyDto convertCurrency(double rublesQty, com.andrey.currencyconverter.model.CurrencyRate targetCurrencyInfo);
}
