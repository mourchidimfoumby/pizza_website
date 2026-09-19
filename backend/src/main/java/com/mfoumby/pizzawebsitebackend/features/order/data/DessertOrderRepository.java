package com.mfoumby.pizzawebsitebackend.features.order.data;

import com.mfoumby.pizzawebsitebackend.features.order.data.fields.DessertOrderFields;
import com.mfoumby.pizzawebsitebackend.features.order.data.mapper.DessertOrderMapper;
import com.mfoumby.pizzawebsitebackend.features.order.data.model.DessertOrderModel;
import com.mfoumby.pizzawebsitebackend.features.order.domain.entity.DessertOrder;
import com.mfoumby.pizzawebsitebackend.shared.DbManager;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DessertOrderRepository {
    private final DbManager dbManager;

    public DessertOrderRepository(DbManager dbManager) {
        this.dbManager = dbManager;
    }

    public void createDessertOrders(List<DessertOrder> dessertOrders, Long orderId) throws SQLException {
        String values = dessertOrders.stream()
                .map(d -> "(?, ?, ?)")
                .collect(Collectors.joining(", "));

        String query = String.format(
                "INSERT INTO %s (%s, %s, %s) VALUES %s",
                DessertOrderFields.TABLE_NAME,
                DessertOrderFields.DESSERT_ORDER_DESSERT_ID,
                DessertOrderFields.DESSERT_ORDER_ORDER_ID,
                DessertOrderFields.DESSERT_ORDER_QUANTITY,
                values
        );

        try (
                Connection connection = dbManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)
        ) {
            for (int i = 0; i < dessertOrders.size(); i++) {
                DessertOrderModel dessertOrderModel = DessertOrderMapper.toDessertOrderModel(dessertOrders.get(i), orderId);
                statement.setLong(1 + i, dessertOrderModel.dessertOrderDessertId());
                statement.setLong(2 + i, dessertOrderModel.dessertOrderOrderId());
                statement.setLong(3 + i, dessertOrderModel.dessertOrderQuantity());
            }
            statement.executeUpdate();
        }
    }
}
