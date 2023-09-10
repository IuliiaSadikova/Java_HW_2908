package com.example.hw_2908.entity;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Cart {

    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }
}
