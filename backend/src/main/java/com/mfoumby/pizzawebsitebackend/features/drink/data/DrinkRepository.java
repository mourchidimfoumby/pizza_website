package com.mfoumby.pizzawebsitebackend.features.drink.data;

import com.mfoumby.pizzawebsitebackend.features.drink.domain.Drink;
import com.mfoumby.pizzawebsitebackend.shared.DbManager;
import com.mfoumby.pizzawebsitebackend.shared.ResultUtils;
import org.springframework.stereotype.Repository;
import tools.jackson.core.type.TypeReference;

import java.sql.*;
import java.util.List;

@Repository
public class DrinkRepository {
    private final DbManager dbManager;

    public DrinkRepository(DbManager dbManager) {
        this.dbManager = dbManager;
    }

    public List<Drink> getDrinks() throws SQLException {
        String query = String.format(
                "SELECT * FROM %s",
                DrinkFields.TABLE_NAME
        );

        try(
                Connection connection = dbManager.getConnection();
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(query);
        ) {
            return ResultUtils.getJson(result, new TypeReference<List<DrinkModel>>() {})
                    .stream().map(DrinkMapper::toDrink)
                    .toList();
        }
    }

    public void updateDrink(Drink drink) throws SQLException {
        String query = String.format(
                "UPDATE %s " +
                        "SET " +
                        "%s = ?, " +
                        "%s = ?, " +
                        "%s = ?, " +
                        "%s = ? " +
                        "WHERE %s = ?",
                DrinkFields.TABLE_NAME,
                DrinkFields.DRINK_NAME,
                DrinkFields.DRINK_PRICE,
                DrinkFields.DRINK_VOLUME,
                DrinkFields.DRINK_IMAGE_URL,
                DrinkFields.DRINK_ID
        );
        try (
                Connection connection = dbManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)
        ) {
            DrinkModel drinkModel = DrinkMapper.toDrinkModel(drink);
            statement.setString(1, drinkModel.drinkName());
            statement.setFloat(2, drinkModel.drinkPrice());
            statement.setFloat(3, drinkModel.drinkVolume());
            statement.setString(4, drinkModel.drinkImageUrl());
            statement.setLong(5, drinkModel.drinkId());
            statement.executeUpdate();
        }
    }
}
