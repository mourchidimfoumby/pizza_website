package com.mfoumby.pizzawebsitebackend.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "db")
public record DbProperties(
        String url,
        String user,
        String password
) {
}
