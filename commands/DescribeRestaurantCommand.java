package com.example.demo.commands;

import java.util.List;
import java.util.Optional;
import com.example.demo.entities.Restaurant;
import com.example.demo.repositories.RestaurantRepository;

public class DescribeRestaurantCommand implements ICommand{

    private final RestaurantRepository restaurantRepository;
    public DescribeRestaurantCommand(RestaurantRepository restaurantRepository){
        this.restaurantRepository=restaurantRepository;
    }

    @Override
    public void invoke(List<String> tokens) {
        Long id=Long.parseLong(tokens.get(1));
        Optional<Restaurant> oprest=restaurantRepository.findById(id);
        Restaurant r=oprest.isPresent()?oprest.get():null;
        if(r==null)System.out.println("restaurant with this id doesn't exist");
        System.out.println(r.toString());
    }
}
