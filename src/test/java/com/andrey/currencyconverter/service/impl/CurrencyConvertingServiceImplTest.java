package com.andrey.currencyconverter.service.impl;

import com.andrey.currencyconverter.model.CurrencyRate;
import com.andrey.currencyconverter.model.CurrencyType;
import com.andrey.currencyconverter.model.dto.CurrencyDto;
import com.andrey.currencyconverter.service.CurrencyConvertingService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CurrencyConvertingServiceImplTest {

    private CurrencyConvertingService underTest = new CurrencyConvertingServiceImpl();

    private CurrencyRate getRate() {
        CurrencyRate currencyRate = new CurrencyRate();
        currencyRate.setRate(0.76671730591219);
        currencyRate.setCode(CurrencyType.USD);
        return currencyRate;
    }

    @Test
    void shouldReturnConvertedNumberOfTargetCurrency() {
        //given
        double rubles = 150L;
        CurrencyRate currencyRate = getRate();
        double amountOfTargetCurrency = rubles / (currencyRate.getRate() * 100);
        //when
        CurrencyDto currencyDto = underTest.convertCurrency(rubles, currencyRate);
        //then
        assertEquals(currencyDto.getAmountOfTargetCurrency(), amountOfTargetCurrency);
    }
}