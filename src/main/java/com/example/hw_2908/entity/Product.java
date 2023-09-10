package com.example.hw_2908.entity;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
public class Product {

    private int id;
    private String code;
    private String label;
    private BigDecimal price;

}
