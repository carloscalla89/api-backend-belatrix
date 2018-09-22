package com.pe.moneyxchange.util.exception;

import com.mongodb.MongoException;
import com.pe.moneyxchange.model.ResponseError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

  @ExceptionHandler(DataNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ResponseBody
  public ResponseError getResponseErrorDataNotFound(DataNotFoundException ex) {
    return buildResponseError(ex.getMessage());
  }

  @ExceptionHandler(MongoException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ResponseBody
  public ResponseError getResponseConecctionError(MongoException ex) {
    return buildResponseError(ex.getMessage());
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ResponseBody
  public ResponseError getResponseGeneralError(Exception ex) {
    return buildResponseError(ex.getMessage());
  }

  private  ResponseError buildResponseError(String message) {
    ResponseError error = new ResponseError();
    error.setErrorMessage(message);
    return error;
  }
}
