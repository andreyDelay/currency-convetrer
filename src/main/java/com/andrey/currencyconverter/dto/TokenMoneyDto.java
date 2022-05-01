package com.andrey.currencyconverter.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TokenMoneyDto {

    @Min(1)
    private double rublesQty;

    @Pattern(regexp = "[A-Z]{3}")
    private String targetCurrencyCode;
}
