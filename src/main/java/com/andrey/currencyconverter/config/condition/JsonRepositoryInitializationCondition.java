package com.andrey.currencyconverter.config.condition;

import com.andrey.currencyconverter.repo.impl.JsonFileCurrencyRepositoryImpl;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class JsonRepositoryInitializationCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String propertyClassValue = context.getEnvironment().getProperty("currency-repository-implementation");
        Class<JsonFileCurrencyRepositoryImpl> jsonFileCurrencyRepositoryClass =
                JsonFileCurrencyRepositoryImpl.class;
        String canonicalName = jsonFileCurrencyRepositoryClass.getCanonicalName();
        boolean equals = propertyClassValue.equals(canonicalName);
        return equals;
    }
}
