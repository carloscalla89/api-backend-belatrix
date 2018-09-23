package com.pe.moneyxchange.util.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.core.MethodParameter;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

@Getter
@Setter
public class CustomValidationException extends Exception {

    private BindingResult bindingResult;

    public CustomValidationException(BindingResult bindingResult) {
        this.bindingResult = bindingResult;
    }

}
