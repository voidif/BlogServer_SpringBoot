package com.voidif.blogserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExchangeRate {
    private String currencyPairName;
    private float rate;
}
