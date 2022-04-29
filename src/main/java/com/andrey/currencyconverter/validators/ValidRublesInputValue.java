package com.andrey.currencyconverter.validators;


import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = {RublesInputValueValidator.class}) //RublesInputValueValidator.class
@Documented
@ReportAsSingleViolation
public @interface ValidRublesInputValue {

    String message() default
            "The rubles value should be a number and above zero.";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
