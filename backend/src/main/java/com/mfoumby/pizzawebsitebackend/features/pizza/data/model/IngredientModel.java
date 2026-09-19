package com.mfoumby.pizzawebsitebackend.features.pizza.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mfoumby.pizzawebsitebackend.features.pizza.data.fields.IngredientFields;

public record IngredientModel(
        @JsonProperty(IngredientFields.INGREDIENT_ID)
        Long ingredientId,
        @JsonProperty(IngredientFields.INGREDIENT_NAME)
        String ingredientName,
        @JsonProperty(IngredientFields.INGREDIENT_UPDATABLE)
        int ingredientUpdatable,
        @JsonProperty(IngredientFields.INGREDIENT_STOCK_ID)
        Long ingredientStockId
) {
}
