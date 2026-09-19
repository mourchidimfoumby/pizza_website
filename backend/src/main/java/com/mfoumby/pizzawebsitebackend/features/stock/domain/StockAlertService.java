package com.mfoumby.pizzawebsitebackend.features.stock.domain;

import com.mfoumby.pizzawebsitebackend.features.stock.data.StockAlertRepository;
import com.mfoumby.pizzawebsitebackend.features.stock.domain.entity.StockAlert;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockAlertService {
    private final StockAlertRepository stockAlertRepository;

    public StockAlertService(StockAlertRepository stockAlertRepository) {
        this.stockAlertRepository = stockAlertRepository;
    }

    public List<StockAlert> getStockAlerts() {
        try {
            return stockAlertRepository.getAlerts();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
