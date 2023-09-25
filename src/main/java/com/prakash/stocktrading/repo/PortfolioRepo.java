package com.prakash.stocktrading.repo;

import com.prakash.stocktrading.entity.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioRepo extends JpaRepository<Portfolio, Integer> {
}
