package com.example.hw2_rest_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.vaadin.flow.spring.annotation.EnableVaadin;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.hw2_rest_api.repositories") // Adjust package if necessary
@EnableVaadin("com.example.hw2_vaadin.views")
public class Hw2RestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Hw2RestApiApplication.class, args);
	}

}
