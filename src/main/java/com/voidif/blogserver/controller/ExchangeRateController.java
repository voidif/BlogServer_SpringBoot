package com.voidif.blogserver.controller;

import com.voidif.blogserver.model.ExchangeRate;
import com.voidif.blogserver.tool.ExchangeRateTool;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeRateController {
    public ExchangeRate getExchangeRate(@RequestParam String currencyPairName) {
        float rate = ExchangeRateTool.getExchangeRateByCurrencyPairName(currencyPairName);
        return new ExchangeRate(currencyPairName, rate);
    }
}
