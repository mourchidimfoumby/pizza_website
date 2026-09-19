package com.mfoumby.pizzawebsitebackend.features.pizza.domain;

import com.mfoumby.pizzawebsitebackend.features.pizza.data.PizzaAllergenRepository;
import com.mfoumby.pizzawebsitebackend.features.pizza.data.PizzaIngredientRepository;
import com.mfoumby.pizzawebsitebackend.features.pizza.data.PizzaRepository;
import com.mfoumby.pizzawebsitebackend.features.pizza.domain.entity.CreatePizzaRequest;
import com.mfoumby.pizzawebsitebackend.features.pizza.domain.entity.Pizza;
import com.mfoumby.pizzawebsitebackend.features.pizza.domain.entity.PizzaAllergen;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class PizzaService {
    private final PizzaRepository pizzaRepository;
    private final PizzaIngredientRepository pizzaIngredientRepository;
    private final PizzaAllergenRepository pizzaAllergenRepository;

    public PizzaService(
            PizzaRepository pizzaRepository,
            PizzaIngredientRepository pizzaIngredientRepository,
            PizzaAllergenRepository pizzaAllergenRepository
    ) {
        this.pizzaRepository = pizzaRepository;
        this.pizzaIngredientRepository = pizzaIngredientRepository;
        this.pizzaAllergenRepository = pizzaAllergenRepository;
    }

    public List<Pizza> getPizzas() {
        try {
            return pizzaRepository.getPizzas();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createPizza(CreatePizzaRequest createPizzaRequest) {
        try {
            pizzaRepository.createPizza(createPizzaRequest);

            if (createPizzaRequest.pizzaIngredients() != null && !createPizzaRequest.pizzaIngredients().isEmpty()) {
                pizzaIngredientRepository.addIngredientsPizza(createPizzaRequest.pizzaId(), createPizzaRequest.pizzaIngredients());
            }

            if (createPizzaRequest.allergens() != null && !createPizzaRequest.allergens().isEmpty()) {
                List<PizzaAllergen> pizzaAllergens = createPizzaRequest.allergens().stream()
                        .map(a -> new PizzaAllergen(createPizzaRequest.pizzaId(), a.allergenId()))
                        .toList();
                pizzaAllergenRepository.addPizzaAllergens(pizzaAllergens);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
