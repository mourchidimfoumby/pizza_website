package com.mfoumby.pizzawebsitebackend.features.user.data;

import com.mfoumby.pizzawebsitebackend.features.user.entity.CreateUserRequest;
import com.mfoumby.pizzawebsitebackend.features.user.entity.User;
import com.mfoumby.pizzawebsitebackend.shared.DbManager;
import com.mfoumby.pizzawebsitebackend.shared.ResultUtils;
import jakarta.annotation.Nullable;
import org.springframework.stereotype.Repository;
import tools.jackson.core.JacksonException;
import tools.jackson.core.type.TypeReference;

import java.sql.*;

@Repository
public class UserRepository {
    private final DbManager dbManager;

    public UserRepository(DbManager dbManager) {
        this.dbManager = dbManager;
    }

    @Nullable
    public User getUserFromId(Long userId) throws SQLException {
        String query = String.format(
                "SELECT * FROM %s WHERE %s = ?",
                UserFields.TABLE_NAME,
                UserFields.USER_ID
        );
        try (
                Connection connection = dbManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)
        ) {
            statement.setLong(1, userId);
            ResultSet result = statement.executeQuery();
            UserModel userModel = ResultUtils.getJson(result, new TypeReference<UserModel>() {});
            result.close();
            return UserMapper.toUser(userModel);
        } catch (JacksonException e) {
            return null;
        }
    }

    @Nullable
    public User getUserFromEmail(String email) throws  Exception {
        String query = String.format(
                "SELECT * FROM %s WHERE %s = ?",
                UserFields.TABLE_NAME,
                UserFields.USER_EMAIL
        );
        try (
                Connection connection = dbManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)
        ) {
            statement.setString(1, email);
            ResultSet result = statement.executeQuery();
            UserModel userModel = ResultUtils.getJson(result, new TypeReference<UserModel>() {});
            result.close();
            return UserMapper.toUser(userModel);
        } catch (JacksonException e) {
            return null;
        }
    }

    public Long createUser(CreateUserRequest createUserRequest) throws SQLException {
        String query = String.format(
                "INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s)" +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)" +
                        "RETURNING %s",
                UserFields.TABLE_NAME,
                UserFields.USER_FIRST_NAME,
                UserFields.USER_LAST_NAME,
                UserFields.USER_EMAIL,
                UserFields.USER_PASSWORD,
                UserFields.USER_PHONE_NUMBER,
                UserFields.USER_ADDRESS,
                UserFields.USER_ROLE_ID,
                UserFields.USER_ID
        );
        try (
                Connection connection = dbManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)
        ) {
            Long userId = null;
            UserModel userModel = UserMapper.toUserModel(createUserRequest);
            statement.setString(1, userModel.userFirstName());
            statement.setString(2, userModel.userLastName());
            statement.setString(3, userModel.userEmail());
            statement.setString(4, userModel.userPassword());
            statement.setString(5, userModel.userPhoneNumber());
            statement.setString(6, userModel.userAddress());
            statement.setInt(7, userModel.userRoleId());
            statement.executeUpdate();
            ResultSet result = statement.getGeneratedKeys();
            if (result.next()) {
                userId = result.getLong(1);
            }
            return userId;
        }
    }
}
