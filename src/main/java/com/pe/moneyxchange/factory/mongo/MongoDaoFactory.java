package com.pe.moneyxchange.factory.mongo;

import com.pe.moneyxchange.dao.LoginDao;
import com.pe.moneyxchange.dao.RateDao;
import com.pe.moneyxchange.dao.impl.MongoLoginDao;
import com.pe.moneyxchange.dao.impl.MongoRateDaoImpl;
import com.pe.moneyxchange.factory.DaoFactory;


public class MongoDaoFactory extends DaoFactory {

  public static MongoConnection createConnection() throws Exception {

    MongoConnection connection;

    try {
      connection = MongoConnection.getInstance();
    } catch (Exception e) {
      throw new Exception("An error occoured when connecting to MongoDB");
    }
    return connection;
  }


  @Override
  public RateDao getRateDao() {
    return new MongoRateDaoImpl();
  }

  @Override
  public LoginDao getLoginDao() {
    return new MongoLoginDao();
  }
}
