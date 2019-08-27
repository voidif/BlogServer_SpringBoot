package com.voidif.blogserver.tool;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(MockitoJUnitRunner.class)
public class ExchangeRateToolTest {
    private static final String USD_CNY_KEY = "USD_CNY";
    private static final float INVALID_RATE = 0.0f;

    @Test
    public void retrieveUSDToCNYRateSucceed() {
        float rate = ExchangeRateTool.getExchangeRateByCurrencyPairName(USD_CNY_KEY);
        assertNotEquals(INVALID_RATE, rate);
    }
}
