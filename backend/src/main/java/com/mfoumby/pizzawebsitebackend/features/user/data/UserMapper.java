package com.mfoumby.pizzawebsitebackend.features.user.data;

import com.mfoumby.pizzawebsitebackend.features.user.entity.CreateUserRequest;
import com.mfoumby.pizzawebsitebackend.features.user.entity.User;
import com.mfoumby.pizzawebsitebackend.features.user.entity.UserResponse;

public class UserMapper {
    private UserMapper() {}

    public static User toUser(UserModel userModel) {
        return new User(
                userModel.userId(),
                userModel.userFirstName(),
                userModel.userLastName(),
                userModel.userEmail(),
                userModel.userPassword(),
                userModel.userPhoneNumber(),
                userModel.userAddress(),
                userModel.userRoleId(),
                userModel.userDiscount() == 1
        );
    }

    public static UserResponse toUserResponse(User user) {
        return new UserResponse(
                user.id(),
                user.firstName(),
                user.lastName(),
                user.email(),
                user.phoneNumber(),
                user.address(),
                user.roleId(),
                user.discount()
        );
    }

    public static UserModel toUserModel(CreateUserRequest createUserRequest) {
        return new UserModel(
                null,
                createUserRequest.firstName(),
                createUserRequest.lastName(),
                createUserRequest.email(),
                createUserRequest.password(),
                createUserRequest.phoneNumber(),
                createUserRequest.address(),
                createUserRequest.roleId(),
                0
        );
    }
}
