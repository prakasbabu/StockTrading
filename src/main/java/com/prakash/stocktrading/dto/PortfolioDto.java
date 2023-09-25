package com.prakash.stocktrading.dto;

import com.prakash.stocktrading.entity.Stock;
import lombok.Data;

import java.util.List;
@Data
public class PortfolioDto {
    private Integer id;
    private List<Stock> stocks;
}
