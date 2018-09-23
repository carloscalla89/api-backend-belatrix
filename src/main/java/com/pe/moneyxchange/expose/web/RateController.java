package com.pe.moneyxchange.expose.web;

import com.pe.moneyxchange.model.RateQueryParam;
import com.pe.moneyxchange.model.RateResponse;
import com.pe.moneyxchange.service.RateService;
import com.pe.moneyxchange.util.exception.CustomValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/money-exchange")
public class RateController {


  private RateService rateService;

  @Autowired
  public RateController(RateService rateService) {
    this.rateService = rateService;
  }

  @GetMapping(value="/rate")
  public ResponseEntity<RateResponse> moneyExchange(@Valid RateQueryParam quotationQueryParam,BindingResult bindingResult) throws Exception {

    if (bindingResult.hasErrors()) {
      throw new CustomValidationException(bindingResult);
    }

    RateResponse rateResponse= rateService
            .getRateValue(quotationQueryParam.getRateType(),quotationQueryParam.getAmount());

    return ResponseEntity.ok(rateResponse);
  }

}
