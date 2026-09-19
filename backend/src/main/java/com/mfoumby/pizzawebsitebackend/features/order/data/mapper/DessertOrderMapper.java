package com.mfoumby.pizzawebsitebackend.features.order.data.mapper;

import com.mfoumby.pizzawebsitebackend.features.order.data.model.DessertOrderModel;
import com.mfoumby.pizzawebsitebackend.features.order.domain.entity.DessertOrder;

public class DessertOrderMapper {
    private DessertOrderMapper() {}

    public static DessertOrderModel toDessertOrderModel(DessertOrder dessertOrder, Long orderId) {
        return new DessertOrderModel(
                orderId,
                dessertOrder.dessertId(),
                dessertOrder.quantity()
        );
    }
}
