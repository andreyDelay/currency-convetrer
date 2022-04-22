package com.andrey.currencyconverter.controllers;

import com.andrey.currencyconverter.model.TokenMoney;
import com.andrey.currencyconverter.model.dto.CurrencyDto;

public interface Controller {

    CurrencyDto convertCurrency(TokenMoney tokenMoney);
}
