package com.jino.jinoapi.Repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserRepository {

    private static Map<String, User> userMap = new HashMap<>();

    public void addUser(User user){
        userMap.put(user.getId(), user);
    }

    public Optional<User> findById(String id){
        return Optional.ofNullable(userMap.get(id));
    }
}
