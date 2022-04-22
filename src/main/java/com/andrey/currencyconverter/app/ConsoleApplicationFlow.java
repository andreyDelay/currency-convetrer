package com.andrey.currencyconverter.app;

import com.andrey.currencyconverter.controllers.Controller;
import com.andrey.currencyconverter.exceptions.CurrencyCodeNotFoundException;
import com.andrey.currencyconverter.exceptions.InputCurrencyBalanceException;
import com.andrey.currencyconverter.model.CurrencyType;
import com.andrey.currencyconverter.model.TokenMoney;
import com.andrey.currencyconverter.model.dto.CurrencyDto;
import com.andrey.currencyconverter.utils.Utils;
import com.andrey.currencyconverter.view.UserInterface;

public class ConsoleApplicationFlow implements ApplicationFlow {

        private void stopIfExitWasInput(String inputValue) {
        if (inputValue.equalsIgnoreCase("exit")) {
            System.exit(0);
        }
    }

    @Override
    public void startFlow(UserInterface userInterface, Controller controller) {
        userInterface.showGreeting();
        String amountOfRubles;
        String targetCurrencyCode;

        do {
            amountOfRubles = userInterface.requestAmountOfRubles();
            stopIfExitWasInput(amountOfRubles);
            targetCurrencyCode = userInterface.requestTargetCurrencyType();
            stopIfExitWasInput(targetCurrencyCode);

            try {
                Utils.validateParameters(amountOfRubles, targetCurrencyCode);
                TokenMoney tokenMoney = TokenMoney.builder()
                        .currencyType(CurrencyType.RUB)
                        .initialQuantity(Double.parseDouble(amountOfRubles))
                        .targetCurrencyType(CurrencyType.valueOf(targetCurrencyCode))
                        .build();

                CurrencyDto targetCurrencyInfo =
                        controller.convertCurrency(tokenMoney);
                System.out.println(targetCurrencyInfo);
            } catch (CurrencyCodeNotFoundException e) {
                userInterface.showErrorMessage(String.format("Currency with code - %s not found", targetCurrencyCode));
            } catch (InputCurrencyBalanceException e) {
                userInterface.showErrorMessage("Wrong currency input balance");
            }

        } while (!(amountOfRubles.equalsIgnoreCase("exit") ||
                targetCurrencyCode.equalsIgnoreCase("exit")));
    }
}
