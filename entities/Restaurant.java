package com.example.demo.entities;

public class Restaurant {
    private Long id;
    private String name;
    private Double rating;
    

    public Restaurant(Long id, String name) {
        this.id = id;
        this.name = name;
        this.rating=null;
    }

    public Restaurant(String name){
        this.name=name;
        this.id=null;
        this.rating=null;
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating){
        this.rating=rating;
    }

    @Override
    public String toString() {
        return "Restaurant [id=" + id + ", name="+name+", rating="+rating+"]";
    }
    
}
