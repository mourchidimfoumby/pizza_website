package com.mfoumby.pizzawebsitebackend.features.order.domain.entity;

import java.util.List;

public record Order(
        Long orderId,
        Float totalPrice,
        Long date,
        Long userId,
        int stateId,
        List<PizzaOrder> pizzaOrders,
        List<DrinkOrder> drinkOrders,
        List<DessertOrder> dessertOrders,
        List<CustomPizzaOrder> customPizzaOrders,
        Long pizzaioloId,
        Long deliveryManId
) {
}
