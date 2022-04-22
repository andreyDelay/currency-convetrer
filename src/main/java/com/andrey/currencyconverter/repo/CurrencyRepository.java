package com.andrey.currencyconverter.repo;

import java.util.List;

public interface CurrencyRepository<T> {
    T getByCurrencyCode(String name);
    List<T> getAll();
}
