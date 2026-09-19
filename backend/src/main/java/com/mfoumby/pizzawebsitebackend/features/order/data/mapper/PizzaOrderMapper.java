package com.mfoumby.pizzawebsitebackend.features.order.data.mapper;

import com.mfoumby.pizzawebsitebackend.features.order.data.model.PizzaOrderModel;
import com.mfoumby.pizzawebsitebackend.features.order.domain.entity.PizzaOrder;

public class PizzaOrderMapper {
    private PizzaOrderMapper() {}

    public static PizzaOrderModel toPizzaOrderModel(PizzaOrder pizzaOrder, Long orderId) {
        return new PizzaOrderModel(
                orderId,
                pizzaOrder.pizzaId(),
                pizzaOrder.quantity()
        );
    }
}
