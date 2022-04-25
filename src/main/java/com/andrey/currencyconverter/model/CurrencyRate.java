package com.andrey.currencyconverter.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CurrencyRate {
    private CurrencyType code;
    private double rate;
}
