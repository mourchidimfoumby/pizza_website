package com.mfoumby.pizzawebsitebackend.features.order.data.mapper;

import com.mfoumby.pizzawebsitebackend.features.order.data.model.OrderModel;
import com.mfoumby.pizzawebsitebackend.features.order.domain.entity.Order;

public class OrderMapper {
    private OrderMapper() {}

    public static OrderModel toOrderModel(Order order) {
        return new OrderModel(
                order.orderId(),
                order.totalPrice(),
                order.date(),
                order.userId(),
                order.stateId(),
                order.pizzaioloId(),
                order.deliveryManId()
        );
    }
}
