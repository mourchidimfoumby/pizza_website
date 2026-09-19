package com.mfoumby.pizzawebsitebackend.features.pizza.data;

import com.mfoumby.pizzawebsitebackend.features.pizza.data.fields.PizzaAllergenFields;
import com.mfoumby.pizzawebsitebackend.features.pizza.data.mapper.PizzaAllergenMapper;
import com.mfoumby.pizzawebsitebackend.features.pizza.data.model.PizzaAllergenModel;
import com.mfoumby.pizzawebsitebackend.features.pizza.domain.entity.PizzaAllergen;
import com.mfoumby.pizzawebsitebackend.shared.DbManager;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PizzaAllergenRepository {
    private final DbManager dbManager;

    public PizzaAllergenRepository(DbManager dbManager) {
        this.dbManager = dbManager;
    }

    public void addPizzaAllergens(List<PizzaAllergen> pizzaAllergens) throws SQLException  {
        String values = pizzaAllergens.stream()
                .map(ap -> "(?, ?, ?)")
                .collect(Collectors.joining(", "));

        String query = String.format(
                "INSERT INTO %s (%s, %s) VALUES %s",
                PizzaAllergenFields.TABLE_NAME,
                PizzaAllergenFields.PIZZA_ALLERGEN_ALLERGEN_ID,
                PizzaAllergenFields.PIZZA_ALLERGEN_PIZZA_ID,
                values
        );

        try (
                Connection connection = dbManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)
        ) {
            for (int i = 0; i < pizzaAllergens.size(); i++) {
                PizzaAllergenModel pizzaAllergenModel = PizzaAllergenMapper.toPizzaAllergenModel(pizzaAllergens.get(i));
                statement.setLong(1 + i, pizzaAllergenModel.allergenId());
                statement.setLong(2, pizzaAllergenModel.pizzaId());
            }
            statement.executeUpdate();
        }
    }
}
