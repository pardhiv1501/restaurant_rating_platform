package com.example.demo.services;

import java.util.*;
import com.example.demo.entities.Restaurant;
import com.example.demo.repositories.RestaurantRepository;

public class RestaurantService {
    private RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository){
        this.restaurantRepository=restaurantRepository;
    }

    public Restaurant create(String name){
        Restaurant restaurant=new Restaurant(name);
        return restaurantRepository.save(restaurant);
    }

    public List<Restaurant> getAllRestaurants(){
        return restaurantRepository.findAll();
    }

    public Restaurant getRestaurantById(Long id){
        return restaurantRepository.findById(id).orElseThrow();
    }
}
