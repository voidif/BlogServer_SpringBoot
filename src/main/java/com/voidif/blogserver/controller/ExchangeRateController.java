package com.voidif.blogserver.controller;

import com.voidif.blogserver.model.ExchangeRate;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeRateController {
    public ExchangeRate getExchangeRate(@RequestParam String currencyPairName) {
        return null;
    }
}
