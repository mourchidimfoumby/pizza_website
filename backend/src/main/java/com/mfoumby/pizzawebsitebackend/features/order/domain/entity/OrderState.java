package com.mfoumby.pizzawebsitebackend.features.order.domain.entity;

public enum OrderState {
    CONFIRMED(1),
    READY(2),
    DELIVERED(3),
    DELIVERED_LATE(4);

    private final int id;

    OrderState(int id) {
        this.id = id;
    }

    public int id() {
        return id;
    }
}