package com.example.hw_2908.controllers;

import com.example.hw_2908.entity.Customer;
import com.example.hw_2908.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAll();
    }

    @PostMapping
    public Customer createNewCustomer(@RequestBody Customer customer) {
        return customerService.createNewCustomer(customer);
    }

    @PostMapping("/{customerId}/cart/product")
    public void addProductToCart(@PathVariable int customerId, @RequestBody int productId) {
        customerService.addProductToCart(customerId, productId);
    }

    @GetMapping("/{customerId}/cart/amount")
    public double getCartAmount(@PathVariable int customerId) {
        return customerService.getCartAmount(customerId);
    }

}
