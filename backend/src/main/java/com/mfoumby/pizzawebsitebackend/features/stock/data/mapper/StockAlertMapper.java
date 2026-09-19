package com.mfoumby.pizzawebsitebackend.features.stock.data.mapper;

import com.mfoumby.pizzawebsitebackend.features.stock.data.model.StockAlertModel;
import com.mfoumby.pizzawebsitebackend.features.stock.domain.entity.StockAlert;

public class StockAlertMapper {
    private StockAlertMapper() {}

    public static StockAlert toStockAlert(StockAlertModel stockAlertModel) {
        return new StockAlert(
                stockAlertModel.stockAlertId(),
                stockAlertModel.stockAlertMessage(),
                stockAlertModel.stockAlertDate(),
                stockAlertModel.stockAlertStockId()
        );
    }
}
