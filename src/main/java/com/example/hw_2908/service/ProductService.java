package com.example.hw_2908.service;

import com.example.hw_2908.entity.Product;
import com.example.hw_2908.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product createNewProduct(Product product) {
        Product newProduct = new Product();
        newProduct.setCode(product.getCode());
        newProduct.setLabel(product.getLabel());
        newProduct.setPrice(product.getPrice());
        newProduct = productRepository.add(newProduct);
        return newProduct;
    }

    public List<Product> getAll() {
        return  productRepository.getAll();
    }
}
