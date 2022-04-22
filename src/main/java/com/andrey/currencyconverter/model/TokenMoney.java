package com.andrey.currencyconverter.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TokenMoney {
    private Double initialQuantity;
    private CurrencyType currencyType;
    private CurrencyType targetCurrencyType;
}
