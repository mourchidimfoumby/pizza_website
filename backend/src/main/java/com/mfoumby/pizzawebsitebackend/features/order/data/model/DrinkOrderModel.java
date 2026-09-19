package com.mfoumby.pizzawebsitebackend.features.order.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mfoumby.pizzawebsitebackend.features.order.data.fields.DrinkOrderFields;

public record DrinkOrderModel(
        @JsonProperty(DrinkOrderFields.DRINK_ORDER_ORDER_ID)
        Long drinkOderOrderId,
        @JsonProperty(DrinkOrderFields.DRINK_ORDER_DRINK_ID)
        Long drinkOrderDrinkId,
        @JsonProperty(DrinkOrderFields.DRINK_ORDER_QUANTITY)
        int drinkOrderQuantity
) {
}