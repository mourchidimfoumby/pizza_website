package com.mfoumby.pizzawebsitebackend.features.order.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mfoumby.pizzawebsitebackend.features.order.data.fields.PizzaOrderFields;

public record PizzaOrderModel(
        @JsonProperty(PizzaOrderFields.PIZZA_ORDER_ORDER_ID)
        Long pizzaOrderOrderId,
        @JsonProperty(PizzaOrderFields.PIZZA_ORDER_PIZZA_ID)
        Long pizzaOrderPizzaId,
        @JsonProperty(PizzaOrderFields.PIZZA_ORDER_QUANTITY)
        int pizzaOrderQuantity
) {
}
