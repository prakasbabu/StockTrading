package com.prakash.stocktrading.service.iface;

import com.prakash.stocktrading.dto.PortfolioDto;
import com.prakash.stocktrading.entity.Portfolio;

import java.util.List;

public interface PortfolioService {
    PortfolioDto createPortfolio(PortfolioDto portfolioDto);
     List<PortfolioDto> getAll();
     PortfolioDto findById(Integer id);

}
