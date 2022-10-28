package com.jino.jinoapi.Repository;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {

    private String id;
    private Integer grade;

    public User(){}

    public User(String id, Integer grade) {
        this.id = id;
        this.grade = grade;
    }
}
