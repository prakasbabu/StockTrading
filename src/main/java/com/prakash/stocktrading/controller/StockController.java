package com.prakash.stocktrading.controller;

import com.prakash.stocktrading.dto.StockDto;
import com.prakash.stocktrading.service.iface.StockService;
import com.prakash.stocktrading.utils.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/stock")
public class StockController {
    private final StockService stockService;
    @PostMapping("/create")
    public ResponseEntity<?> createStock(@Valid @RequestBody StockDto stockDto, BindingResult result){

        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors()
                    .stream()
                    .map(error -> error.getDefaultMessage())
                    .collect(Collectors.toList());

            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(this.stockService.createStock(stockDto),HttpStatus.CREATED);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<StockDto> getStockById(@PathVariable Integer id){
        return new ResponseEntity<>(this.stockService.findStock(id), HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<StockDto>> findAll(){
        return new ResponseEntity<>(this.stockService.findAll(),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable Integer id){
        this.stockService.deleteUsingId(id);
        return new ResponseEntity<>( new ApiResponse("Stock id# "+id+" deleted successfully", true), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<StockDto> updateStock(@PathVariable Integer id, @RequestBody StockDto stockDto){
        return new ResponseEntity<>(this.stockService.editStock(id,stockDto),HttpStatus.OK);
    }


}
