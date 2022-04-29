package com.andrey.currencyconverter.repo;


import java.util.List;

public interface CurrencyRepository<T> {
    T getByCurrencyCode(/*@Pattern(regexp = "[A-Z]{5}") @Valid*/ String name);
    List<T> getAll();
}
