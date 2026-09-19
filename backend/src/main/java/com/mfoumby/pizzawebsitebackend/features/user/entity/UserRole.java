package com.mfoumby.pizzawebsitebackend.features.user.entity;

public enum UserRole {
    USER(1),
    ADMIN(2);

    private final int id;

    UserRole(int id) {
        this.id = id;
    }

    public int id() {
        return id;
    }

    public static UserRole fromId(int id) {
        for (UserRole role : values()) {
            if (role.id == id) {
                return role;
            }
        }
        return null;
    }
}
