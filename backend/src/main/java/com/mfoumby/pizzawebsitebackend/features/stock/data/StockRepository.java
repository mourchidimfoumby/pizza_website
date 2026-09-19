package com.mfoumby.pizzawebsitebackend.features.stock.data;

import com.mfoumby.pizzawebsitebackend.features.stock.data.fields.StockFields;
import com.mfoumby.pizzawebsitebackend.features.stock.data.mapper.StockMapper;
import com.mfoumby.pizzawebsitebackend.features.stock.data.model.StockModel;
import com.mfoumby.pizzawebsitebackend.features.stock.domain.entity.Stock;
import com.mfoumby.pizzawebsitebackend.shared.DbManager;
import com.mfoumby.pizzawebsitebackend.shared.ResultUtils;
import org.springframework.stereotype.Repository;
import tools.jackson.core.type.TypeReference;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

@Repository
public class StockRepository {
    private final DbManager dbManager;

    public StockRepository(DbManager dbManager) {
        this.dbManager = dbManager;
    }

    public List<Stock> getStocks() throws Exception {
        String query = String.format(
                "SELECT * FROM %s",
                StockFields.TABLE_NAME
        );
        try (
                Connection connection = dbManager.getConnection();
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(query);
        ) {
            return ResultUtils
                    .getJson(result, new TypeReference<List<StockModel>>() {})
                    .stream()
                    .map(StockMapper::toStock)
                    .toList();
        }
    }
}
