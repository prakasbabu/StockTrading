package com.prakash.stocktrading.service.iface;

import com.prakash.stocktrading.dto.StockDto;
import com.prakash.stocktrading.entity.Stock;

import java.util.List;

public interface StockService {
    Stock createStock(StockDto stockDto);
    StockDto findStock(Integer id);

    List<StockDto> findAll();

    void deleteUsingId(Integer id);

    StockDto editStock(Integer id, StockDto stockDto);
}
