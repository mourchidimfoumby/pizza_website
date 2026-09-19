package com.mfoumby.pizzawebsitebackend.features.auth.data;

public interface RefreshTokenFields {
    String TABLE_NAME = "refresh_token";
    String REFRESH_TOKEN_ID = "refresh_token_id";
    String USER_ID = "user_id";
    String REFRESH_TOKEN_HASH = "refresh_token_hash";
    String REFRESH_TOKEN_EXPIRES_AT = "refresh_token_expires_at";
}
