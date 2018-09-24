package com.pe.moneyxchange.dao;

public interface RateDao<T> {
    T getRate(String base,String target,String amount) throws Exception;
}
