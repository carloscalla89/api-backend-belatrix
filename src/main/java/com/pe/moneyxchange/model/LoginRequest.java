package com.pe.moneyxchange.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class LoginRequest {

  @NotNull(message="{loginRequest.username.NotNull}")
  private String username;

  @NotNull(message="{loginRequest.password.NotNull}")
  private String password;

}
