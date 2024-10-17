package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Review;
import com.example.demo.services.ReviewService;

public class AddRatingCommand implements ICommand{

    private final ReviewService reviewService;
    public AddRatingCommand(ReviewService reviewService){
        this.reviewService=reviewService;
    }
    @Override
    public void invoke(List<String> tokens) {
        Double rating=Double.parseDouble(tokens.get(1));
        Long userId=Long.parseLong(tokens.get(2));
        Long restaurantId=Long.parseLong(tokens.get(3));
        Review review=reviewService.create(userId,restaurantId,rating);
        System.out.println("Review [id="+review.getId()+"] added successfully for Restaurant [id="+restaurantId+"] by User [id="+userId+"]!");
    }
    
}
