package com.mfoumby.pizzawebsitebackend.features.auth.data;

import com.mfoumby.pizzawebsitebackend.features.auth.domain.entity.RefreshToken;
import com.mfoumby.pizzawebsitebackend.shared.DbManager;
import com.mfoumby.pizzawebsitebackend.shared.ResultUtils;
import org.springframework.stereotype.Repository;
import tools.jackson.core.type.TypeReference;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class RefreshTokenRepository {
    private final DbManager dbManager;

    public RefreshTokenRepository(DbManager dbManager) {
        this.dbManager = dbManager;
    }

    public RefreshToken getRefreshTokenFromUserId(Long userId) throws SQLException {
        String query = String.format(
                "SELECT * FROM %s WHERE %s = ?",
                RefreshTokenFields.TABLE_NAME,
                RefreshTokenFields.USER_ID
        );
        try (
                Connection connection = dbManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)
        ) {
            statement.setLong(1, userId);
            ResultSet result = statement.executeQuery();
            RefreshTokenModel refreshTokenModel = ResultUtils.getJson(result, new TypeReference<RefreshTokenModel>() {});
            result.close();
            return RefreshTokenMapper.toRefreshToken(refreshTokenModel);
        }
    }

    public RefreshToken getRefreshTokenFromToken(String token) throws SQLException {
        String query = String.format(
                "SELECT * FROM %s WHERE %s = ?",
                RefreshTokenFields.TABLE_NAME,
                RefreshTokenFields.REFRESH_TOKEN_HASH
        );
        try (
                Connection connection = dbManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)
        ) {
            statement.setString(1, token);
            ResultSet result = statement.executeQuery();
            RefreshTokenModel refreshTokenModel = ResultUtils.getJson(result, new TypeReference<RefreshTokenModel>() {});
            result.close();
            return RefreshTokenMapper.toRefreshToken(refreshTokenModel);
        }
    }

    public void upsertRefreshToken(RefreshToken refreshToken) throws SQLException {
        String query = String.format(
                "INSERT INTO %s (%s, %s, %s, %s) " +
                        "VALUES (?, ?, ?, ?) " +
                        "ON CONFLICT (%s) " +
                        "DO UPDATE SET " +
                        "%s = ?, " +
                        "%s = ?, " +
                        "%s = ? " +
                        "WHERE %s = ?",
                RefreshTokenFields.TABLE_NAME,
                RefreshTokenFields.REFRESH_TOKEN_ID,
                RefreshTokenFields.USER_ID,
                RefreshTokenFields.REFRESH_TOKEN_HASH,
                RefreshTokenFields.REFRESH_TOKEN_EXPIRES_AT,
                RefreshTokenFields.USER_ID,
                RefreshTokenFields.REFRESH_TOKEN_ID,
                RefreshTokenFields.REFRESH_TOKEN_HASH,
                RefreshTokenFields.REFRESH_TOKEN_EXPIRES_AT,
                RefreshTokenFields.USER_ID
        );

        try (
                Connection connection = dbManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)
        ) {
            RefreshTokenModel refreshTokenModel = RefreshTokenMapper.toRefreshTokenModel(refreshToken);
            statement.setString(1, refreshTokenModel.refreshTokenId());
            statement.setLong(2, refreshTokenModel.userId());
            statement.setString(3, refreshTokenModel.refreshTokenHash());
            statement.setString(4, refreshTokenModel.refreshTokenExpiresAt());

            statement.setString(5, refreshTokenModel.refreshTokenId());
            statement.setString(6, refreshTokenModel.refreshTokenHash());
            statement.setString(7, refreshTokenModel.refreshTokenExpiresAt());
            statement.setLong(8, refreshTokenModel.userId());

            statement.executeUpdate();
        }
    }
}
