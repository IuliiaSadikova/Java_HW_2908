package com.example.hw_2908.service;

import com.example.hw_2908.entity.Cart;
import com.example.hw_2908.entity.Customer;
import com.example.hw_2908.entity.Product;
import com.example.hw_2908.repository.CustomerRepository;
import com.example.hw_2908.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    public Customer createNewCustomer(Customer customer) {
        Customer newCustomer = new Customer();
        newCustomer.setName(customer.getName());
        newCustomer.setCart(customer.getCart());
        newCustomer = customerRepository.add(newCustomer);
        return newCustomer;
    }

    public List<Customer> getAll() {
        return customerRepository.getAll();
    }

    public void addProductToCart(int customerId, int productId) {
        Customer customer = customerRepository.getById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));
        Cart cart = customer.getCart();
        if (cart == null) {
            cart = new Cart();
        }
        Product product = productRepository.getById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
        cart.addProduct(product);
        customer.setCart(cart);
    }

    public double getCartAmount(int customerId) {
        return customerRepository.getById(customerId)
                .map(Customer::getCart)
                .map(cart -> cart.getProducts().stream()
                        .mapToDouble(x -> x.getPrice().doubleValue())
                        .sum())
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));
    }
}
