package com.voidif.blogserver.controller;

import com.voidif.blogserver.model.ExchangeRate;
import com.voidif.blogserver.service.ExchangeRateService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeRateController {
    @RequestMapping("/api/rate")
    public ExchangeRate getExchangeRate(@RequestParam String currencyPairName) {
        double rate = ExchangeRateService.getExchangeRateByCurrencyPairName(currencyPairName);
        return new ExchangeRate(currencyPairName, rate);
    }
}
