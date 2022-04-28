package com.andrey.currencyconverter.validators;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


@Component
public class RublesInputValueValidator implements ConstraintValidator<ValidRublesInputValue, Double> {

    @Override
    public boolean isValid(Double rublesInputValue, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid = !rublesInputValue.isNaN() && rublesInputValue > 0;
        return isValid;
    }
}
