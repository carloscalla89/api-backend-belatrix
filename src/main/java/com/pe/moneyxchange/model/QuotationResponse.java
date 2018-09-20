package com.pe.moneyxchange.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class QuotationResponse {

  @NotNull
  private String changedAmount;
}
