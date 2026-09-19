package com.mfoumby.pizzawebsitebackend.features.dessert.data;

import com.mfoumby.pizzawebsitebackend.features.dessert.domain.Dessert;
import com.mfoumby.pizzawebsitebackend.shared.DbManager;
import com.mfoumby.pizzawebsitebackend.shared.ResultUtils;
import org.springframework.stereotype.Repository;
import tools.jackson.core.type.TypeReference;

import java.sql.*;
import java.util.List;

@Repository
public class DessertRepository {
    private final DbManager dbManager;

    public DessertRepository(DbManager dbManager) {
        this.dbManager = dbManager;
    }

    public List<Dessert> getDesserts() throws SQLException {
        String query = String.format(
                "SELECT * FROM %s",
                DessertFields.TABLE_NAME
        );

        try(
                Connection connection = dbManager.getConnection();
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(query);
        ) {
            return ResultUtils.getJson(result, new TypeReference<List<DessertModel>>() {})
                    .stream().map(DessertMapper::toDessert)
                    .toList();
        }
    }

    public void updateDessert(Dessert dessert) throws SQLException {
        String query = String.format(
                "UPDATE %s " +
                        "SET " +
                        "%s = ?, " +
                        "%s = ?, " +
                        "%s = ?, " +
                        "%s = ? " +
                        "WHERE %s = ?",
                DessertFields.TABLE_NAME,
                DessertFields.DESSERT_NAME,
                DessertFields.DESSERT_PRICE,
                DessertFields.DESSERT_IMAGE_URL,
                DessertFields.DESSERT_ID
        );
        try (
                Connection connection = dbManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)
        ) {
            DessertModel dessertModel = DessertMapper.toDessertModel(dessert);
            statement.setString(1, dessertModel.dessertName());
            statement.setFloat(2, dessertModel.dessertPrice());
            statement.setString(4, dessertModel.dessertImageUrl());
            statement.setLong(5, dessertModel.dessertId());
            statement.executeUpdate();
        }
    }
}
