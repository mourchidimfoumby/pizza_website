package com.mfoumby.pizzawebsitebackend.features.stock.domain.entity;

public record Stock(
        Long stockId,
        String name,
        int quantity,
        int threshold,
        Long managerId
) {
}
