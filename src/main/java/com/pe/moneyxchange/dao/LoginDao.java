package com.pe.moneyxchange.dao;

public interface LoginDao {

  boolean login(String username, String password) throws Exception;
}
