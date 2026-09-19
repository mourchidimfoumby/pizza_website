package com.mfoumby.pizzawebsitebackend.features.order.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mfoumby.pizzawebsitebackend.features.order.data.fields.DessertOrderFields;

public record DessertOrderModel(
        @JsonProperty(DessertOrderFields.DESSERT_ORDER_ORDER_ID)
        Long dessertOrderOrderId,
        @JsonProperty(DessertOrderFields.DESSERT_ORDER_DESSERT_ID)
        Long dessertOrderDessertId,
        @JsonProperty(DessertOrderFields.DESSERT_ORDER_QUANTITY)
        int dessertOrderQuantity
) {
}
