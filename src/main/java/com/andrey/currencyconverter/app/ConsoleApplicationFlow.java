package com.andrey.currencyconverter.app;

import com.andrey.currencyconverter.dto.CurrencyDto;
import com.andrey.currencyconverter.dto.TokenMoneyDto;
import com.andrey.currencyconverter.exceptions.InputCurrencyDataException;
import com.andrey.currencyconverter.model.CurrencyRate;
import com.andrey.currencyconverter.repo.CurrencyRepository;
import com.andrey.currencyconverter.service.CurrencyConvertingService;
import com.andrey.currencyconverter.view.UserInterface;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ConsoleApplicationFlow implements ApplicationFlow {

    private final Validator validator;
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
            try {
                rublesQty = userInterface.requestAmountOfRubles();
                targetCurrencyCode = userInterface.requestTargetCurrencyType();
                TokenMoneyDto tokenMoneyDto = new TokenMoneyDto();
                tokenMoneyDto.setRublesQty(rublesQty);
                tokenMoneyDto.setTargetCurrencyCode(targetCurrencyCode);

                Set<ConstraintViolation<TokenMoneyDto>> validatedData = validator.validate(tokenMoneyDto);
                if (!validatedData.isEmpty()) {
                    throw new InputCurrencyDataException(
                            String.format("Wrong input info, please check rubles quantity - %s, or currency code - %s",
                                    tokenMoneyDto.getRublesQty(), tokenMoneyDto.getTargetCurrencyCode()));
                }

                CurrencyRate targetCurrencyRateInfo = (CurrencyRate)
                        currencyRepository.getByCurrencyCode(targetCurrencyCode);

                CurrencyDto convertedCurrencyData =
                        currencyService.convertCurrency(rublesQty, targetCurrencyRateInfo);

                if (convertedCurrencyData != null) {
                    userInterface.printOperationResult(convertedCurrencyData);
                } else {
                    userInterface.showErrorMessage("Required information not found!");
                }
            } catch (NoSuchElementException | InputCurrencyDataException e) {
                userInterface.showErrorMessage(e.getMessage());
            }
        } while (true);
    }

}
