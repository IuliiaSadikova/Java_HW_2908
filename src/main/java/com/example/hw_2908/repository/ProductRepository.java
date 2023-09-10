package com.example.hw_2908.repository;

import com.example.hw_2908.entity.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductRepository implements Repository<Product> {

    private final List<Product> products = new ArrayList<>();

    private Integer id = 0;
    @Override
    public Product add(Product elem) {
        id++;
        elem.setId(id);
        products.add(elem);
        return elem;
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public Optional<Product> getById(int id) {
        return products.stream()
                .filter(x -> x.getId() == id)
                .findFirst();
    }
}
