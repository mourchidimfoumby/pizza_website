package com.mfoumby.pizzawebsitebackend.features.pizza.data;

import com.mfoumby.pizzawebsitebackend.features.pizza.data.fields.PizzaIngredientFields;
import com.mfoumby.pizzawebsitebackend.features.pizza.data.mapper.PizzaIngredientMapper;
import com.mfoumby.pizzawebsitebackend.features.pizza.data.model.PizzaIngredientModel;
import com.mfoumby.pizzawebsitebackend.features.pizza.domain.entity.PizzaIngredient;
import com.mfoumby.pizzawebsitebackend.shared.DbManager;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PizzaIngredientRepository {
    private final DbManager dbManager;

    public PizzaIngredientRepository(DbManager dbManager) {
        this.dbManager = dbManager;
    }

    public void addIngredientsPizza(Long pizzaId, List<PizzaIngredient> pizzaIngredients) throws SQLException {
        String values = pizzaIngredients.stream()
                .map(i -> "(?, ?, ?)")
                .collect(Collectors.joining(", "));

        String query = String.format(
                "INSERT INTO %s (%s, %s, %s) VALUES %s",
                PizzaIngredientFields.TABLE_NAME,
                PizzaIngredientFields.PIZZA_INGREDIENT_PIZZA_ID,
                PizzaIngredientFields.PIZZA_INGREDIENT_INGREDIENT_ID,
                PizzaIngredientFields.PIZZA_INGREDIENT_QUANTITY,
                values
        );

        try (
                Connection connection = dbManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)
        ) {
            for (int i = 0; i < pizzaIngredients.size(); i++) {
                PizzaIngredientModel pizzaIngredientModel = PizzaIngredientMapper.toPizzaIngredientModel(pizzaId, pizzaIngredients.get(i));
                statement.setLong(1 + i, pizzaIngredientModel.pizzaId());
                statement.setLong(2 + i, pizzaIngredientModel.ingredientId());
                statement.setFloat(3 + i, pizzaIngredientModel.pizzaIngredientQuantity());
            }
            statement.executeUpdate();
        }
    }
}
