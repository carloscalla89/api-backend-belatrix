package com.pe.moneyxchange.service;

import com.pe.moneyxchange.model.RateResponse;

public interface RateService {
    RateResponse getRateValue(String typeRate,String amount) throws Exception;
}
