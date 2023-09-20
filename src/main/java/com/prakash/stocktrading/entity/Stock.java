package com.prakash.stocktrading.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

@Entity
@Data
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String name;
    @Max(value = 20,message = "Quantity must be less than or equal to 20")
    @Min(value = 5,message = "Quantity must be greater than or equal to 5")
    @NotNull
    private Integer quantity;

}
