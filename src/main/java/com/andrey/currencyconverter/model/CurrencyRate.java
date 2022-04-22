package com.andrey.currencyconverter.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class CurrencyRate {
    private CurrencyType code;
    private Double rate;
}
