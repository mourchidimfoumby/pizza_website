package com.mfoumby.pizzawebsitebackend.features.order.data;

import com.mfoumby.pizzawebsitebackend.features.order.data.fields.DrinkOrderFields;
import com.mfoumby.pizzawebsitebackend.features.order.data.mapper.DrinkOrderMapper;
import com.mfoumby.pizzawebsitebackend.features.order.data.model.DrinkOrderModel;
import com.mfoumby.pizzawebsitebackend.features.order.domain.entity.DrinkOrder;
import com.mfoumby.pizzawebsitebackend.shared.DbManager;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DrinkOrderRepository {
    private final DbManager dbManager;

    public DrinkOrderRepository(DbManager dbManager) {
        this.dbManager = dbManager;
    }

    public void createDrinkOrders(List<DrinkOrder> drinkOrders, Long orderId) throws SQLException {
        String values = drinkOrders.stream()
                .map(d -> "(?, ?, ?)")
                .collect(Collectors.joining(", "));

        String query = String.format(
                "INSERT INTO %s (%s, %s, %s) VALUES %s",
                DrinkOrderFields.TABLE_NAME,
                DrinkOrderFields.DRINK_ORDER_DRINK_ID,
                DrinkOrderFields.DRINK_ORDER_ORDER_ID,
                DrinkOrderFields.DRINK_ORDER_QUANTITY,
                values
        );

        try (
                Connection connection = dbManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)
        ) {
            for (int i = 0; i < drinkOrders.size(); i++) {
                DrinkOrderModel drinkOrderModel = DrinkOrderMapper.toDrinkOrderModel(drinkOrders.get(i), orderId);
                statement.setLong(1 + i, drinkOrderModel.drinkOrderDrinkId());
                statement.setLong(2 + i, drinkOrderModel.drinkOderOrderId());
                statement.setLong(3 + i, drinkOrderModel.drinkOrderQuantity());
            }
            statement.executeUpdate();
        }
    }
}
