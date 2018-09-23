package com.pe.moneyxchange.service.impl;

import com.pe.moneyxchange.dao.LoginDao;
import com.pe.moneyxchange.factory.DaoFactory;
import com.pe.moneyxchange.service.LoginService;
import com.pe.moneyxchange.util.Constants;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

  private final LoginDao loginDao;

  public LoginServiceImpl() {

    DaoFactory factory = DaoFactory.getFactory(Constants.MONGO);
    this.loginDao = factory.getLoginDao();

  }

  @Override
  public boolean isLoginValid(String username, String password) throws Exception {
    return loginDao.login(username,password);
  }
}
