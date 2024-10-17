package com.example.demo.entities;

public class User {
    private Long id;
    private String name;

    public User(Long id, String name){
        this.id=id;
        this.name=name;
    }

    public User(String name){
        this(null,name);
    }

    public Long getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

}
