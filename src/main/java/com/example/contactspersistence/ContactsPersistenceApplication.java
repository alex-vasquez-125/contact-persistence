package com.example.contactspersistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = { LiquibaseAutoConfiguration.class })
@EnableTransactionManagement
//@EntityScan(bas)
public class ContactsPersistenceApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ContactsPersistenceApplication.class, args);
	}

}
