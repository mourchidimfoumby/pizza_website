package com.mfoumby.pizzawebsitebackend.features.order.domain.entity;

public enum PersonalizationType {
    ADD(1),
    WITHDRAWAL(2);

    private final int id;

    PersonalizationType(int id) {
        this.id = id;
    }

    public int id() {
        return id;
    }
}
