package com.mfoumby.pizzawebsitebackend.features.order.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mfoumby.pizzawebsitebackend.features.order.data.fields.CustomPizzaOrderFields;

public record CustomPizzaOrderModel(
        @JsonProperty(CustomPizzaOrderFields.CUSTOM_PIZZA_ORDER_ORDER_ID)
        Long customPizzaOrderId,
        @JsonProperty(CustomPizzaOrderFields.CUSTOM_PIZZA_ORDER_PIZZA_ID)
        Long customPizzaPizzaId,
        @JsonProperty(CustomPizzaOrderFields.CUSTOM_PIZZA_ORDER_INGREDIENT_ID)
        Long customPizzaIngredientId,
        @JsonProperty(CustomPizzaOrderFields.CUSTOM_PIZZA_ORDER_PERSONALIZATION_TYPE_ID)
        Long customPizzaPersonalizationTypeId,
        @JsonProperty(CustomPizzaOrderFields.CUSTOM_PIZZA_ORDER_QUANTITY)
        int customPizzaQuantity
) {
}
