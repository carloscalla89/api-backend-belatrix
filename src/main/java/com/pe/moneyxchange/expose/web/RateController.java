package com.pe.moneyxchange.expose.web;

import com.pe.moneyxchange.model.RateQueryParam;
import com.pe.moneyxchange.model.RateResponse;
import com.pe.moneyxchange.service.RateService;
import com.pe.moneyxchange.util.exception.CustomValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/money-exchange")
@Slf4j
public class RateController {


  private RateService rateService;

  @Autowired
  public RateController(RateService rateService) {
    this.rateService = rateService;
  }

  @GetMapping(value="/exchangeRate")
  public ResponseEntity<RateResponse> moneyExchangeRate(@Valid RateQueryParam quotationQueryParam,BindingResult bindingResult) throws Exception {
    log.info("quotationQueryParam:"+quotationQueryParam);
    if (bindingResult.hasErrors()) {
      throw new CustomValidationException(bindingResult);
    }

    RateResponse rateResponse= rateService
            .getRate(quotationQueryParam.getBase(),quotationQueryParam.getTarget(),quotationQueryParam.getAmount());

    return ResponseEntity.ok(rateResponse);
  }

}
