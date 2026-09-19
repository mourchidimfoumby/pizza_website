package com.mfoumby.pizzawebsitebackend.features.auth.domain.entity;

import java.time.Instant;

public record RefreshToken(
        String id,
        Long userId,
        String tokenHash,
        Instant expiresAt
) {
}
