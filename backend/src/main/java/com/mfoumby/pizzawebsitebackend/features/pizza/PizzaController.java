package com.mfoumby.pizzawebsitebackend.features.pizza;

import com.mfoumby.pizzawebsitebackend.features.pizza.domain.PizzaService;
import com.mfoumby.pizzawebsitebackend.features.pizza.domain.entity.CreatePizzaRequest;
import com.mfoumby.pizzawebsitebackend.features.pizza.domain.entity.Pizza;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {
    private final PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping
    public ResponseEntity<List<Pizza>> getPizzas() {
        return ResponseEntity.ok(pizzaService.getPizzas());
    }

    @PostMapping
    public ResponseEntity<Void> createPizza(@RequestBody CreatePizzaRequest createPizzaRequest) {
        pizzaService.createPizza(createPizzaRequest);
        return ResponseEntity.ok().build();
    }
}
