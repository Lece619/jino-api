package com.jino.jinoapi.Repository;

import lombok.Data;

@Data
public class StartApi {

    public String Auth_key;
    public Integer problem;
    public Integer time;

    public StartApi(){};

    public StartApi(String auth_key, Integer problem, Integer time) {
        Auth_key = auth_key;
        this.problem = problem;
        this.time = time;
    }
}
