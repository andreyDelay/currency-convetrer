package com.andrey.currencyconverter.service.impl;

import com.andrey.currencyconverter.dto.CurrencyDto;
import com.andrey.currencyconverter.dto.TokenMoneyDto;
import com.andrey.currencyconverter.model.CurrencyRate;
import com.andrey.currencyconverter.service.CurrencyConvertingService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CurrencyConvertingServiceImplTest {

    private CurrencyConvertingService underTest = new CurrencyConvertingServiceImpl();

    private com.andrey.currencyconverter.model.CurrencyRate getRate() {
        com.andrey.currencyconverter.model.CurrencyRate currencyRate = new CurrencyRate();
        currencyRate.setRate(0.76671730591219);
        currencyRate.setCharCode("USD");
        return currencyRate;
    }

    @Test
    void shouldReturnConvertedNumberOfTargetCurrency() {
        //given
        CurrencyRate currencyRate = getRate();
        TokenMoneyDto tokenMoneyDto = new TokenMoneyDto();
        tokenMoneyDto.setTargetCurrencyCode("USD");
        tokenMoneyDto.setRublesQty(150);

        double amountOfTargetCurrency = tokenMoneyDto.getRublesQty() / (currencyRate.getRate());
        //when
        CurrencyDto currencyDto = underTest.convertCurrency(tokenMoneyDto, currencyRate);
        //then
        assertEquals(currencyDto.getConvertedTargetCurrency(), amountOfTargetCurrency);
    }
}