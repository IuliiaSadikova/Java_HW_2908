package com.example.hw_2908.repository;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {

    T add (T elem);

    List<T> getAll();

    Optional<T> getById(int id);

}
