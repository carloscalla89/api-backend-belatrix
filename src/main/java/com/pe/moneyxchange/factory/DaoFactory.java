package com.pe.moneyxchange.factory;

import com.pe.moneyxchange.dao.LoginDao;
import com.pe.moneyxchange.dao.RateDao;
import com.pe.moneyxchange.factory.mongo.MongoDaoFactory;
import com.pe.moneyxchange.util.Constants;

public abstract class DaoFactory {

    public abstract RateDao getRateDao();
    public abstract LoginDao getLoginDao();

    public static DaoFactory getFactory(int typeDB) {

        switch (typeDB) {
            case Constants.MONGO:
                return new MongoDaoFactory();
            default:
                return new MongoDaoFactory();

        }

    }
}
