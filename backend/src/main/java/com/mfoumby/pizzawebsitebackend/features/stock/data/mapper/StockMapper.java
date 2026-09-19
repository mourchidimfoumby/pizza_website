package com.mfoumby.pizzawebsitebackend.features.stock.data.mapper;

import com.mfoumby.pizzawebsitebackend.features.stock.data.model.StockModel;
import com.mfoumby.pizzawebsitebackend.features.stock.domain.entity.Stock;

public class StockMapper {
    private StockMapper() {}

    public static Stock toStock(StockModel stockModel) {
        return new Stock(
                stockModel.stockId(),
                stockModel.stockName(),
                stockModel.stockQuantity(),
                stockModel.stockThreshold(),
                stockModel.stockManagerId()
        );
    }
}
