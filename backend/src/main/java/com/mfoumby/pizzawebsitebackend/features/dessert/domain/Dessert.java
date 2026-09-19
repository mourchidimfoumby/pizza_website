package com.mfoumby.pizzawebsitebackend.features.dessert.domain;

public record Dessert(
        Long id,
        String name,
        Float price,
        String imageUrl,
        Long stockId
) {
}
