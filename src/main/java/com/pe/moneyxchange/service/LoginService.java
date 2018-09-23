package com.pe.moneyxchange.service;

public interface LoginService {

  boolean isLoginValid(String username, String password) throws Exception;
}
