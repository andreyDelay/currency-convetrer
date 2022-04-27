package com.andrey.currencyconverter.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CurrencyRate {
    private String charCode;
    private double value;
}
