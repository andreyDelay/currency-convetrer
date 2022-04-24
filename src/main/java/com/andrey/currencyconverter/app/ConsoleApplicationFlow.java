package com.andrey.currencyconverter.app;

import com.andrey.currencyconverter.exceptions.CurrencyCodeNotFoundException;
import com.andrey.currencyconverter.exceptions.InputCurrencyBalanceException;
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
        String rublesQty;
        String targetCurrencyCode;

        do {
            rublesQty = userInterface.requestAmountOfRubles();
            targetCurrencyCode = userInterface.requestTargetCurrencyType();
            try {
                validator.validateParameters(rublesQty, targetCurrencyCode);
            } catch (CurrencyCodeNotFoundException e) {
                userInterface.showErrorMessage(e.getMessage());
            } catch (InputCurrencyBalanceException e) {
                userInterface.showErrorMessage(e.getMessage());
            }

            CurrencyDto targetCurrencyData = userInterface.convert(rublesQty, targetCurrencyCode);
            if (targetCurrencyData != null) {
                userInterface.printOperationResult(targetCurrencyData);
            }
        } while (!(rublesQty.equalsIgnoreCase("exit") ||
                targetCurrencyCode.equalsIgnoreCase("exit")));
    }
}
