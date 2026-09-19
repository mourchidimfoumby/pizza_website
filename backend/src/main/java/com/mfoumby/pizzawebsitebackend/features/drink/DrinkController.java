package com.mfoumby.pizzawebsitebackend.features.drink;

import com.mfoumby.pizzawebsitebackend.features.drink.domain.Drink;
import com.mfoumby.pizzawebsitebackend.features.drink.domain.DrinkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drinks")
public class DrinkController {
    private final DrinkService drinkService;

    public DrinkController(DrinkService drinkService) {
        this.drinkService = drinkService;
    }

    @GetMapping
    public ResponseEntity<List<Drink>> getDrinks() {
        return ResponseEntity.ok(drinkService.getDrinks());
    }

    @PutMapping("/{drinkId}")
    public void updateDrink(@RequestBody Drink drink) {
        drinkService.updateDrink(drink);
    }
}
