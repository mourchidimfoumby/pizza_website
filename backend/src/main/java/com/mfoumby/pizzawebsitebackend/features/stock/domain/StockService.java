package com.mfoumby.pizzawebsitebackend.features.stock.domain;

import com.mfoumby.pizzawebsitebackend.features.stock.data.StockRepository;
import com.mfoumby.pizzawebsitebackend.features.stock.domain.entity.Stock;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {
    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public List<Stock> getStocks() {
        try {
            return stockRepository.getStocks();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
