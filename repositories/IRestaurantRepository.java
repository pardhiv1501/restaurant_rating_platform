package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.Restaurant;

public interface IRestaurantRepository {
    Restaurant save(Restaurant Restaurant);
    boolean existsById(Long id);
    Optional<Restaurant> findById(Long id);
    List<Restaurant> findAll();
    void deleteById(Long id);
    long count();
}
