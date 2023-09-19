package com.prakash.stocktrading.repo;

import com.prakash.stocktrading.entity.Stock;
import com.prakash.stocktrading.service.iface.StockService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepo extends JpaRepository<Stock, Integer> {

}
