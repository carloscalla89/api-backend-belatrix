package com.pe.moneyxchange.expose.web;

import com.pe.moneyxchange.model.RateQueryParam;
import com.pe.moneyxchange.model.RateResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/money-exchange")
public class RateController {



  public RateController() {

  }

  @GetMapping(value="/quotation")
  public ResponseEntity<RateResponse> moneyExchange(RateQueryParam quotationQueryParam){
    return null;
  }

}
