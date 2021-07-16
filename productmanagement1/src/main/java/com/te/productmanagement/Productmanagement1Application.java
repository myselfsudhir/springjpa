package com.te.productmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Productmanagement1Application {

	public static void main(String[] args) {
		SpringApplication.run(Productmanagement1Application.class, args);
	}

}
