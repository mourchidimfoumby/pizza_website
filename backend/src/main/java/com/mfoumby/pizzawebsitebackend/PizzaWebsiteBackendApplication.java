package com.mfoumby.pizzawebsitebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class PizzaWebsiteBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(PizzaWebsiteBackendApplication.class, args);
    }
}
