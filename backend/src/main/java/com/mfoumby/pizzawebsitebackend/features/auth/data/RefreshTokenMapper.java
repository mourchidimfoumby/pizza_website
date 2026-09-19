package com.mfoumby.pizzawebsitebackend.features.auth.data;

import com.mfoumby.pizzawebsitebackend.features.auth.domain.entity.RefreshToken;

import java.time.Instant;

public class RefreshTokenMapper {
    private RefreshTokenMapper() {}

    public static RefreshToken toRefreshToken(RefreshTokenModel refreshTokenModel) {
        return new RefreshToken(
                refreshTokenModel.refreshTokenId(),
                refreshTokenModel.userId(),
                refreshTokenModel.refreshTokenHash(),
                Instant.parse(refreshTokenModel.refreshTokenExpiresAt())
        );
    }

    public static RefreshTokenModel toRefreshTokenModel(RefreshToken refreshToken) {
        return new RefreshTokenModel(
                refreshToken.id(),
                refreshToken.userId(),
                refreshToken.tokenHash(),
                refreshToken.expiresAt().toString()
        );
    }
}
