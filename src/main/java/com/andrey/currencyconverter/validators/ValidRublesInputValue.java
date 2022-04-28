package com.andrey.currencyconverter.validators;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RublesInputValueValidator.class)
@Target({PARAMETER, METHOD})
@Documented
public @interface ValidRublesInputValue {

    String message() default
            "The rubles value should be a number and above zero.";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
