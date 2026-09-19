package com.mfoumby.pizzawebsitebackend.features.auth.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RefreshTokenModel(
        @JsonProperty(RefreshTokenFields.REFRESH_TOKEN_ID)
        String refreshTokenId,
        @JsonProperty(RefreshTokenFields.USER_ID)
        Long userId,
        @JsonProperty(RefreshTokenFields.REFRESH_TOKEN_HASH)
        String refreshTokenHash,
        @JsonProperty(RefreshTokenFields.REFRESH_TOKEN_EXPIRES_AT)
        String refreshTokenExpiresAt
) {
}
