package com.mfoumby.pizzawebsitebackend.features.pizza.data.mapper;

import com.mfoumby.pizzawebsitebackend.features.pizza.data.model.AllergenModel;
import com.mfoumby.pizzawebsitebackend.features.pizza.domain.entity.Allergen;

public class AllergenMapper {
    private AllergenMapper() {}

    public static Allergen toAllergen(AllergenModel allergenModel) {
        return new Allergen(
                allergenModel.allergenId(),
                allergenModel.allergenName()
        );
    }

    public static AllergenModel toAllergenModel(Allergen allergen) {
        return new AllergenModel(
                allergen.allergenId(),
                allergen.name()
        );
    }
}
