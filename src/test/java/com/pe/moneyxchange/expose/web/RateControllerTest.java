package com.pe.moneyxchange.expose.web;

import com.pe.moneyxchange.model.RateQueryParam;
import com.pe.moneyxchange.model.RateResponse;
import com.pe.moneyxchange.service.RateService;
import com.pe.moneyxchange.util.exception.CustomValidationException;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.beans.PropertyEditor;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RateControllerTest {

    @Mock
    private RateService rateService;

    @InjectMocks
    private RateController rateController;

    @Test
    public void moneyExchangeIsSuccess() throws Exception {
        RateQueryParam rateQueryParam = new RateQueryParam();
        rateQueryParam.setAmount("123");
        rateQueryParam.setBase("USD");
        rateQueryParam.setTarget("EUR");

       RateResponse rateResponse = RateResponse.builder()
               .setChangedAmount(123.0)
               .setRates(1.9)
               .build();

        when(rateService.getRate(anyString(),anyString(),anyString())).thenReturn(rateResponse);

        rateController = new RateController(rateService);
        rateController.moneyExchangeRate(rateQueryParam,getBindingResult(false));

    }

    @Test(expected = CustomValidationException.class)
    public void moneyExchangeIsIncorrect() throws Exception {
        RateQueryParam rateQueryParam = new RateQueryParam();
        rateQueryParam.setAmount("123");
        rateQueryParam.setBase("USssD");
        rateQueryParam.setTarget("EUR");

        RateResponse rateResponse = RateResponse.builder()
                .setChangedAmount(123.00)
                .setRates(1.9)
                .build();

        when(rateService.getRate(anyString(),anyString(),anyString())).thenReturn(rateResponse);

        rateController = new RateController(rateService);
        rateController.moneyExchangeRate(rateQueryParam,getBindingResult(true));

    }

    private BindingResult getBindingResult(boolean hasError) {

        boolean hasErrorVal = hasError;

        BindingResult bindingResult = new BindingResult() {
            @Override
            public Object getTarget() {
                return null;
            }

            @Override
            public Map<String, Object> getModel() {
                return null;
            }

            @Override
            public Object getRawFieldValue(String s) {
                return null;
            }

            @Override
            public PropertyEditor findEditor(String s, Class<?> aClass) {
                return null;
            }

            @Override
            public PropertyEditorRegistry getPropertyEditorRegistry() {
                return null;
            }

            @Override
            public String[] resolveMessageCodes(String s) {
                return new String[0];
            }

            @Override
            public String[] resolveMessageCodes(String s, String s1) {
                return new String[0];
            }

            @Override
            public void addError(ObjectError objectError) {

            }

            @Override
            public String getObjectName() {
                return null;
            }

            @Override
            public void setNestedPath(String s) {

            }

            @Override
            public String getNestedPath() {
                return null;
            }

            @Override
            public void pushNestedPath(String s) {

            }

            @Override
            public void popNestedPath() throws IllegalStateException {

            }

            @Override
            public void reject(String s) {

            }

            @Override
            public void reject(String s, String s1) {

            }

            @Override
            public void reject(String s, Object[] objects, String s1) {

            }

            @Override
            public void rejectValue(String s, String s1) {

            }

            @Override
            public void rejectValue(String s, String s1, String s2) {

            }

            @Override
            public void rejectValue(String s, String s1, Object[] objects, String s2) {

            }

            @Override
            public void addAllErrors(Errors errors) {

            }

            @Override
            public boolean hasErrors() {
                return hasErrorVal;
            }

            @Override
            public int getErrorCount() {
                return 0;
            }

            @Override
            public List<ObjectError> getAllErrors() {
                return null;
            }

            @Override
            public boolean hasGlobalErrors() {
                return false;
            }

            @Override
            public int getGlobalErrorCount() {
                return 0;
            }

            @Override
            public List<ObjectError> getGlobalErrors() {
                return null;
            }

            @Override
            public ObjectError getGlobalError() {
                return null;
            }

            @Override
            public boolean hasFieldErrors() {
                return false;
            }

            @Override
            public int getFieldErrorCount() {
                return 0;
            }

            @Override
            public List<FieldError> getFieldErrors() {
                return null;
            }

            @Override
            public FieldError getFieldError() {
                return null;
            }

            @Override
            public boolean hasFieldErrors(String s) {
                return false;
            }

            @Override
            public int getFieldErrorCount(String s) {
                return 0;
            }

            @Override
            public List<FieldError> getFieldErrors(String s) {
                return null;
            }

            @Override
            public FieldError getFieldError(String s) {
                return null;
            }

            @Override
            public Object getFieldValue(String s) {
                return null;
            }

            @Override
            public Class<?> getFieldType(String s) {
                return null;
            }
        };

        return bindingResult;
    }
}