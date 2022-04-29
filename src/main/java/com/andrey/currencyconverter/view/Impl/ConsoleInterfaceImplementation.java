package com.andrey.currencyconverter.view.Impl;

import com.andrey.currencyconverter.model.dto.CurrencyDto;
import com.andrey.currencyconverter.view.UserInterface;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
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
    public double requestAmountOfRubles() {
        System.out.println("Please, input amount of rubles!");
        String rublesInputValue = scanner.nextLine();
        stopIfInputValueEqualsExit(rublesInputValue);
        double result;
        try {
            result = Double.parseDouble(rublesInputValue);
        } catch (NumberFormatException e) {
            result = Double.NaN;
        }
        return result;
    }
    @Override
    public String requestTargetCurrencyType() {
        System.out.println("Please, input target currency type!");
        String consoleInputValue = scanner.nextLine();
        stopIfInputValueEqualsExit(consoleInputValue);
        return consoleInputValue;
    }

    @Override
    public void showErrorMessage(String error) {
        System.out.println(error);
        System.out.println();
        System.out.println("Please, try again\n");
    }

    @Override
    public void printOperationResult(CurrencyDto result) {
        if (result == null) {
            System.out.println("For target currency no any info for now.");
        } else {
            System.out.println(result);
        }
        System.out.println("*********************************\n");
        System.out.println("To stop the program - type 'exit'.\n");
    }

    private void stopIfInputValueEqualsExit(String consoleInputData) {
        if (consoleInputData.equalsIgnoreCase("exit")) {
            System.exit(0);
        }
    }

}
