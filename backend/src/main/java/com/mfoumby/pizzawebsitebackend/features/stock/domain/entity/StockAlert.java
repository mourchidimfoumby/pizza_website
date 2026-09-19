package com.mfoumby.pizzawebsitebackend.features.stock.domain.entity;

public record StockAlert(
        Long alertId,
        String message,
        String date,
        String stockId
) {
}
