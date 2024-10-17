package com.example.demo.entities;

public class Review {
    private Long id;
    private User user;
    private Restaurant restaurant;
    private Double rating;
    private String review;

    public Review(Long id, User user, Restaurant restaurant, Double rating) {
        this.id = id;
        this.user = user;
        this.restaurant = restaurant;
        this.rating = rating;
        this.review=null;
    }

    public Review(User user, Restaurant restaurant, Double rating) {
        this.user = user;
        this.restaurant = restaurant;
        this.rating = rating;
        this.id=null;
        this.review=null;
    }

    public Long getId() {
        return id;
    }
    public User getUser() {
        return user;
    }
    public Restaurant getRestaurant() {
        return restaurant;
    }
    public Double getRating(){
        return rating;
    }
    public String getReview(){
        return review;
    }

    public static User getName() {
        return null;
    }
    
}
