package com.mfoumby.pizzawebsitebackend.features.order.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mfoumby.pizzawebsitebackend.features.order.data.fields.DeliveryManFields;

public record DeliveryManModel(
        @JsonProperty(DeliveryManFields.DELIVERY_MAN_ID)
        Long deliveryManId,
        @JsonProperty(DeliveryManFields.DELIVERY_MAN_FIRST_NAME)
        String deliveryManFirstName,
        @JsonProperty(DeliveryManFields.DELIVERY_MAN_LAST_NAME)
        String deliveryManLastName
) {
}
