package com.andrey.currencyconverter.view.Impl;

import com.andrey.currencyconverter.model.dto.CurrencyDto;
import com.andrey.currencyconverter.view.UserInterface;

import java.util.Scanner;

public class ConsoleInterfaceImplementation implements UserInterface {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void showGreeting() {
        System.out.println("Welcome to currency converter!");
        System.out.println("*********************************\n");
        System.out.println("To stop the program - type 'exit'.");
        System.out.println();
    }

    @Override
    public String requestAmountOfRubles() {
        System.out.println("Please, input amount of rubles!");
        return scanner.nextLine();
    }
    @Override
    public String requestTargetCurrencyType() {
        System.out.println("Please, input target currency type!");
        return scanner.nextLine();
    }

    @Override
    public void showErrorMessage(String error) {
        System.out.println(error);
        System.out.println();
        System.out.println("Please, try again\n");
    }

    @Override
    public void printOperationResult(CurrencyDto result) {
        System.out.println(result.toString());
        System.out.println("*********************************\n");
        System.out.println("To stop the program - type 'exit'.\n");
    }

}
