package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.ReviewService;

public class GetReviewsCommand implements ICommand{

    private final ReviewService reviewService;
    public GetReviewsCommand(ReviewService reviewService){
        this.reviewService=reviewService;
    }

    @Override
    public void invoke(List<String> tokens) {
        Long restroId=Long.parseLong(tokens.get(1));
        String s=tokens.get(2);
        if(s.equals("RATING_ASC")){
            reviewService.printReviewsByAsc(restroId);
        }
        else if(s.equals("RATING_DESC")){
            reviewService.printReviewsByDesc(restroId);
        }
        else{
            System.out.println("No Such order exists");
        }
    }
    
}
