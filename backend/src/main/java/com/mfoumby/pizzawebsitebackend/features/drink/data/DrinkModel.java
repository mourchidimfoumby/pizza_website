package com.mfoumby.pizzawebsitebackend.features.drink.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DrinkModel(
        @JsonProperty(DrinkFields.DRINK_ID)
        Long drinkId,
        @JsonProperty(DrinkFields.DRINK_NAME)
        String drinkName,
        @JsonProperty(DrinkFields.DRINK_PRICE)
        Float drinkPrice,
        @JsonProperty(DrinkFields.DRINK_VOLUME)
        Float drinkVolume,
        @JsonProperty(DrinkFields.DRINK_IMAGE_URL)
        String drinkImageUrl,
        @JsonProperty(DrinkFields.DRINK_STOCK_ID)
        Long drinkStockId
) {
}
