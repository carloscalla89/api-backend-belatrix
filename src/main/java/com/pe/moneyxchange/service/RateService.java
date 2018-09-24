package com.pe.moneyxchange.service;

import com.pe.moneyxchange.model.RateResponse;

public interface RateService {
    RateResponse getRate(String base, String target, String amount) throws Exception;
}
