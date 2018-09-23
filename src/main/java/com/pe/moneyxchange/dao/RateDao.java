package com.pe.moneyxchange.dao;

public interface RateDao<T> {
    T getRate(String typeRate,String amount) throws Exception;
}
