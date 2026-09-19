package com.mfoumby.pizzawebsitebackend.features.pizza.data;

import com.mfoumby.pizzawebsitebackend.features.pizza.data.fields.AllergenFields;
import com.mfoumby.pizzawebsitebackend.features.pizza.data.mapper.AllergenMapper;
import com.mfoumby.pizzawebsitebackend.features.pizza.data.model.AllergenModel;
import com.mfoumby.pizzawebsitebackend.features.pizza.domain.entity.Allergen;
import com.mfoumby.pizzawebsitebackend.shared.DbManager;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class AllergenRepository {
    private final DbManager dbManager;

    public AllergenRepository(DbManager dbManager) {
        this.dbManager = dbManager;
    }

    public void createAllergen(Allergen allergen) throws SQLException {
        String query = String.format(
                "INSERT INTO %s (%s) VALUES (?)",
                AllergenFields.TABLE_NAME,
                AllergenFields.ALLERGEN_NAME
        );

        try (
                Connection connection = dbManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)
        ) {
            AllergenModel allergenModel = AllergenMapper.toAllergenModel(allergen);
            statement.setString(1, allergenModel.allergenName());
            statement.executeUpdate();
        }
    }
}
