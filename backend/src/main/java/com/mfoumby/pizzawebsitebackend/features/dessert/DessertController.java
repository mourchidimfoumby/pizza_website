package com.mfoumby.pizzawebsitebackend.features.dessert;

import com.mfoumby.pizzawebsitebackend.features.dessert.domain.Dessert;
import com.mfoumby.pizzawebsitebackend.features.dessert.domain.DessertService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/desserts")
public class DessertController {
    private final DessertService dessertService;

    public DessertController(DessertService dessertService) {
        this.dessertService = dessertService;
    }

    @GetMapping
    public ResponseEntity<List<Dessert>> getDesserts() {
        return ResponseEntity.ok(dessertService.getDesserts());
    }

    @PutMapping("/{dessertId}")
    public void updateDessert(@RequestBody Dessert dessert) {
        dessertService.updateDessert(dessert);
    }
}
