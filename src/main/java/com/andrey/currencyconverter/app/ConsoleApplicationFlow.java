package com.andrey.currencyconverter.app;

import com.andrey.currencyconverter.exceptions.CurrencyCodeNotFoundException;
import com.andrey.currencyconverter.exceptions.InputCurrencyBalanceException;
import com.andrey.currencyconverter.model.CurrencyType;
import com.andrey.currencyconverter.model.TokenMoney;
import com.andrey.currencyconverter.model.dto.CurrencyDto;
import com.andrey.currencyconverter.validators.Validator;
import com.andrey.currencyconverter.view.UserInterface;

public class ConsoleApplicationFlow implements ApplicationFlow {

    private final UserInterface userInterface;

    public ConsoleApplicationFlow(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    @Override
    public void startFlow() {
        userInterface.showGreeting();
        String amountOfRubles = "";
        String targetCurrencyCode = "";

        do {
            try {
                amountOfRubles = userInterface.requestAmountOfRubles();
                targetCurrencyCode = userInterface.requestTargetCurrencyType();
                Validator.validateParameters(amountOfRubles, targetCurrencyCode);

                TokenMoney tokenMoney = TokenMoney.builder()
                        .currencyType(CurrencyType.RUB)
                        .initialQuantity(Double.parseDouble(amountOfRubles))
                        .targetCurrencyType(CurrencyType.valueOf(targetCurrencyCode))
                        .build();

                CurrencyDto targetCurrencyInfo =
                        userInterface.convert(tokenMoney);

                userInterface.printOperationResult(targetCurrencyInfo);
            } catch (CurrencyCodeNotFoundException e) {
                userInterface.showErrorMessage(String.format("Currency with code - %s not found", targetCurrencyCode));
            } catch (InputCurrencyBalanceException e) {
                userInterface.showErrorMessage("Wrong currency input balance");
            }

        } while (!(amountOfRubles.equalsIgnoreCase("exit") ||
                targetCurrencyCode.equalsIgnoreCase("exit")));
    }
}
