package com.example.hw2_rest_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableJpaRepositories(basePackages = "com.example.hw2_rest_api.repositories") // Adjust package if necessary
public class Hw2RestApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(Hw2RestApiApplication.class, args);
    }
}
