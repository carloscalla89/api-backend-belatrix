package com.pe.moneyxchange.model;

//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
@Getter
@Setter
public class RateQueryParam {


  //@Pattern(regexp = "^[-+]?[0-9]*\\.?[0-9]+$")
  @NotNull
  private Double amount;


  @NotNull
  private String rateType;

}
