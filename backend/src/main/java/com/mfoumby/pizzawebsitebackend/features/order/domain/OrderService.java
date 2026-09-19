package com.mfoumby.pizzawebsitebackend.features.order.domain;

import com.mfoumby.pizzawebsitebackend.features.order.data.*;
import com.mfoumby.pizzawebsitebackend.features.order.domain.entity.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final PizzaOrderRepository pizzaOrderRepository;
    private final DrinkOrderRepository drinkOrderRepository;
    private final DessertOrderRepository dessertOrderRepository;
    private final CustomPizzaOrderRepository customPizzaOrderRepository;

    public OrderService(
            OrderRepository orderRepository,
            PizzaOrderRepository pizzaOrderRepository,
            DrinkOrderRepository drinkOrderRepository,
            DessertOrderRepository dessertOrderRepository,
            CustomPizzaOrderRepository customPizzaOrderRepository
    ) {
        this.orderRepository = orderRepository;
        this.pizzaOrderRepository = pizzaOrderRepository;
        this.drinkOrderRepository = drinkOrderRepository;
        this.dessertOrderRepository = dessertOrderRepository;
        this.customPizzaOrderRepository = customPizzaOrderRepository;
    }

    public void createOrder(Order order) {
        try {
            orderRepository.createOrder(order);

            if (order.pizzaOrders() != null && !order.pizzaOrders().isEmpty()) {
                pizzaOrderRepository.createPizzaOrders(order.pizzaOrders(), order.orderId());
            }

            if (order.drinkOrders() != null && !order.drinkOrders().isEmpty()) {
                drinkOrderRepository.createDrinkOrders(order.drinkOrders(), order.orderId());
            }

            if (order.dessertOrders() != null && !order.dessertOrders().isEmpty()) {
                dessertOrderRepository.createDessertOrders(order.dessertOrders(), order.orderId());
            }

            if (order.customPizzaOrders() != null && !order.customPizzaOrders().isEmpty()) {
                customPizzaOrderRepository.createCustomPizzaOrder(order.customPizzaOrders(), order.orderId());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
