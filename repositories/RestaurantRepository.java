package com.example.demo.repositories;

import java.util.*;
import java.util.stream.Collectors;
import com.example.demo.entities.Restaurant;
import com.example.demo.entities.Review;

public class RestaurantRepository implements IRestaurantRepository{

    private final Map<Long,Restaurant> restaurantMap;
    private Long autoincrement=1L;
    private final Map<Long,List<Review>> restroReviews;

    public RestaurantRepository(){
        restaurantMap=new HashMap<Long,Restaurant>();
        restroReviews=new HashMap<Long,List<Review>>();
    }
    
    @Override
    public Restaurant save(Restaurant restaurant) {
        restaurant=new Restaurant(autoincrement, restaurant.getName());
        restaurantMap.put(autoincrement, restaurant);
        ++autoincrement;
        return restaurant;
    }

    public void updateRestroReviews(Review review) {
        Restaurant r = review.getRestaurant();
        if (r == null) {
            throw new IllegalArgumentException("Review must be associated with a valid restaurant.");
        }
    
        Long restroId = r.getId();
        if (restroId == null || !restroReviews.containsKey(restroId)) {
            restroReviews.putIfAbsent(restroId, new ArrayList<>());
        }
    
        int rc = restroReviews.get(restroId).size();
        restroReviews.get(restroId).add(review);
    
        if (rc == 0) {
            r.setRating(review.getRating());
        } else {
            double newRating = ((rc * r.getRating()) + review.getRating()) / (rc + 1);
            newRating = Math.round(newRating * 10.0) / 10.0;
            r.setRating(newRating);
        }
    }
    

    public List<Review> getListofReviews(Long restroId){
        return restroReviews.get(restroId);
    }

    public List<Review> getFilteredList(Long restroId, Double ll, Double hl){
        List<Review> l=restroReviews.get(restroId);
        List<Review> fl=new ArrayList<Review>();
        for(Review r:l){
            if(r.getRating()<=hl && r.getRating()>=ll){
                fl.add(r);
            }
        }
        return fl;
    }

    @Override
    public boolean existsById(Long id) {
        return restaurantMap.containsKey(id);
    }

    @Override
    public Optional<Restaurant> findById(Long id) {
        return Optional.ofNullable(restaurantMap.get(id));
    }

    @Override
    public List<Restaurant> findAll() {
        return restaurantMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        restaurantMap.remove(id);
    }

    @Override
    public long count() {
        return restaurantMap.size();
    }
    
}
