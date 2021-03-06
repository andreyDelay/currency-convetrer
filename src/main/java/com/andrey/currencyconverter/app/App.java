package com.andrey.currencyconverter.app;

import com.andrey.currencyconverter.exceptions.ClassInitializingException;
import com.andrey.currencyconverter.exceptions.PropertyValueNotFoundException;
import com.andrey.currencyconverter.repo.CurrencyRepository;
import com.andrey.currencyconverter.service.CurrencyConvertingService;
import com.andrey.currencyconverter.service.impl.CurrencyConvertingServiceImpl;
import com.andrey.currencyconverter.utils.ApplicationUtils;
import com.andrey.currencyconverter.validators.Validator;
import com.andrey.currencyconverter.view.Impl.ConsoleInterfaceImplementation;
import com.andrey.currencyconverter.view.UserInterface;

public class App
{
    public static void main( String[] args ) {
        try {

            CurrencyRepository repository = ApplicationUtils.getRepositoryImplementation();
            CurrencyConvertingService currencyService = new CurrencyConvertingServiceImpl();
            UserInterface userInterface = new ConsoleInterfaceImplementation();
            Validator validator = new Validator();

            ApplicationFlow applicationFlow =
                    new ConsoleApplicationFlow(userInterface, currencyService, repository, validator);
            applicationFlow.startFlow();
        } catch (PropertyValueNotFoundException | ClassInitializingException e) {
            e.printStackTrace();
        }
    }
}
