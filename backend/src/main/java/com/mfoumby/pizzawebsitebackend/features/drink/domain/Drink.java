package com.mfoumby.pizzawebsitebackend.features.drink.domain;

public record Drink(
        Long id,
        String name,
        Float price,
        Float volume,
        String imageUrl,
        Long stockId
) {
}
