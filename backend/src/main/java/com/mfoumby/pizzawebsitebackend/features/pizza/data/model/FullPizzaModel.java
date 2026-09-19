package com.mfoumby.pizzawebsitebackend.features.pizza.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mfoumby.pizzawebsitebackend.features.pizza.data.fields.AllergenFields;
import com.mfoumby.pizzawebsitebackend.features.pizza.data.fields.IngredientFields;
import com.mfoumby.pizzawebsitebackend.features.pizza.data.fields.PizzaFields;

import java.util.List;

public record FullPizzaModel(
        @JsonProperty(PizzaFields.TABLE_NAME)
        PizzaModel pizzaModel,
        @JsonProperty(IngredientFields.TABLE_NAME)
        List<IngredientModel> ingredientModels,
        @JsonProperty(AllergenFields.TABLE_NAME)
        List<AllergenModel> allergenModels
) {
}
