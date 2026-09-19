package com.mfoumby.pizzawebsitebackend.features.stock.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mfoumby.pizzawebsitebackend.features.stock.data.fields.StockFields;

public record StockModel(
        @JsonProperty(StockFields.STOCK_ID)
        Long stockId,
        @JsonProperty(StockFields.STOCK_NAME)
        String stockName,
        @JsonProperty(StockFields.STOCK_QUANTITY)
        int stockQuantity,
        @JsonProperty(StockFields.STOCK_THRESHOLD)
        int stockThreshold,
        @JsonProperty(StockFields.STOCK_MANAGER_ID)
        Long stockManagerId
) {
}
