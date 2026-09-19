package com.mfoumby.pizzawebsitebackend.features.pizza.data.mapper;

import com.mfoumby.pizzawebsitebackend.features.pizza.data.model.PizzaIngredientModel;
import com.mfoumby.pizzawebsitebackend.features.pizza.domain.entity.PizzaIngredient;

public class PizzaIngredientMapper {
    private PizzaIngredientMapper() {}

    public static PizzaIngredientModel toPizzaIngredientModel(Long pizzaId, PizzaIngredient pizzaIngredient) {
        return new PizzaIngredientModel(
                pizzaId,
                pizzaIngredient.ingredientId(),
                pizzaIngredient.quantity()
        );
    }
}
