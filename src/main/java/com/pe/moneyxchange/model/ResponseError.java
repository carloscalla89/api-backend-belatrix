package com.pe.moneyxchange.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseError {
  private String field;
  private String code;
  private Object description;

  public ResponseError(String field, String code, Object rejectedValue) {
    this.field = field;
    this.code = code;
    this.description = rejectedValue;
  }

  public ResponseError(String field, Object rejectedValue) {
    this.field = field;
    this.code = code;
    this.description = rejectedValue;
  }

  public ResponseError(Object rejectedValue) {
    this.description = rejectedValue;

  }

}
