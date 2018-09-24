package com.pe.moneyxchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { MongoDataAutoConfiguration.class, MongoAutoConfiguration.class})
public class MoneyxchangeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoneyxchangeApplication.class, args);
	}
}
