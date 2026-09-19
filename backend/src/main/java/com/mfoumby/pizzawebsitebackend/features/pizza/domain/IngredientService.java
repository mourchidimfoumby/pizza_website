package com.mfoumby.pizzawebsitebackend.features.pizza.domain;

import com.mfoumby.pizzawebsitebackend.features.pizza.data.IngredientRepository;
import com.mfoumby.pizzawebsitebackend.features.pizza.domain.entity.Ingredient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public List<Ingredient> getIngredients() {
        try {
            return ingredientRepository.getIngredients();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void createIngredient(Ingredient ingredient) {
        try {
            ingredientRepository.createIngredient(ingredient);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
