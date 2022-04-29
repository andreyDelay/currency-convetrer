package com.andrey.currencyconverter.validators;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class RublesInputValueValidator implements ConstraintValidator<ValidRublesInputValue, Double> {

    @Override
    public void initialize(ValidRublesInputValue constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Double aDouble, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
