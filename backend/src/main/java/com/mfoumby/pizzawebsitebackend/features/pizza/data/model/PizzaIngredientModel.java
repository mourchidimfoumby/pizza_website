package com.mfoumby.pizzawebsitebackend.features.pizza.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mfoumby.pizzawebsitebackend.features.pizza.data.fields.PizzaIngredientFields;

public record PizzaIngredientModel(
        @JsonProperty(PizzaIngredientFields.PIZZA_INGREDIENT_PIZZA_ID)
        Long pizzaId,
        @JsonProperty(PizzaIngredientFields.PIZZA_INGREDIENT_INGREDIENT_ID)
        Long ingredientId,
        @JsonProperty(PizzaIngredientFields.PIZZA_INGREDIENT_QUANTITY)
        Float pizzaIngredientQuantity
) {
}
