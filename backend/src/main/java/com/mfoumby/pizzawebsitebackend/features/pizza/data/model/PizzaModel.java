package com.mfoumby.pizzawebsitebackend.features.pizza.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mfoumby.pizzawebsitebackend.features.pizza.data.fields.PizzaFields;

public record PizzaModel(
        @JsonProperty(PizzaFields.PIZZA_ID)
        Long pizzaId,
        @JsonProperty(PizzaFields.PIZZA_NAME)
        String pizzaName,
        @JsonProperty(PizzaFields.PIZZA_PRICE)
        Float pizzaPrice,
        @JsonProperty(PizzaFields.PIZZA_IMAGE_URL)
        String pizzaImageUrl
) {
}
