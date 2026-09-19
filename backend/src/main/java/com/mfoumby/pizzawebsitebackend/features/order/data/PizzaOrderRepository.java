package com.mfoumby.pizzawebsitebackend.features.order.data;

import com.mfoumby.pizzawebsitebackend.features.order.data.fields.PizzaOrderFields;
import com.mfoumby.pizzawebsitebackend.features.order.data.mapper.PizzaOrderMapper;
import com.mfoumby.pizzawebsitebackend.features.order.data.model.PizzaOrderModel;
import com.mfoumby.pizzawebsitebackend.features.order.domain.entity.PizzaOrder;
import com.mfoumby.pizzawebsitebackend.shared.DbManager;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PizzaOrderRepository {
    private final DbManager dbManager;

    public PizzaOrderRepository(DbManager dbManager) {
        this.dbManager = dbManager;
    }

    public void createPizzaOrders(List<PizzaOrder> pizzaOrders, Long orderId) throws SQLException {
        String values = pizzaOrders.stream()
                .map(p -> "(?, ?, ?)")
                .collect(Collectors.joining(", "));

        String query = String.format(
                "INSERT INTO %s (%s, %s, %s) VALUES %s",
                PizzaOrderFields.TABLE_NAME,
                PizzaOrderFields.PIZZA_ORDER_PIZZA_ID,
                PizzaOrderFields.PIZZA_ORDER_ORDER_ID,
                PizzaOrderFields.PIZZA_ORDER_QUANTITY,
                values
        );

        try (
                Connection connection = dbManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)
        ) {
            for (int i = 0; i < pizzaOrders.size(); i++) {
                PizzaOrderModel pizzaOrderModel = PizzaOrderMapper.toPizzaOrderModel(pizzaOrders.get(i), orderId);
                statement.setLong(1 + i, pizzaOrderModel.pizzaOrderPizzaId());
                statement.setLong(2 + i, pizzaOrderModel.pizzaOrderOrderId());
                statement.setLong(3 + i, pizzaOrderModel.pizzaOrderQuantity());
            }
            statement.executeUpdate();
        }
    }
}
