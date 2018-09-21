package com.pe.moneyxchange.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RateQueryParam {

  @Pattern(regexp = "^-?\\d*\\.\\d+$")
  @NotNull
  private String amount;

  @NotNull
  private String rateType;

}
