package com.mfoumby.pizzawebsitebackend.features.order.domain.entity;

public record CustomPizzaOrder(
        Long pizzaId,
        Long ingredientId,
        Long orderId,
        int quantity,
        Long personalizationTypeId
) {
}
