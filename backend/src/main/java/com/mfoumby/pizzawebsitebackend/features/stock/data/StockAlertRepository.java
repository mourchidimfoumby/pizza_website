package com.mfoumby.pizzawebsitebackend.features.stock.data;

import com.mfoumby.pizzawebsitebackend.features.stock.data.fields.StockAlertFields;
import com.mfoumby.pizzawebsitebackend.features.stock.data.mapper.StockAlertMapper;
import com.mfoumby.pizzawebsitebackend.features.stock.data.model.StockAlertModel;
import com.mfoumby.pizzawebsitebackend.features.stock.domain.entity.StockAlert;
import com.mfoumby.pizzawebsitebackend.shared.DbManager;
import com.mfoumby.pizzawebsitebackend.shared.ResultUtils;
import org.springframework.stereotype.Repository;
import tools.jackson.core.type.TypeReference;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

@Repository
public class StockAlertRepository {
    private final DbManager dbManager;

    public StockAlertRepository(DbManager dbManager) {
        this.dbManager = dbManager;
    }

    public List<StockAlert> getAlerts() throws Exception {
        String query = String.format("SELECT * FROM %s", StockAlertFields.TABLE_NAME);
        try (
                Connection connection = dbManager.getConnection();
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(query);
        ) {
            return ResultUtils
                    .getJson(result, new TypeReference<List<StockAlertModel>>() {})
                    .stream()
                    .map(StockAlertMapper::toStockAlert)
                    .toList();
        }
    }
}
