package com.pe.moneyxchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;

@SpringBootApplication(exclude = MongoRepositoriesAutoConfiguration.class)
public class MoneyxchangeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoneyxchangeApplication.class, args);
	}
}
