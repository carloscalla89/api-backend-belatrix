package com.pe.moneyxchange.expose.web;

import com.pe.moneyxchange.model.LoginRequest;
import com.pe.moneyxchange.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/money-exchange")
public class LoginController {

  private final LoginService loginService;

  @Autowired
  public LoginController(LoginService loginService) {
    this.loginService = loginService;
  }


  @PostMapping("/login")
  public ResponseEntity<Void> login(@RequestBody LoginRequest loginRequest) throws Exception {

    if (loginService.isLoginValid(loginRequest.getUsername(),
      loginRequest.getPassword())) {
      return ResponseEntity.accepted().build();
    } else {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

  }

}
