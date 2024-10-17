package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.Review;

public interface IReviewRepository {
    Review save(Review review);
    boolean existsById(Long id);
    Optional<Review> findById(Long id);
    List<Review> findAll();
    void deleteById(Long id);
    long count();
}
