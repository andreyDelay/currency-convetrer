package com.andrey.currencyconverter.controllers;

import com.andrey.currencyconverter.model.dto.CurrencyDto;

public interface Controller {

    CurrencyDto convertCurrency(String rublesQty, String targetCurrencyCode);
}
