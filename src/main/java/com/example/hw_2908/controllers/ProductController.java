package com.example.hw_2908.controllers;

import com.example.hw_2908.entity.Product;
import com.example.hw_2908.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public Product createNewProduct(@RequestBody Product product) {
        return productService.createNewProduct(product);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAll();
    }
}
