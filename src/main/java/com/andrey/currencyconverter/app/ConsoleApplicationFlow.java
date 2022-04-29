package com.andrey.currencyconverter.app;

import com.andrey.currencyconverter.model.CurrencyRate;
import com.andrey.currencyconverter.model.dto.CurrencyDto;
import com.andrey.currencyconverter.repo.CurrencyRepository;
import com.andrey.currencyconverter.service.CurrencyConvertingService;
import com.andrey.currencyconverter.view.UserInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ConsoleApplicationFlow implements ApplicationFlow {

    private final UserInterface userInterface;
    private final CurrencyConvertingService currencyService;
    @Qualifier(value = "JsonFileRepository")
    private final CurrencyRepository currencyRepository;

    private double rublesQty;

    private String targetCurrencyCode;

    @Override
    public void startFlow() {
        userInterface.showGreeting();
        do {
            rublesQty = userInterface.requestAmountOfRubles();
            targetCurrencyCode = userInterface.requestTargetCurrencyType();
            try {
                CurrencyRate targetCurrencyRateInfo = (CurrencyRate)
                        currencyRepository.getByCurrencyCode(targetCurrencyCode);

                CurrencyDto convertedCurrencyData =
                        currencyService.convertCurrency(rublesQty, targetCurrencyRateInfo);

                if (convertedCurrencyData != null) {
                    userInterface.printOperationResult(convertedCurrencyData);
                } else {
                    userInterface.showErrorMessage("Required information not found!");
                }
            } catch (NoSuchElementException e) {
                userInterface.showErrorMessage(e.getMessage());
            }
        } while (true);
    }
}
