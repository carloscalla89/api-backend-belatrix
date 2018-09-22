package com.pe.moneyxchange.util;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomValidRateQueryParam implements ConstraintValidator<RateQueryParam, RateQueryParam> {
    @Override
    public void initialize(RateQueryParam constraintAnnotation) {

    }

    @Override
    public boolean isValid(RateQueryParam rateQueryParam, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }


}
