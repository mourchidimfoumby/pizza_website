package com.mfoumby.pizzawebsitebackend.features.drink.domain;

import com.mfoumby.pizzawebsitebackend.features.drink.data.DrinkRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class DrinkService {
    private final DrinkRepository drinkRepository;

    public DrinkService(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    public List<Drink> getDrinks() {
        try {
            return drinkRepository.getDrinks();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateDrink(Drink drink) {
        try {
            drinkRepository.updateDrink(drink);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
