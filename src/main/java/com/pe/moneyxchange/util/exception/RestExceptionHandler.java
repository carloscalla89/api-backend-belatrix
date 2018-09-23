package com.pe.moneyxchange.util.exception;

import com.pe.moneyxchange.model.ResponseError;
import com.pe.moneyxchange.model.ResponseRateError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.rmi.UnexpectedException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@Slf4j
public class RestExceptionHandler  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ResponseRateError> DataNotFoundException(
            DataNotFoundException ex) {

        ResponseRateError response = new ResponseRateError();
        response.setMessage(ex.getMessage());

        return new ResponseEntity<>(response, new HttpHeaders(),HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ResponseRateError> BadCredentialsException(
            BadCredentialsException ex) {

        ResponseRateError response = new ResponseRateError();
        response.setMessage(ex.getMessage());

        return new ResponseEntity<>(response, new HttpHeaders(),HttpStatus.UNAUTHORIZED);

    }


    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ResponseRateError> handleAllExceptions(Exception ex) {

        ResponseError responseError = new ResponseError(ex.getMessage());
        ResponseRateError errorDetails = new ResponseRateError();
        errorDetails.setMessage("Unexpected error");
        errorDetails.setErrors(Arrays.asList(responseError));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CustomValidationException.class)
    public ResponseEntity<ResponseRateError> customValidationException(
            CustomValidationException ex) {

        List<ResponseError> responseErrorList= ex.getBindingResult().getFieldErrors()
                .stream()
                .map(fieldError -> new ResponseError(
                        fieldError.getField(),
                        fieldError.getCode(),
                        fieldError.getDefaultMessage()))
                .collect(Collectors.toList());
        ResponseRateError response = new ResponseRateError();
        response.setErrors(responseErrorList);
        response.setMessage("Error in Validations");

        return new ResponseEntity<>(response, new HttpHeaders(),HttpStatus.BAD_REQUEST);

    }
}
