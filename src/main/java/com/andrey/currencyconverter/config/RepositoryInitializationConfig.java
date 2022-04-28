package com.andrey.currencyconverter.config;

import com.andrey.currencyconverter.app.ApplicationFlow;
import com.andrey.currencyconverter.app.ConsoleApplicationFlow;
import com.andrey.currencyconverter.config.condition.ExternalServiceRepositoryInitializationCondition;
import com.andrey.currencyconverter.config.condition.JsonRepositoryInitializationCondition;
import com.andrey.currencyconverter.repo.CurrencyRepository;
import com.andrey.currencyconverter.repo.impl.JsonFileCurrencyRepositoryImpl;
import com.andrey.currencyconverter.service.CurrencyConvertingService;
import com.andrey.currencyconverter.service.impl.CurrencyConvertingServiceImpl;
import com.andrey.currencyconverter.view.Impl.ConsoleInterfaceImplementation;
import com.andrey.currencyconverter.view.UserInterface;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("application.properties")
public class RepositoryInitializationConfig {

    @Value("${repository-path}")
    private String repositoryUrl;

    @Bean
    @Conditional(JsonRepositoryInitializationCondition.class)
    public CurrencyRepository getJsonFileCurrencyRepositoryImplementation() {
        return new JsonFileCurrencyRepositoryImpl(repositoryUrl);
    }

    @Bean
    @Conditional(ExternalServiceRepositoryInitializationCondition.class)
    public CurrencyRepository getExternalServiceCurrencyRepositoryImplementation() {
        return new JsonFileCurrencyRepositoryImpl(repositoryUrl);
    }

    @Bean
    public UserInterface userInterface() {
        return new ConsoleInterfaceImplementation();
    }

    @Bean
    public CurrencyConvertingService currencyConvertingService() {
        return new CurrencyConvertingServiceImpl();
    }

}
