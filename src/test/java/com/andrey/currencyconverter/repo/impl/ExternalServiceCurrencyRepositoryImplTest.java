package com.andrey.currencyconverter.repo.impl;

import com.andrey.currencyconverter.model.CurrencyRate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;

class ExternalServiceCurrencyRepositoryImplTest {

    @Mock
    private ExternalServiceCurrencyRepositoryImpl mockRepository;
    private AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void shouldReturnCurrencyRateByCurrencyCode() {
        //given
        double zero = 0.0;
        double expectedRate = 72.7089;
        CurrencyRate currencyRate = new CurrencyRate();
        currencyRate.setRate(expectedRate);
        currencyRate.setCharCode("GBP");

        //when
        Mockito.when(mockRepository.getByCurrencyCode(anyString()))
                .thenReturn(currencyRate);
        //then
        CurrencyRate expected = mockRepository.getByCurrencyCode(anyString());
        assertThat(expected.getRate(), is(equalTo(expectedRate)));
        assertThat(expected.getRate(), is(greaterThan(zero)));
    }

    @Test
    void shouldThrowUnsupportedOperationException() {
        //given
        UnsupportedOperationException exception =
                new UnsupportedOperationException();
        //when
        Mockito.when(mockRepository.getAll()).thenThrow(exception);
        //then
        assertThrows(UnsupportedOperationException.class, () -> mockRepository.getAll());
    }
}