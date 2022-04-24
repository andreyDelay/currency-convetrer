package com.andrey.currencyconverter.app;

import com.andrey.currencyconverter.model.dto.CurrencyDto;
import com.andrey.currencyconverter.validators.Validator;
import com.andrey.currencyconverter.view.UserInterface;

public class ConsoleApplicationFlow implements ApplicationFlow {

    private final UserInterface userInterface;
    private final Validator validator;

    public ConsoleApplicationFlow(UserInterface userInterface, Validator validator) {
        this.userInterface = userInterface;
        this.validator = validator;
    }

    @Override
    public void startFlow() {
        userInterface.showGreeting();
        String amountOfRubles;
        String targetCurrencyCode;

        do {
            amountOfRubles = userInterface.requestAmountOfRubles();
            targetCurrencyCode = userInterface.requestTargetCurrencyType();
            CurrencyDto targetCurrencyData = userInterface.convert(amountOfRubles, targetCurrencyCode);
            userInterface.printOperationResult(targetCurrencyData);
        } while (!(amountOfRubles.equalsIgnoreCase("exit") ||
                targetCurrencyCode.equalsIgnoreCase("exit")));
    }
}
