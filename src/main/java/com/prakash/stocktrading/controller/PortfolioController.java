package com.prakash.stocktrading.controller;

import com.fasterxml.classmate.members.ResolvedParameterizedMember;
import com.prakash.stocktrading.dto.PortfolioDto;
import com.prakash.stocktrading.service.iface.PortfolioService;
import com.prakash.stocktrading.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/portfolio")
public class PortfolioController {

    private final PortfolioService portfolioService;

    @PostMapping("/create")
    public ResponseEntity<?> createPortfolio(@RequestBody PortfolioDto portfoliDto){
       return new ResponseEntity<>(this.portfolioService.createPortfolio(portfoliDto),HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<?> showAll(){
        return new ResponseEntity<>(this.portfolioService.getAll(),HttpStatus.OK);
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity<?> showAll(@PathVariable Integer id){
        return new ResponseEntity<>(this.portfolioService.getAll(),HttpStatus.OK);
    }
}
