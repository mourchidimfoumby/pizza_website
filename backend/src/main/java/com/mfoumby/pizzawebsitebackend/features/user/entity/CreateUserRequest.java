package com.mfoumby.pizzawebsitebackend.features.user.entity;

public record CreateUserRequest(
        String firstName,
        String lastName,
        String email,
        String password,
        String phoneNumber,
        String address
) {
    public int roleId() {
        return UserRole.USER.id();
    }
}
