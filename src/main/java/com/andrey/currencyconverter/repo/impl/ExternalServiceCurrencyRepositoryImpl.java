package com.andrey.currencyconverter.repo.impl;

import com.andrey.currencyconverter.model.CurrencyRate;
import com.andrey.currencyconverter.repo.CurrencyRepository;
import com.google.gson.Gson;
import okhttp3.*;

import java.io.IOException;
import java.util.List;

public class ExternalServiceCurrencyRepositoryImpl implements CurrencyRepository<CurrencyRate> {

    private final String pathToRepository;

    public ExternalServiceCurrencyRepositoryImpl(String pathToRepository) {
        this.pathToRepository = pathToRepository;
    }

    @Override
    public CurrencyRate getByCurrencyCode(String currencyCode) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(pathToRepository + currencyCode)
                .build();
        Call call = client.newCall(request);

        try(Response response = call.execute()) {
            ResponseBody responseBody = response.body();
            Gson gson = new Gson();
            return gson.fromJson(responseBody.string(),CurrencyRate.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<CurrencyRate> getAll() {
        return null;
    }
}
