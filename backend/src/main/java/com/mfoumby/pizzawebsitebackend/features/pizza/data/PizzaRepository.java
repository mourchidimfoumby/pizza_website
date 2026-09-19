package com.mfoumby.pizzawebsitebackend.features.pizza.data;

import com.mfoumby.pizzawebsitebackend.features.pizza.data.fields.PizzaFields;
import com.mfoumby.pizzawebsitebackend.features.pizza.data.mapper.PizzaMapper;
import com.mfoumby.pizzawebsitebackend.features.pizza.data.model.FullPizzaModel;
import com.mfoumby.pizzawebsitebackend.features.pizza.data.model.PizzaModel;
import com.mfoumby.pizzawebsitebackend.features.pizza.domain.entity.CreatePizzaRequest;
import com.mfoumby.pizzawebsitebackend.features.pizza.domain.entity.Pizza;
import com.mfoumby.pizzawebsitebackend.shared.DbManager;
import org.springframework.stereotype.Repository;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.sql.*;
import java.util.List;

@Repository
public class PizzaRepository {
    private final DbManager dbManager;

    public PizzaRepository(DbManager dbManager) {
        this.dbManager = dbManager;
    }

    public List<Pizza> getPizzas() throws SQLException {
        String query = PizzaQueriesKt.getPizzasQuery();
        List<FullPizzaModel> fullPizzaModels = List.of();

        try (
                Connection connection = dbManager.getConnection();
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(query);
        ) {
            if (result.next()) {
                ObjectMapper mapper = new ObjectMapper();
                fullPizzaModels = mapper.readValue(result.getString(1), new TypeReference<List<FullPizzaModel>>() {});
            }

            return fullPizzaModels
                    .stream().map(PizzaMapper::toPizza)
                    .toList();
        }
    }

    public void createPizza(CreatePizzaRequest createPizzaRequest) throws SQLException {
        String query = String.format(
                "INSERT INTO %s (%s, %s, %s) VALUES (?, ?, ?)",
                PizzaFields.TABLE_NAME,
                PizzaFields.PIZZA_NAME,
                PizzaFields.PIZZA_PRICE,
                PizzaFields.PIZZA_IMAGE_URL
        );

        try (
                Connection connection = dbManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)
        ) {
            PizzaModel pizzaModel = PizzaMapper.toPizzaModel(createPizzaRequest);
            statement.setString(1, pizzaModel.pizzaName());
            statement.setFloat(2, pizzaModel.pizzaPrice());
            statement.setString(4, pizzaModel.pizzaImageUrl());
            statement.executeUpdate();
        }
    }
}
