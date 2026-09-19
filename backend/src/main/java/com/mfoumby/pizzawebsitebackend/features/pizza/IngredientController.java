package com.mfoumby.pizzawebsitebackend.features.pizza;

import com.mfoumby.pizzawebsitebackend.features.pizza.domain.IngredientService;
import com.mfoumby.pizzawebsitebackend.features.pizza.domain.entity.Ingredient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public ResponseEntity<List<Ingredient>> getIngredients() {
        return ResponseEntity.ok(ingredientService.getIngredients());
    }

    @PostMapping
    public ResponseEntity<Void> createIngredient(Ingredient ingredient) {
        ingredientService.createIngredient(ingredient);
        return ResponseEntity.ok().build();
    }
}
