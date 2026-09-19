package com.mfoumby.pizzawebsitebackend.features.auth.domain.entity;

import com.mfoumby.pizzawebsitebackend.features.user.entity.UserResponse;

public record LoginResponse(
        UserResponse user,
        OAuthToken oAuthToken
) {
}
