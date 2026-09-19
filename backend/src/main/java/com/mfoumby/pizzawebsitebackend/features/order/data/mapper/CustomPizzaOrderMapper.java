package com.mfoumby.pizzawebsitebackend.features.order.data.mapper;

import com.mfoumby.pizzawebsitebackend.features.order.data.model.CustomPizzaOrderModel;
import com.mfoumby.pizzawebsitebackend.features.order.domain.entity.CustomPizzaOrder;

public class CustomPizzaOrderMapper {
    private CustomPizzaOrderMapper() {}

    public static CustomPizzaOrderModel toCustomPizzaOrderModel(CustomPizzaOrder customPizzaOrder, Long orderId) {
        return new CustomPizzaOrderModel(
                customPizzaOrder.pizzaId(),
                customPizzaOrder.ingredientId(),
                orderId,
                customPizzaOrder.personalizationTypeId(),
                customPizzaOrder.quantity()
        );
    }
}
