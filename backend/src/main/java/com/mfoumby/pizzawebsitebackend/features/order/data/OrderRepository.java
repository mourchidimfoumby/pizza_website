package com.mfoumby.pizzawebsitebackend.features.order.data;

import com.mfoumby.pizzawebsitebackend.features.order.data.fields.OrderFields;
import com.mfoumby.pizzawebsitebackend.features.order.data.mapper.OrderMapper;
import com.mfoumby.pizzawebsitebackend.features.order.data.model.OrderModel;
import com.mfoumby.pizzawebsitebackend.features.order.domain.entity.Order;
import com.mfoumby.pizzawebsitebackend.shared.DbManager;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class OrderRepository {
    private final DbManager dbManager;

    public OrderRepository(DbManager dbManager) {
        this.dbManager = dbManager;
    }

    public void createOrder(Order order) throws SQLException {
        String query = String.format(
                "INSERT INTO %s (%s, %s, %s) VALUES (?, ?, ?)",
                OrderFields.TABLE_NAME,
                OrderFields.ORDER_TOTAL_PRICE,
                OrderFields.ORDER_DATE,
                OrderFields.ORDER_USER_ID
        );
        try (
                Connection connection = dbManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)
        ) {
            OrderModel orderModel = OrderMapper.toOrderModel(order);
            statement.setFloat(1, orderModel.orderTotalPrice());
            statement.setLong(2, orderModel.orderDate());
            statement.setLong(3, orderModel.orderUserId());
            statement.executeUpdate();
        }
    }
}
