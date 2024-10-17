package com.example.demo.repositories;

import java.util.*;
import java.util.stream.Collectors;
import com.example.demo.entities.Review;

public class ReviewRepository implements IReviewRepository{

    private final Map<Long,Review> reviewMap;
    private Long autoincrement=1L;
    private final RestaurantRepository restaurantRepository;

    public ReviewRepository(RestaurantRepository restaurantRepository){
        reviewMap=new HashMap<Long,Review>();
        this.restaurantRepository=restaurantRepository;
    }
    
    @Override
    public Review save(Review review) {
        review=new Review(autoincrement, review.getUser(),review.getRestaurant(),review.getRating());
        reviewMap.put(autoincrement, review);
        ++autoincrement;
        restaurantRepository.updateRestroReviews(review);
        return review;
    }

    public List<Review> getFilteredListByAsc(Long restroId, Double lowerLimit, Double higherLimit){
        List<Review> l=restaurantRepository.getFilteredList(restroId,lowerLimit,higherLimit);
        l.sort(Comparator.comparingDouble(Review::getRating));
        return l;
    }

    public List<Review> getFilteredListByDesc(Long restroId, Double lowerLimit, Double higherLimit){
        List<Review> l=restaurantRepository.getFilteredList(restroId,lowerLimit,higherLimit);
        l.sort(Comparator.comparingDouble(Review::getRating).reversed());
        return l;
    }

    public List<Review> getListByAsc(Long restroId){
        List<Review> l=restaurantRepository.getListofReviews(restroId);
        l.sort(Comparator.comparingDouble(Review::getRating));
        return l;
    }

    public List<Review> getListByDesc(Long restroId){
        List<Review> l=restaurantRepository.getListofReviews(restroId);
        l.sort(Comparator.comparingDouble(Review::getRating).reversed());
        return l;
    }

    @Override
    public boolean existsById(Long id) {
        return reviewMap.containsKey(id);
    }

    @Override
    public Optional<Review> findById(Long id) {
        return Optional.ofNullable(reviewMap.get(id));
    }

    @Override
    public List<Review> findAll() {
        return reviewMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        reviewMap.remove(id);
    }

    @Override
    public long count() {
        return reviewMap.size();
    }
    
}
