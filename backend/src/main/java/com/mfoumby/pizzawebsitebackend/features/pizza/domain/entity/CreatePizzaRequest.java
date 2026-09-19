package com.mfoumby.pizzawebsitebackend.features.pizza.domain.entity;

import java.util.List;

public record CreatePizzaRequest(
        Long pizzaId,
        String name,
        Float price,
        String imageUrl,
        List<PizzaIngredient> pizzaIngredients,
        List<Allergen> allergens
) {
}
