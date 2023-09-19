package com.prakash.stocktrading.service.impl;

import com.prakash.stocktrading.dto.StockDto;
import com.prakash.stocktrading.entity.Stock;
import com.prakash.stocktrading.exception.ResourceNotFoundException;
import com.prakash.stocktrading.repo.StockRepo;
import com.prakash.stocktrading.service.iface.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {

    private final StockRepo stockRepo;

    @Override
    public Stock createStock(StockDto stockDto) {
        Stock stock = new Stock();
        BeanUtils.copyProperties(stockDto, stock);
        this.stockRepo.save(stock);
        return stock;
    }

    @Override
    public StockDto findStock(Integer id) {
        System.out.println("line one");
        Stock stock = stockRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Stock", "stock Id", id));
        StockDto stockDto = new StockDto();
        BeanUtils.copyProperties(stock, stockDto);
        return stockDto;
    }

    @Override
    public List<StockDto> findAll() {
        List <Stock> stocks = this.stockRepo.findAll();
        List<StockDto> stockDtos = stocks.stream().map(s->this.entityToDto(s)).collect(Collectors.toList());
        return stockDtos;
    }

    @Override
    public void deleteUsingId(Integer id) {
        Stock stock = stockRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Stock", "Stock Id", id));
         this.stockRepo.delete(stock);

    }

    @Override
    public StockDto editStock(Integer id, StockDto stockDto) {
        Stock stock = this.stockRepo.findById(id).orElseThrow();

        stock.setName(stockDto.getName());
        stock.setQuantity(stockDto.getQuantity());
        stockRepo.save(stock);

        BeanUtils.copyProperties(stock,stockDto);

        return stockDto;
    }

    public StockDto entityToDto(Stock stock){
        StockDto stockDto = new StockDto();
        stockDto.setId(stock.getId());
        stockDto.setName(stock.getName());
        stockDto.setQuantity(stock.getQuantity());
        return stockDto;
    }
}
