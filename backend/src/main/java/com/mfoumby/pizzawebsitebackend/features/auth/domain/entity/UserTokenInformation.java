package com.mfoumby.pizzawebsitebackend.features.auth.domain.entity;

import com.mfoumby.pizzawebsitebackend.features.user.entity.UserRole;

public record UserTokenInformation(
        Long userId,
        UserRole role
) {
}
