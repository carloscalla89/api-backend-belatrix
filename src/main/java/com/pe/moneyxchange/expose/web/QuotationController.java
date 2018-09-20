package com.pe.moneyxchange.expose.web;

import com.pe.moneyxchange.model.QuotationQueryParam;
import com.pe.moneyxchange.model.QuotationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/money-exchange")
public class QuotationController {


  public QuotationController() {

  }

  @GetMapping(value="/quotation")
  public ResponseEntity<QuotationResponse> moneyExchange(QuotationQueryParam quotationQueryParam){
    return null;
  }

}
