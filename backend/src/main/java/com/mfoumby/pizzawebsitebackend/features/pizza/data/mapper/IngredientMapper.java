package com.mfoumby.pizzawebsitebackend.features.pizza.data.mapper;

import com.mfoumby.pizzawebsitebackend.features.pizza.data.model.IngredientModel;
import com.mfoumby.pizzawebsitebackend.features.pizza.domain.entity.Ingredient;

public class IngredientMapper {
    private IngredientMapper() {}

    public static Ingredient toIngredient(IngredientModel ingredientModel) {
        return new Ingredient(
                ingredientModel.ingredientId(),
                ingredientModel.ingredientName(),
                ingredientModel.ingredientUpdatable() == 1,
                ingredientModel.ingredientStockId()
        );
    }

    public static IngredientModel toIngredientModel(Ingredient ingredient) {
        return new IngredientModel(
                ingredient.ingredientId(),
                ingredient.name(),
                ingredient.updatable() ? 1 : 0,
                ingredient.stockId()
        );
    }
}
