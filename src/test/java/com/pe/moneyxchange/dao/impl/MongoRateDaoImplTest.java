package com.pe.moneyxchange.dao.impl;

import com.pe.moneyxchange.model.RateResponse;
import com.pe.moneyxchange.util.exception.DataNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MongoRateDaoImplTest {

    @InjectMocks
    MongoRateDaoImpl mongoRateDao;

    @Test
    public void getRateResponseOk() throws Exception{
        mongoRateDao.getRate("USD","EUR", "123");
    }

    @Test(expected = DataNotFoundException.class)
    public void getRateResponseException() throws Exception{
        mongoRateDao.getRate("ERT","EUR", "123");
    }
}