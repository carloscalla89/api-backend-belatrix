package com.pe.moneyxchange.model;

//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
@Getter
@Setter

public class RateQueryParam {


  @Pattern(regexp = "^$?\\-?([1-9]{1}[0-9]{0,2}(,\\d{3})*(\\.\\d{0,2})?|[1-9]{1}\\d{0,}(\\.\\d{0,2})?" +
          "|0(\\.\\d{0,2})?|(\\.\\d{1,2}))$|^\\-?$?([1-9]{1}\\d{0,2}(\\,\\d{3})*(\\.\\d{0,2})?|[1-9]{1}\\d{0,}" +
          "(\\.\\d{0,2})?|0(\\.\\d{0,2})?|(\\.\\d{1,2}))$|^\\($?([1-9]{1}\\d{0,2}(\\,\\d{3})*(\\.\\d{0,2})?|[1-9]{1}\\d{0,}" +
          "(\\.\\d{0,2})?|0(\\.\\d{0,2})?|(\\.\\d{1,2}))\\)$",message ="{quotationQueryParam.amount.Pattern}")
  @NotNull(message="{quotationQueryParam.amount.NotNull}")
  @NotEmpty(message="{quotationQueryParam.amount.NotEmpty}")
  private String amount;

  @Pattern(regexp ="USD-EU",message="{quotationQueryParam.rateType.Pattern}")
  @NotNull(message="{quotationQueryParam.rateType.NotNull}")
  @NotEmpty(message="{quotationQueryParam.rateType.NotEmpty}")
  private String rateType;

}
