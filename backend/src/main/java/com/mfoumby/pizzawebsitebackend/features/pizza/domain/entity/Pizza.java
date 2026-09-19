package com.mfoumby.pizzawebsitebackend.features.pizza.domain.entity;

import java.util.List;

public record Pizza(
        Long id,
        String name,
        Float price,
        String imageUrl,
        List<Ingredient> ingredients,
        List<Allergen> allergens
) {
}
