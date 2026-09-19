package com.mfoumby.pizzawebsitebackend.features.dessert.domain;

import com.mfoumby.pizzawebsitebackend.features.dessert.data.DessertRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class DessertService {
    private final DessertRepository dessertRepository;

    public DessertService(DessertRepository dessertRepository) {
        this.dessertRepository = dessertRepository;
    }

    public List<Dessert> getDesserts() {
        try {
            return dessertRepository.getDesserts();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateDessert(Dessert dessert) {
        try {
            dessertRepository.updateDessert(dessert);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
