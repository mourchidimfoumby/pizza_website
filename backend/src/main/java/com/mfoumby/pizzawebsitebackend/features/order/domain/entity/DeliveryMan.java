package com.mfoumby.pizzawebsitebackend.features.order.domain.entity;

public record DeliveryMan(
        Long deliveryManId,
        String firstName,
        String lastName
) {
}
