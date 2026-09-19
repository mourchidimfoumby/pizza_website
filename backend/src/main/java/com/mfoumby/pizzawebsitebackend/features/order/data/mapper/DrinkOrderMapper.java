package com.mfoumby.pizzawebsitebackend.features.order.data.mapper;

import com.mfoumby.pizzawebsitebackend.features.order.data.model.DrinkOrderModel;
import com.mfoumby.pizzawebsitebackend.features.order.domain.entity.DrinkOrder;

public class DrinkOrderMapper {
    private DrinkOrderMapper() {}

    public static DrinkOrderModel toDrinkOrderModel(DrinkOrder drinkOrder, Long orderId) {
        return new DrinkOrderModel(
                orderId,
                drinkOrder.drinkId(),
                drinkOrder.quantity()
        );
    }
}
