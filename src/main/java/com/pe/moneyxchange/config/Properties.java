package com.pe.moneyxchange.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Properties {

    @Value("${money-exchange.mongo.hosts}")
    private String host;

    @Value("${money-exchange.mongo.databaseName}")
    private String databaseName;

    @Value("${money-exchange.mongo.collection}")
    private String collection;
}
