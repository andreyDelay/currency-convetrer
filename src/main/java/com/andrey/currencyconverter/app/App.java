package com.andrey.currencyconverter.app;

import com.andrey.currencyconverter.controllers.Controller;
import com.andrey.currencyconverter.controllers.impl.ControllerImpl;
import com.andrey.currencyconverter.exceptions.RepositoryPathNotFoundException;
import com.andrey.currencyconverter.repo.CurrencyRepository;
import com.andrey.currencyconverter.repo.impl.JsonFileCurrencyRepositoryImpl;
import com.andrey.currencyconverter.utils.ApplicationUtils;
import com.andrey.currencyconverter.validators.Validator;
import com.andrey.currencyconverter.view.Impl.ConsoleInterfaceImplementation;
import com.andrey.currencyconverter.view.UserInterface;

public class App
{
    public static void main( String[] args ) {
        try {
            String pathToJsonFileRepository = ApplicationUtils.getPathToJsonFileRepo();

            CurrencyRepository repository = new JsonFileCurrencyRepositoryImpl(pathToJsonFileRepository);
            Controller controller = new ControllerImpl(repository, new Validator());
            UserInterface userInterface = new ConsoleInterfaceImplementation(controller);
            ApplicationFlow applicationFlow = new ConsoleApplicationFlow(userInterface, new Validator());
            applicationFlow.startFlow();
        } catch (RepositoryPathNotFoundException e) {
            e.printStackTrace();
        }
    }
}
