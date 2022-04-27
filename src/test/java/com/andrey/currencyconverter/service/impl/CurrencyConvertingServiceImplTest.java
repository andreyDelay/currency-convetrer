package com.andrey.currencyconverter.service.impl;

import com.andrey.currencyconverter.model.dto.CurrencyDto;
import com.andrey.currencyconverter.service.CurrencyConvertingService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CurrencyConvertingServiceImplTest {

    private CurrencyConvertingService underTest = new CurrencyConvertingServiceImpl();

    private com.andrey.currencyconverter.model.CurrencyRate getRate() {
        com.andrey.currencyconverter.model.CurrencyRate currencyRate = new com.andrey.currencyconverter.model.CurrencyRate();
        currencyRate.setValue(0.76671730591219);
        currencyRate.setCharCode("USD");
        return currencyRate;
    }

    @Test
    void shouldReturnConvertedNumberOfTargetCurrency() {
        //given
        double rubles = 150L;
        com.andrey.currencyconverter.model.CurrencyRate currencyRate = getRate();
        double amountOfTargetCurrency = rubles / (currencyRate.getValue() * 100);
        //when
        CurrencyDto currencyDto = underTest.convertCurrency(rubles, currencyRate);
        //then
        assertEquals(currencyDto.getConvertedTargetCurrency(), amountOfTargetCurrency);
    }
}