package com.andrey.currencyconverter.repo.impl;

import com.andrey.currencyconverter.model.CurrencyRate;
import com.andrey.currencyconverter.model.CurrencyType;
import com.andrey.currencyconverter.repo.JsonFileCurrencyRepository;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class JsonFileCurrencyRepositoryImpl implements JsonFileCurrencyRepository {
    private final String pathToRepositoryFile;

    public JsonFileCurrencyRepositoryImpl(String pathToRepositoryFile) {
        this.pathToRepositoryFile = pathToRepositoryFile;
    }

    @Override
    public CurrencyRate getByCurrencyCode(String currencyCode) {
        CurrencyType currencyType = CurrencyType.valueOf(currencyCode);
        Optional<CurrencyRate> first = getAll().stream()
                .filter(currencyRate -> currencyRate.getCode().equals(currencyType))
                .findFirst();

        if (first.isEmpty()) {
            return null;
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
        return Arrays.asList(gson.fromJson(jsonReader, CurrencyRate[].class));
    }
}
