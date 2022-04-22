package com.andrey.currencyconverter.app;

import com.andrey.currencyconverter.controllers.Controller;
import com.andrey.currencyconverter.controllers.impl.ControllerImpl;
import com.andrey.currencyconverter.repo.JsonFileCurrencyRepository;
import com.andrey.currencyconverter.repo.impl.JsonFileCurrencyRepositoryImpl;
import com.andrey.currencyconverter.view.Impl.ConsoleInterfaceImplementation;
import com.andrey.currencyconverter.view.UserInterface;

public class App
{
    public static void main( String[] args ) {
        JsonFileCurrencyRepository jsonFileRepository = new JsonFileCurrencyRepositoryImpl();
        Controller controller = new ControllerImpl(jsonFileRepository);
        UserInterface userInterface = new ConsoleInterfaceImplementation(controller);
        ApplicationFlow applicationFlow = new ConsoleApplicationFlow(userInterface);
        applicationFlow.startFlow();
    }
}
