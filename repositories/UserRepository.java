package com.example.demo.repositories;

import java.util.*;
import java.util.stream.Collectors;
import com.example.demo.entities.User;

public class UserRepository implements IUserRepository{

    private final Map<Long,User> userMap;
    private Long autoincrement=1L;

    public UserRepository(){
        userMap=new HashMap<Long,User>();
    }
    
    @Override
    public User save(User user) {
        user=new User(autoincrement, user.getName());
        userMap.put(autoincrement, user);
        ++autoincrement;
        return user;
    }

    @Override
    public boolean existsById(Long id) {
        return userMap.containsKey(id);
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(userMap.get(id));
    }

    @Override
    public List<User> findAll() {
        return userMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        userMap.remove(id);
    }

    @Override
    public long count() {
        return userMap.size();
    }
    
}
