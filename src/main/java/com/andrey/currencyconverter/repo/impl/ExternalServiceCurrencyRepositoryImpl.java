package com.andrey.currencyconverter.repo.impl;

import com.andrey.currencyconverter.model.CurrencyRate;
import com.andrey.currencyconverter.repo.CurrencyRepository;
import com.google.gson.Gson;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/*@Repository(value = "ExternalRepository")*/
public class ExternalServiceCurrencyRepositoryImpl implements CurrencyRepository<CurrencyRate> {

    @Value("${repository-path}")
    private String pathToRepository;
    private final OkHttpClient okHttpClient;

    public ExternalServiceCurrencyRepositoryImpl() {
        this.okHttpClient = new OkHttpClient();
    }

    @Override
    public CurrencyRate getByCurrencyCode(String currencyCode) {
        Request request = new Request.Builder()
                .url(pathToRepository + currencyCode)
                .build();
        Call call = okHttpClient.newCall(request);

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
        return Collections.emptyList();
    }
}
