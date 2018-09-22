package com.pe.moneyxchange.expose.web;

import com.pe.moneyxchange.model.RateQueryParam;
import com.pe.moneyxchange.model.RateResponse;
import com.pe.moneyxchange.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/money-exchange")
public class RateController {

  @Autowired
  private RateService rateService;

  @GetMapping(value="/rate")
  public ResponseEntity<RateResponse> moneyExchange(RateQueryParam quotationQueryParam) throws Exception {

    RateResponse rateResponse= rateService
            .getRateValue(quotationQueryParam.getRateType(),quotationQueryParam.getAmount());

    return ResponseEntity.ok(rateResponse);
  }

}
