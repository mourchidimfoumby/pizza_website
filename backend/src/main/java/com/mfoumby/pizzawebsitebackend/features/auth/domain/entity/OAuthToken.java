package com.mfoumby.pizzawebsitebackend.features.auth.domain.entity;

public record OAuthToken(
        String accessToken,
        String tokenType,
        Long expiresIn
) {
}
