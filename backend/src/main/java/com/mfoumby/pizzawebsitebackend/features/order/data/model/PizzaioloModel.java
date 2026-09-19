package com.mfoumby.pizzawebsitebackend.features.order.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mfoumby.pizzawebsitebackend.features.order.data.fields.PizzaioloFields;

public record PizzaioloModel(
        @JsonProperty(PizzaioloFields.PIZZAIOLO_ID)
        Long pizzaioloId,
        @JsonProperty(PizzaioloFields.PIZZAIOLO_FIRST_NAME)
        String pizzaioloFirstName,
        @JsonProperty(PizzaioloFields.PIZZAIOLO_LAST_NAME)
        String pizzaioloLastName
) {
}
