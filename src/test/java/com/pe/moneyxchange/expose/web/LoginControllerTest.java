package com.pe.moneyxchange.expose.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pe.moneyxchange.model.LoginRequest;
import com.pe.moneyxchange.service.LoginService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LoginControllerTest {

    @Mock
    private LoginService loginService;

    @InjectMocks
    private LoginController loginController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void loginIsSuccess() throws Exception {
        LoginRequest request = new LoginRequest();

        request.setPassword("carlos");
        request.setUsername("1234");

        when(loginService.isLoginValid(anyString(),anyString())).thenReturn(true);

        loginController = new LoginController(loginService);
        loginController.login(request);
    }

    @Test
    public void loginIsIncorrect() throws Exception {
        LoginRequest request = new LoginRequest();

        request.setPassword("carlos");
        request.setUsername("12345");

        when(loginService.isLoginValid(anyString(),anyString())).thenReturn(false);

        loginController = new LoginController(loginService);
        loginController.login(request);
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}