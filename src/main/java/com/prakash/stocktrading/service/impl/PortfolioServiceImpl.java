package com.prakash.stocktrading.service.impl;

import com.prakash.stocktrading.dto.PortfolioDto;
import com.prakash.stocktrading.entity.Portfolio;
import com.prakash.stocktrading.repo.PortfolioRepo;
import com.prakash.stocktrading.repo.StockRepo;
import com.prakash.stocktrading.service.iface.PortfolioService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PortfolioServiceImpl implements PortfolioService {
    private final PortfolioRepo portfolioRepo;
    private final ModelMapper modelMapper;
    @Override
    public PortfolioDto createPortfolio(PortfolioDto portfolioDto) {
       Portfolio portfolio =  modelMapper.map(portfolioDto, Portfolio.class);
       Portfolio savedPortfolio =  portfolioRepo.save(portfolio);
       return modelMapper.map(savedPortfolio,PortfolioDto.class);
    }

    @Override
    public List<PortfolioDto> getAll() {
        List<Portfolio> portfolios = portfolioRepo.findAll();
        List<PortfolioDto> portfolioDtos = portfolios.stream()
                .map(portfolio -> modelMapper.map(portfolio, PortfolioDto.class))
                .collect(Collectors.toList());
        return portfolioDtos;
    }

    @Override
    public PortfolioDto findById(Integer id) {
       // return this.portfolioRepo.findById(id).orElseThrow();
        return null;
    }
}
