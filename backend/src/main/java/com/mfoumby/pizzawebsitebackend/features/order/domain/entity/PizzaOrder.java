package com.mfoumby.pizzawebsitebackend.features.order.domain.entity;

public record PizzaOrder(
        Long pizzaId,
        int quantity
) {
}
