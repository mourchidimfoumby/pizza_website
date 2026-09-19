package com.mfoumby.pizzawebsitebackend.features.pizza.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mfoumby.pizzawebsitebackend.features.pizza.data.fields.PizzaAllergenFields;

public record PizzaAllergenModel(
        @JsonProperty(PizzaAllergenFields.PIZZA_ALLERGEN_ALLERGEN_ID)
        Long allergenId,
        @JsonProperty(PizzaAllergenFields.PIZZA_ALLERGEN_PIZZA_ID)
        Long pizzaId
) {
}
