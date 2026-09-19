package com.mfoumby.pizzawebsitebackend.features.order.data;

import com.mfoumby.pizzawebsitebackend.features.order.data.fields.CustomPizzaOrderFields;
import com.mfoumby.pizzawebsitebackend.features.order.data.mapper.CustomPizzaOrderMapper;
import com.mfoumby.pizzawebsitebackend.features.order.data.model.CustomPizzaOrderModel;
import com.mfoumby.pizzawebsitebackend.features.order.domain.entity.CustomPizzaOrder;
import com.mfoumby.pizzawebsitebackend.shared.DbManager;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CustomPizzaOrderRepository {
    private final DbManager dbManager;

    public CustomPizzaOrderRepository(DbManager dbManager) {
        this.dbManager = dbManager;
    }

    public void createCustomPizzaOrder(List<CustomPizzaOrder> customPizzaOrders, Long orderId) throws SQLException {
        String values = customPizzaOrders.stream()
                .map(cp -> "(?, ?, ?, ?, ?)")
                .collect(Collectors.joining(", "));

        String query = String.format(
                "INSERT INTO %s (%s, %s, %s, %s, %s) VALUES %s",
                CustomPizzaOrderFields.TABLE_NAME,
                CustomPizzaOrderFields.CUSTOM_PIZZA_ORDER_PIZZA_ID,
                CustomPizzaOrderFields.CUSTOM_PIZZA_ORDER_INGREDIENT_ID,
                CustomPizzaOrderFields.CUSTOM_PIZZA_ORDER_ORDER_ID,
                CustomPizzaOrderFields.CUSTOM_PIZZA_ORDER_QUANTITY,
                CustomPizzaOrderFields.CUSTOM_PIZZA_ORDER_PERSONALIZATION_TYPE_ID,
                values
        );

        try (
                Connection connection = dbManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)
        ) {
            for (int i = 0; i < customPizzaOrders.size(); i++) {
                CustomPizzaOrderModel customPizzaOrderModel = CustomPizzaOrderMapper.toCustomPizzaOrderModel(customPizzaOrders.get(i), orderId);
                statement.setLong(1 + i, customPizzaOrderModel.customPizzaPizzaId());
                statement.setLong(2 + i, customPizzaOrderModel.customPizzaIngredientId());
                statement.setLong(3 + i, customPizzaOrderModel.customPizzaOrderId());
                statement.setInt(4 + i, customPizzaOrderModel.customPizzaQuantity());
                statement.setLong(5 + i, customPizzaOrderModel.customPizzaPersonalizationTypeId());
            }
            statement.executeUpdate();
        }
    }
}
