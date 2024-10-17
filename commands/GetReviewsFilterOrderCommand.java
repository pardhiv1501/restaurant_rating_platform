package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.ReviewService;

public class GetReviewsFilterOrderCommand implements ICommand{

    private final ReviewService reviewService;
    public GetReviewsFilterOrderCommand(ReviewService reviewService){
        this.reviewService=reviewService;
    }

    @Override
    public void invoke(List<String> tokens) {
        Long restroId=Long.parseLong(tokens.get(1));
        Double lowerLimit=Double.parseDouble(tokens.get(2));
        Double higherLimit=Double.parseDouble(tokens.get(3));
        String s=tokens.get(4);
        if(s.equals("RATING_ASC")){
            reviewService.printFilteredReviewsByAsc(restroId,lowerLimit,higherLimit);
        }
        else if(s.equals("RATING_DESC")){
            reviewService.printFilteredReviewsByDesc(restroId,lowerLimit,higherLimit);
        }
        else{
            System.out.println("No such order exists");
        }
        
    }
    
}
