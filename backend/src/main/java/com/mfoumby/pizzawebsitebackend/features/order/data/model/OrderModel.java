package com.mfoumby.pizzawebsitebackend.features.order.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mfoumby.pizzawebsitebackend.features.order.data.fields.OrderFields;

public record OrderModel(
        @JsonProperty(OrderFields.ORDER_ID)
        Long orderId,
        @JsonProperty(OrderFields.ORDER_TOTAL_PRICE)
        Float orderTotalPrice,
        @JsonProperty(OrderFields.ORDER_DATE)
        Long orderDate,
        @JsonProperty(OrderFields.ORDER_USER_ID)
        Long orderUserId,
        @JsonProperty(OrderFields.ORDER_STATE_ID)
        int orderStateId,
        @JsonProperty(OrderFields.ORDER_PIZZAIOLO_ID)
        Long orderPizzaioloId,
        @JsonProperty(OrderFields.ORDER_DELIVERY_MAN_ID)
        Long orderDeliveryManId
) {
}
