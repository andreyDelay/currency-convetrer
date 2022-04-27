package com.andrey.currencyconverter.validators;

import com.andrey.currencyconverter.exceptions.CurrencyCodeNotFoundException;
import com.andrey.currencyconverter.exceptions.InputCurrencyBalanceException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidatorTest {

    Validator underTest = new Validator();

    @Test
    void shouldThrowInputCurrencyBalanceExceptionIfRublesValueZero() {
        //given
        String zeroRublesValue = "0";
        String currencyCode = "eur";
        //when
        Exception exception = assertThrows(InputCurrencyBalanceException.class,
                () -> underTest.validateParameters(zeroRublesValue,currencyCode));
        //then
        assertEquals(
                String.format("Wrong incoming currency balance value - %s", zeroRublesValue),
                exception.getMessage());
    }

    @Test
    void shouldThrowInputCurrencyBalanceExceptionIfRublesValueNegative() {
        //given
        String zeroRublesValue = "-5";
        String currencyCode = "USD";
        //when
        Exception exception = assertThrows(InputCurrencyBalanceException.class,
                () -> underTest.validateParameters(zeroRublesValue,currencyCode));
        //then
        assertEquals(
                String.format("Wrong incoming currency balance value - %s", zeroRublesValue),
                exception.getMessage());
    }

    @Test
    void shouldThrowInputCurrencyBalanceExceptionIfNotNumberValue() {
        //given
        String zeroRublesValue = "!&#";
        String currencyCode = "JPY";
        //when
        Exception exception = assertThrows(InputCurrencyBalanceException.class,
                () -> underTest.validateParameters(zeroRublesValue,currencyCode));
        //then
        assertEquals(
                String.format("Wrong incoming currency balance value - %s", zeroRublesValue),
                exception.getMessage());
    }

    @Test
    void shouldThrowInputCurrencyBalanceExceptionWhenDigitGroupingSymbolWrong() {
        //given
        String rublesValueWithWrongGroupingSymbol = "150,2";
        String currencyCode = "rub";
        //when
        Exception exception = assertThrows(InputCurrencyBalanceException.class,
                () -> underTest.validateParameters(rublesValueWithWrongGroupingSymbol, currencyCode));
        //then
        assertEquals(
                String.format("Wrong incoming currency balance value - %s", rublesValueWithWrongGroupingSymbol),
                exception.getMessage());
    }

    @Test
    void shouldThrowCurrencyCodeNotFoundExceptionIfWrongCurrencyCode() {
        //given
        String rublesValue = "150.5";
        String currencyCode = "QWERTY";
        //when
        Exception exception = assertThrows(CurrencyCodeNotFoundException.class,
                () -> underTest.validateParameters(rublesValue, currencyCode));
        //then
        assertEquals(
                String.format("Wrong currency code - %s", currencyCode),
                exception.getMessage());
    }
}