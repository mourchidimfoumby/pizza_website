package com.mfoumby.pizzawebsitebackend.features.auth.domain.entity;

public record RegisterResponse(
        Long userId,
        OAuthToken oAuthToken
) {
}
