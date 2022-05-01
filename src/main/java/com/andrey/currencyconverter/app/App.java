package com.andrey.currencyconverter.app;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;


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

    @Bean
    public Validator validator() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        return validatorFactory.getValidator();
    }

}
