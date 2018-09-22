package com.pe.moneyxchange.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.hibernate.validator.internal.engine.path.PathImpl;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import javax.validation.ConstraintViolation;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class ResponseRateError {
    private HttpStatus status;
    private String message;
    private List<String> errors;

    public ResponseRateError() {
        super();
    }
    public ResponseRateError(HttpStatus status, String message, List<String> errors) {
        super();
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public ResponseRateError(HttpStatus status) {
        this.status = status;
    }

    public ResponseRateError(HttpStatus status, String message, String error) {
        super();
        this.status = status;
        this.message = message;
        errors = Arrays.asList(error);
    }
}

