package com.mfoumby.pizzawebsitebackend.features.stock;

import com.mfoumby.pizzawebsitebackend.features.stock.domain.StockService;
import com.mfoumby.pizzawebsitebackend.features.stock.domain.entity.Stock;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class StockController {
    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping
    public ResponseEntity<List<Stock>> getStocks() {
        return ResponseEntity.ok(stockService.getStocks());
    }
}
