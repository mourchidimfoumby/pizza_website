package com.mfoumby.pizzawebsitebackend.features.dessert.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DessertModel(
        @JsonProperty(DessertFields.DESSERT_ID)
        Long dessertId,
        @JsonProperty(DessertFields.DESSERT_NAME)
        String dessertName,
        @JsonProperty(DessertFields.DESSERT_PRICE)
        Float dessertPrice,
        @JsonProperty(DessertFields.DESSERT_IMAGE_URL)
        String dessertImageUrl,
        @JsonProperty(DessertFields.DESSERT_STOCK_ID)
        Long dessertStockId
) {
}
