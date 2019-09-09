package com.voidif.blogserver.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotEquals;

@RunWith(MockitoJUnitRunner.class)
public class ExchangeRateServiceTest {
    private static final String USD_CNY_KEY = "USD_CNY";
    private static final double INVALID_RATE = 0.0f;

    @Test
    public void retrieveUSDToCNYRateSucceed() {
        double rate = ExchangeRateService.getExchangeRateByCurrencyPairName(USD_CNY_KEY);
        assertNotEquals(INVALID_RATE, rate);
    }
}
