package com.andrey.currencyconverter.app;

import com.andrey.currencyconverter.config.RepositoryInitializationConfig;
import com.andrey.currencyconverter.repo.CurrencyRepository;
import com.andrey.currencyconverter.service.CurrencyConvertingService;
import com.andrey.currencyconverter.validators.Validator;
import com.andrey.currencyconverter.view.UserInterface;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class App
{
    public static void main( String[] args ) {
        ApplicationContext context = new AnnotationConfigApplicationContext(RepositoryInitializationConfig.class);
        ApplicationFlow applicationFlow = context.getBean(ApplicationFlow.class);
        applicationFlow.startFlow();
    }
}
