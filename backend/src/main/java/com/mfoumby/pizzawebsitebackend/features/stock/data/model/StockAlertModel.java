package com.mfoumby.pizzawebsitebackend.features.stock.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mfoumby.pizzawebsitebackend.features.stock.data.fields.StockAlertFields;

public record StockAlertModel(
        @JsonProperty(StockAlertFields.STOCK_ALERT_ID)
        Long stockAlertId,
        @JsonProperty(StockAlertFields.STOCK_ALERT_MESSAGE)
        String stockAlertMessage,
        @JsonProperty(StockAlertFields.STOCK_ALERT_DATE)
        String stockAlertDate,
        @JsonProperty(StockAlertFields.STOCK_ALERT_STOCK_ID)
        String stockAlertStockId
) {
}
