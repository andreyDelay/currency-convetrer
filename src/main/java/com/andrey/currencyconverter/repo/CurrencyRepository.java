package com.andrey.currencyconverter.repo;

import java.util.List;

public interface GenericRepository<T> {

    T getByName(String name);

    List<T> getAll();
}
