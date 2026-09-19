package com.mfoumby.pizzawebsitebackend.features.user.entity;

public record User(
        Long id,
        String firstName,
        String lastName,
        String email,
        String password,
        String phoneNumber,
        String address,
        int roleId,
        boolean discount
) {
}
