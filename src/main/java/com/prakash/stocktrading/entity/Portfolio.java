package com.prakash.stocktrading.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
@Data
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "portfolio_id")
    private List<Stock> stocks;

}
