package com.jino.jinoapi.Repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Repository
@RequiredArgsConstructor
@Slf4j
public class MyDataRepository {

    private final StartAPI startAPI;
    private final RestTemplate restTemplate;
    private String id = "";

    @PostConstruct
    private void init(){
        setId();
    }

    private void setId(){

    }

    public String getId(){
        return id;
    }

    @Component
    static class StartAPI{

        public void getID(){

        }
    }
}
