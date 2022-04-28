package com.andrey.currencyconverter.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.andrey.currencyconverter")
public class App
{
    public static void main( String[] args ) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
        ApplicationFlow applicationFlow = context.getBean(ApplicationFlow.class);
        applicationFlow.startFlow();
    }
}
