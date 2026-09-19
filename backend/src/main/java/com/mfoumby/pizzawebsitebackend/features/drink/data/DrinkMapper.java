package com.mfoumby.pizzawebsitebackend.features.drink.data;

import com.mfoumby.pizzawebsitebackend.features.drink.domain.Drink;

public class DrinkMapper {
    private DrinkMapper() {}

    public static Drink toDrink(DrinkModel drinkModel) {
        return new Drink(
                drinkModel.drinkId(),
                drinkModel.drinkName(),
                drinkModel.drinkPrice(),
                drinkModel.drinkVolume(),
                drinkModel.drinkImageUrl(),
                drinkModel.drinkStockId()
        );
    }

    public static DrinkModel toDrinkModel(Drink drink) {
        return new DrinkModel(
                drink.id(),
                drink.name(),
                drink.price(),
                drink.volume(),
                drink.imageUrl(),
                drink.stockId()
        );
    }
}
