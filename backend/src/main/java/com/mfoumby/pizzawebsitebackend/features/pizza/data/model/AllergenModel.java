package com.mfoumby.pizzawebsitebackend.features.pizza.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mfoumby.pizzawebsitebackend.features.pizza.data.fields.AllergenFields;

public record AllergenModel(
        @JsonProperty(AllergenFields.ALLERGEN_ID)
        Long allergenId,
        @JsonProperty(AllergenFields.ALLERGEN_NAME)
        String allergenName
) {
}
