package com.example.demo.commands;

public enum CommandKeyword {

    // Register Command Keywords
    CREATE_GREETING_COMMAND("CREATE_GREETING"),
    LIST_GREETING_COMMAND ("LIST_GREETING"),
    GET_GREETING_COMMAND ("GET_GREETING"),

    REGISTER_USER_COMMAND("REGISTER_USER"),
    ADD_RATING_COMMAND("ADD_RATING"),
    REGISTER_RESTAURANT_COMMAND("REGISTER_RESTAURANT"),
    GET_REVIEWS_COMMAND("GET_REVIEWS"),
    GET_REVIEWS_FILTER_ORDER_COMMAND("GET_REVIEWS_FILTER_ORDER"),
    DESCRIBE_RESTAURANT_COMMAND("DESCRIBE_RESTAURANT"),
    LIST_RESTAURANT_COMMAND("LIST_RESTAURANT");

    private final String name;
    private CommandKeyword(String name){
        this.name = name;
    }

    public String getName() {
        return name;
     } 
}
