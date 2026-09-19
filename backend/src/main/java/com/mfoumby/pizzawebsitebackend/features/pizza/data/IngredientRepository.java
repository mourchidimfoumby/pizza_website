package com.mfoumby.pizzawebsitebackend.features.pizza.data;

import com.mfoumby.pizzawebsitebackend.features.pizza.data.fields.IngredientFields;
import com.mfoumby.pizzawebsitebackend.features.pizza.data.mapper.IngredientMapper;
import com.mfoumby.pizzawebsitebackend.features.pizza.data.model.IngredientModel;
import com.mfoumby.pizzawebsitebackend.features.pizza.domain.entity.Ingredient;
import com.mfoumby.pizzawebsitebackend.shared.DbManager;
import com.mfoumby.pizzawebsitebackend.shared.ResultUtils;
import org.springframework.stereotype.Repository;
import tools.jackson.core.type.TypeReference;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class IngredientRepository {
    private final DbManager dbManager;

    public IngredientRepository(DbManager dbManager) {
        this.dbManager = dbManager;
    }

    public List<Ingredient> getIngredients() throws SQLException {
        String query = String.format("SELECT * FROM %s", IngredientFields.TABLE_NAME);

        try(
                Connection connection = dbManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(query);
                ResultSet result = statement.executeQuery();
        ) {
            return ResultUtils.getJson(result, new TypeReference<List<IngredientModel>>() {})
                    .stream().map(IngredientMapper::toIngredient)
                    .toList();
        }
    }

    public void createIngredient(Ingredient ingredient) throws SQLException {
        String query = String.format(
                "INSERT INTO %s (%s, %s, %s) VALUES (?, ?, ?)",
                IngredientFields.TABLE_NAME,
                IngredientFields.INGREDIENT_NAME,
                IngredientFields.INGREDIENT_UPDATABLE,
                IngredientFields.INGREDIENT_STOCK_ID
        );

        try (
                Connection connection = dbManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)
        ) {
            IngredientModel ingredientModel = IngredientMapper.toIngredientModel(ingredient);
            statement.setString(1, ingredientModel.ingredientName());
            statement.setInt(2, ingredientModel.ingredientUpdatable());
            statement.setLong(3, ingredientModel.ingredientStockId());
            statement.executeUpdate();
        }
    }
}
