package com.mfoumby.pizzawebsitebackend.features.dessert.data;

import com.mfoumby.pizzawebsitebackend.features.dessert.data.DessertModel;
import com.mfoumby.pizzawebsitebackend.features.dessert.domain.Dessert;

public class DessertMapper {
    private DessertMapper() {}

    public static Dessert toDessert(DessertModel dessertModel) {
        return new Dessert(
                dessertModel.dessertId(),
                dessertModel.dessertName(),
                dessertModel.dessertPrice(),
                dessertModel.dessertImageUrl(),
                dessertModel.dessertStockId()
        );
    }

    public static DessertModel toDessertModel(Dessert dessert) {
        return new DessertModel(
                dessert.id(),
                dessert.name(),
                dessert.price(),
                dessert.imageUrl(),
                dessert.stockId()
        );
    }
}
