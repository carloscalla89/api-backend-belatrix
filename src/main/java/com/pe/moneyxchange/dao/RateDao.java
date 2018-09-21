package com.pe.moneyxchange.dao;

public interface RateDao<T> {
    T getRate(String typeRate,double amount) throws Exception;
}
