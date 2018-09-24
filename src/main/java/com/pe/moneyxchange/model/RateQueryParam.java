package com.pe.moneyxchange.model;

//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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

  @Pattern(regexp = "[A-Za-z]*",message="{quotationQueryParam.base.Pattern}")
  @Size(min =3,max = 3,message="{quotationQueryParam.base.Size}")
  @NotNull(message="{quotationQueryParam.base.NotNull}")
  @NotEmpty(message="{quotationQueryParam.base.NotEmpty}")
  private String base;

  @Pattern(regexp = "[A-Za-z]*",message="{quotationQueryParam.target.Pattern}")
  @Size(min =3,max = 3,message="{quotationQueryParam.target.Size}")
  @NotNull(message="{quotationQueryParam.target.NotNull}")
  @NotEmpty(message="{quotationQueryParam.target.NotEmpty}")
  private String target;

  @Override
  public String toString () {
    return ToStringBuilder.reflectionToString(this,ToStringStyle.SHORT_PREFIX_STYLE);
  }

}
