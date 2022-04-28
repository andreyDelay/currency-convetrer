package com.andrey.currencyconverter.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Component
public class CurrencyRate {
    private String charCode;
    private double value;
}
