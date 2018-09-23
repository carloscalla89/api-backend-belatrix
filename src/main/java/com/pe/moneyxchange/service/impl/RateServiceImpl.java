package com.pe.moneyxchange.service.impl;

import com.pe.moneyxchange.dao.RateDao;
import com.pe.moneyxchange.factory.DaoFactory;
import com.pe.moneyxchange.model.RateResponse;
import com.pe.moneyxchange.service.RateService;
import org.springframework.stereotype.Service;

import static com.pe.moneyxchange.util.Constants.MONGO;

@Service
public class RateServiceImpl implements RateService {

    private RateDao<RateResponse> rateResponseRateDao;

    public RateServiceImpl() {
        DaoFactory factory = DaoFactory.getFactory(MONGO);
        this.rateResponseRateDao = factory.getRateDao();
    }

    @Override
    public RateResponse getRateValue(String typeRate, String amount) throws Exception {
        return rateResponseRateDao.getRate(typeRate, amount);
    }
}
