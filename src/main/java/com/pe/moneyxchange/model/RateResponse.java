package com.pe.moneyxchange.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Map;

public class RateResponse {


  private Double changedAmount;
  private Double rates;

  private RateResponse(Double changedAmount, Double rates) {
    this.changedAmount = changedAmount;
    this.rates = rates;
  }

  public Double getChangedAmount(){
    return changedAmount;
  }

  public Double getRates() {
    return rates;
  }

  public static RateResponseBuilder builder() {
    return new RateResponseBuilder();
  }

  public static class RateResponseBuilder{
    private Double changedAmount;
    private Double rates;

    public RateResponseBuilder setChangedAmount(Double changedAmount) {
      this.changedAmount = changedAmount;
      return this;
    }

    public RateResponseBuilder setRates(Double rates) {
      this.rates = rates;
      return this;
    }



    public RateResponse build() {
      return new RateResponse(changedAmount,rates);
    }
  }
}
