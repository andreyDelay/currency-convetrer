package com.andrey.currencyconverter.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("application.properties")
@ComponentScan("com.andrey.currencyconverter")
public class App
{
    public static void main( String[] args ) {
        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        ApplicationFlow applicationFlow = context.getBean(ApplicationFlow.class);
        applicationFlow.startFlow();
    }
}
