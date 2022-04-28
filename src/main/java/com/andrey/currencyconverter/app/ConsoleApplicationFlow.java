package com.andrey.currencyconverter.app;

import com.andrey.currencyconverter.exceptions.CurrencyCodeNotFoundException;
import com.andrey.currencyconverter.exceptions.InputCurrencyBalanceException;
import com.andrey.currencyconverter.model.CurrencyRate;
import com.andrey.currencyconverter.model.dto.CurrencyDto;
import com.andrey.currencyconverter.repo.CurrencyRepository;
import com.andrey.currencyconverter.service.CurrencyConvertingService;
import com.andrey.currencyconverter.validators.Validator;
import com.andrey.currencyconverter.view.UserInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
@RequiredArgsConstructor
public class ConsoleApplicationFlow implements ApplicationFlow {

    private final UserInterface userInterface;
    private final CurrencyConvertingService currencyService;
    private final CurrencyRepository currencyRepository;
    private final Validator validator;

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
                double rubles = Double.parseDouble(rublesQty);

                CurrencyRate targetCurrencyRateInfo = (CurrencyRate)
                        currencyRepository.getByCurrencyCode(targetCurrencyCode);

                CurrencyDto convertedCurrencyData =
                        currencyService.convertCurrency(rubles, targetCurrencyRateInfo);
                if (convertedCurrencyData != null) {
                    userInterface.printOperationResult(convertedCurrencyData);
                } else {
                    userInterface.showErrorMessage("Required information ot found!");
                }
            } catch (CurrencyCodeNotFoundException |
                    InputCurrencyBalanceException |
                    NoSuchElementException e) {
                userInterface.showErrorMessage(e.getMessage());
            }
        } while (!(rublesQty.equalsIgnoreCase("exit") ||
                targetCurrencyCode.equalsIgnoreCase("exit")));
    }
}
