package com.mfoumby.pizzawebsitebackend.features.order.domain.entity;

public record Pizzaiolo(
        Long pizzaioloId,
        String firstName,
        String lastName
) {
}
