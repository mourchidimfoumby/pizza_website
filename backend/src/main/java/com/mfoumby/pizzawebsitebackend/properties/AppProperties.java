package com.mfoumby.pizzawebsitebackend.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app")
public record AppProperties(
        String environment,
        String frontendUrl
) {
}
