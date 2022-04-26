package com.andrey.currencyconverter.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CurrencyRate {
    private CurrencyType code;
    private double rate;
}
