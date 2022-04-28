package com.andrey.currencyconverter.config.condition;

import com.andrey.currencyconverter.repo.impl.ExternalServiceCurrencyRepositoryImpl;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class ExternalServiceRepositoryInitializationCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String propertyClassValue = context.getEnvironment().getProperty("currency-repository-implementation");
        Class<ExternalServiceCurrencyRepositoryImpl> externalServiceCurrencyRepositoryClass =
                ExternalServiceCurrencyRepositoryImpl.class;
        String canonicalName = externalServiceCurrencyRepositoryClass.getCanonicalName();
        return propertyClassValue.equals(canonicalName);
    }
}
