package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Restaurant;
import com.example.demo.repositories.RestaurantRepository;

public class ListRestaurantsCommand implements ICommand {

    private final RestaurantRepository restaurantRepository;

    public ListRestaurantsCommand(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public void invoke(List<String> tokens) {
        List<Restaurant> l = restaurantRepository.findAll();
        String s="[";
        for(Restaurant r:l){
            s+="Restaurant [id="+r.getId()+"], ";
        }
        s=s.substring(0,s.length()-2);
        s+="]";
        System.out.println(s);
    }
}
