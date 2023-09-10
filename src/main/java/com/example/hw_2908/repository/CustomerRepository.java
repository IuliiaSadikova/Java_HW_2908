package com.example.hw_2908.repository;

import com.example.hw_2908.entity.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CustomerRepository implements Repository<Customer> {

    private final List<Customer> customers = new ArrayList<>();

    private Integer id = 0;

    @Override
    public Customer add(Customer elem) {
        id++;
        elem.setId(id);
        customers.add(elem);
        return elem;
    }

    @Override
    public List<Customer> getAll() {
        return customers;
    }


    @Override
    public Optional<Customer> getById(int id) {
        return customers.stream()
                .filter(x -> x.getId() == id)
                .findFirst();
    }
}
