package com.mfoumby.pizzawebsitebackend.features.user.entity;

public record UserResponse(
        Long userId,
        String firstName,
        String lastName,
        String email,
        String phoneNumber,
        String address,
        int role,
        boolean discount
) {
}
