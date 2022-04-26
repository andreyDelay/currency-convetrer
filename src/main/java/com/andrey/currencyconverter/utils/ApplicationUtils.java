package com.andrey.currencyconverter.utils;

import com.andrey.currencyconverter.exceptions.PropertyValueNotFoundException;
import com.andrey.currencyconverter.model.CurrencyRate;
import com.andrey.currencyconverter.model.dto.CurrencyDto;
import com.andrey.currencyconverter.repo.CurrencyRepository;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApplicationUtils {

    private static Properties properties = new Properties();

    public static String getPropertyValueByKey(String key) throws PropertyValueNotFoundException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try (InputStream stream = loader.getResourceAsStream("application.properties")) {
            properties.load(stream);
            String value = properties.getProperty(key);

            if (value.length() == 0) {
                throw new IOException();
            }

            return value;
        } catch (IOException e) {
            throw new PropertyValueNotFoundException("Property file not found or path to json file repo not found!");
        }
    }

    public static CurrencyRepository<CurrencyDto> getRepositoryImplementation() throws PropertyValueNotFoundException {
        loadProperties();
        String repoClassPropertyValue = properties.getProperty("currency-repository-implementation");
        try {
            Class<?> aClass = Class.forName(repoClassPropertyValue);
            return CurrencyRepository.class.cast(aClass);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(String.format("No class with class name %s was found", repoClassPropertyValue));
        }
    }

    private static void loadProperties() throws PropertyValueNotFoundException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try (InputStream stream = loader.getResourceAsStream("application.properties")) {
            properties.load(stream);
        } catch (IOException e) {
            throw new PropertyValueNotFoundException("Couldn't load property parameters from application.property file");
        }
    }
}
