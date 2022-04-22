package com.andrey.currencyconverter.repo;

import com.andrey.currencyconverter.model.CurrencyRate;

import java.util.List;

public interface GenericRepository<T> {

    T getRateByCurrencyCode(String currencyCode);

    List<T> getRates();
}
