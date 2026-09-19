package com.mfoumby.pizzawebsitebackend.features.pizza.data.mapper;

import com.mfoumby.pizzawebsitebackend.features.pizza.data.model.FullPizzaModel;
import com.mfoumby.pizzawebsitebackend.features.pizza.data.model.PizzaModel;
import com.mfoumby.pizzawebsitebackend.features.pizza.domain.entity.Allergen;
import com.mfoumby.pizzawebsitebackend.features.pizza.domain.entity.CreatePizzaRequest;
import com.mfoumby.pizzawebsitebackend.features.pizza.domain.entity.Ingredient;
import com.mfoumby.pizzawebsitebackend.features.pizza.domain.entity.Pizza;

import java.util.List;
import java.util.Optional;

public class PizzaMapper {
    private PizzaMapper() {}

    public static Pizza toPizza(FullPizzaModel fullPizzaModel) {
        List<Ingredient> ingredients = fullPizzaModel.ingredientModels()
                .stream().map(IngredientMapper::toIngredient)
                .toList();

        List<Allergen> allergens = Optional.ofNullable(fullPizzaModel.allergenModels())
                .orElse(List.of())
                .stream().map(AllergenMapper::toAllergen)
                .toList();

        return new Pizza(
                fullPizzaModel.pizzaModel().pizzaId(),
                fullPizzaModel.pizzaModel().pizzaName(),
                fullPizzaModel.pizzaModel().pizzaPrice(),
                fullPizzaModel.pizzaModel().pizzaImageUrl(),
                ingredients,
                allergens
        );
    }

    public static PizzaModel toPizzaModel(CreatePizzaRequest createPizzaRequest) {
        return new PizzaModel(
                createPizzaRequest.pizzaId(),
                createPizzaRequest.name(),
                createPizzaRequest.price(),
                createPizzaRequest.imageUrl()
        );
    }
}
