package com.example.hw_2908.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {

    private int id;
    private String name;
    private Cart cart;

}
