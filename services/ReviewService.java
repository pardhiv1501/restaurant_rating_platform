package com.example.demo.services;

import java.util.*;
import com.example.demo.entities.Restaurant;
import com.example.demo.entities.Review;
import com.example.demo.entities.User;
import com.example.demo.repositories.RestaurantRepository;
import com.example.demo.repositories.ReviewRepository;
import com.example.demo.repositories.UserRepository;

public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;

    public ReviewService(ReviewRepository reviewRepository, UserRepository userRepository, RestaurantRepository restaurantRepository){
        this.reviewRepository=reviewRepository;
        this.userRepository=userRepository;
        this.restaurantRepository=restaurantRepository;
    }

    public Review create(User user, Restaurant restaurant,Double rating){
        Review r=new Review(user, restaurant, rating);
        return reviewRepository.save(r);
    }

    public Review create(Long userId, Long restaurantId, Double rating){
        Optional<User> opuser=userRepository.findById(userId);
        Optional<Restaurant> oprest=restaurantRepository.findById(restaurantId);
        User u=opuser.isPresent()?opuser.get():null;
        Restaurant r=oprest.isPresent()?oprest.get():null;
        if(u==null)throw new NoSuchElementException("No such user in the repository");
        if(r==null)throw new NoSuchElementException("No such restaurant in the repository");
        return this.create(u, r, rating);
    }

    public void printFilteredReviewsByAsc(Long restroId, Double lowerLimit, Double higherLimit) {
        List<Review> listOfReviews = reviewRepository.getFilteredListByAsc(restroId, lowerLimit, higherLimit);
        
        if (listOfReviews.isEmpty()) {
            System.out.println("[]");
            return;
        }
    
        StringBuilder sb = new StringBuilder("[");
        for (Review r : listOfReviews) {
            sb.append("Review [id=").append(r.getId()).append("], ");
        }
        
        // Remove the trailing comma and space
        sb.setLength(sb.length() - 2);
        sb.append("]");
        
        System.out.println(sb.toString());
    }
    

    public void printFilteredReviewsByDesc(Long restroId, Double lowerLimit, Double higherLimit) {
        List<Review> listOfReviews = reviewRepository.getFilteredListByDesc(restroId, lowerLimit, higherLimit);
        
        if (listOfReviews.isEmpty()) {
            System.out.println("[]");
            return;
        }
    
        StringBuilder sb = new StringBuilder("[");
        for (Review r : listOfReviews) {
            sb.append("Review [id=").append(r.getId()).append("], ");
        }
        
        // Remove the trailing comma and space
        sb.setLength(sb.length() - 2);
        sb.append("]");
        
        System.out.println(sb.toString());
    }
    

    public void printReviewsByAsc(Long restroId){
        List<Review> listOfReviews=reviewRepository.getListByAsc(restroId);
        String s="[";
        for(Review r:listOfReviews){
            s+="Review [id="+r.getId()+"], ";
        }
        s=s.substring(0,s.length()-2);
        s+="]";
        System.out.println(s);
    }

    public void printReviewsByDesc(Long restroId){
        List<Review> listOfReviews=reviewRepository.getListByDesc(restroId);
        String s="[";
        for(Review r:listOfReviews){
            s+="Review [id="+r.getId()+"], ";
        }
        s=s.substring(0,s.length()-2);
        s+="]";
        System.out.println(s);
    }

    public Review getReviewById(Long id){
        return reviewRepository.findById(id).orElseThrow();
    }
}
