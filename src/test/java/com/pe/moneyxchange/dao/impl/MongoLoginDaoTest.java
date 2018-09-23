package com.pe.moneyxchange.dao.impl;

import com.pe.moneyxchange.util.exception.BadCredentialsException;
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
public class MongoLoginDaoTest {

    @InjectMocks
    MongoLoginDao mongoLoginDao;

    @Test
    public void loginSuccess() throws Exception {
        mongoLoginDao.login("carlos","1234");
    }

    @Test(expected = BadCredentialsException.class)
    public void loginError() throws Exception {
        mongoLoginDao.login("1214","1234");
    }
}