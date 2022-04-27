package com.andrey.currencyconverter.utils;

import com.andrey.currencyconverter.exceptions.ClassInitializingException;
import com.andrey.currencyconverter.exceptions.PropertyValueNotFoundException;
import com.andrey.currencyconverter.repo.CurrencyRepository;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class ApplicationUtils {

    private static Properties properties = new Properties();

    public static CurrencyRepository getRepositoryImplementation() throws PropertyValueNotFoundException, ClassInitializingException {
        loadProperties();
        String repoClassPropertyValue = properties.getProperty("currency-repository-implementation");
        try {
            String pathToRepository = properties.getProperty("repository-path");
            Class<?> aClass = Class.forName(repoClassPropertyValue);
            Constructor<?> constructor = aClass.getConstructor(String.class);
            return (CurrencyRepository)constructor.newInstance(pathToRepository);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new ClassInitializingException(String.format("No class with class name %s was found", repoClassPropertyValue));
        } catch (NoSuchMethodException e) {
            throw new ClassInitializingException("Couldn't create a new instance of target class.");
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
