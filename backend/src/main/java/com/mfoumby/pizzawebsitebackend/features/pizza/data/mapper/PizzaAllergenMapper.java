package com.mfoumby.pizzawebsitebackend.features.pizza.data.mapper;

import com.mfoumby.pizzawebsitebackend.features.pizza.data.model.PizzaAllergenModel;
import com.mfoumby.pizzawebsitebackend.features.pizza.domain.entity.PizzaAllergen;

public class PizzaAllergenMapper {
    private PizzaAllergenMapper() {}

    public static PizzaAllergenModel toPizzaAllergenModel(PizzaAllergen pizzaAllergen) {
        return new PizzaAllergenModel(
                pizzaAllergen.allergenId(),
                pizzaAllergen.pizzaId()
        );
    }
}
