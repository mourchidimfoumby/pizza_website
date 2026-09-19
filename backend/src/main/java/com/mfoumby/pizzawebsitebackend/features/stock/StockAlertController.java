package com.mfoumby.pizzawebsitebackend.features.stock;

import com.mfoumby.pizzawebsitebackend.features.stock.domain.StockAlertService;
import com.mfoumby.pizzawebsitebackend.features.stock.domain.entity.StockAlert;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/stock_alerts")
public class StockAlertController {
    private final StockAlertService stockAlertService;

    public StockAlertController(StockAlertService stockAlertService) {
        this.stockAlertService = stockAlertService;
    }

    @GetMapping
    public ResponseEntity<List<StockAlert>> getStockAlerts() {
        return ResponseEntity.ok(stockAlertService.getStockAlerts());
    }
}
