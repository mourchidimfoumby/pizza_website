package com.mfoumby.pizzawebsitebackend.features.pizza.domain.entity;

public record Ingredient(
        Long ingredientId,
        String name,
        boolean updatable,
        Long stockId
) {
}