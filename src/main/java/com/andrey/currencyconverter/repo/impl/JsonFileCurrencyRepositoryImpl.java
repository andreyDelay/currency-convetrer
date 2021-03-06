package com.andrey.currencyconverter.repo.impl;

import com.andrey.currencyconverter.model.CurrencyRate;
import com.andrey.currencyconverter.repo.CurrencyRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

public class JsonFileCurrencyRepositoryImpl implements CurrencyRepository<CurrencyRate> {
    private final String pathToRepositoryFile;

    public JsonFileCurrencyRepositoryImpl(String pathToRepository) {
        this.pathToRepositoryFile = pathToRepository;
    }

    @Override
    public CurrencyRate getByCurrencyCode(String currencyCode) {
        Optional<CurrencyRate> first = getAll().stream()
                .filter(currencyRate -> currencyRate.getCharCode().equalsIgnoreCase(currencyCode))
                .findFirst();

        if (first.isEmpty()) {
            throw new NoSuchElementException(String.format("Rate for currency %s not found", currencyCode));
        }
        return first.get();
    }

    @Override
    public List<CurrencyRate> getAll() {
        File file = new File(pathToRepositoryFile);
        Gson gson = new Gson();
        JsonReader jsonReader;
        try {
            jsonReader = new JsonReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        List<CurrencyRate> currencyRates =
                gson.fromJson(jsonReader, new TypeToken<List<CurrencyRate>>() {}.getType());
        return currencyRates.stream()
                .peek(currencyRate -> currencyRate.setValue(currencyRate.getValue() * 100L))
                .collect(Collectors.toList());
    }
}
