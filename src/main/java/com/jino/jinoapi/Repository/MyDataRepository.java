package com.jino.jinoapi.Repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Repository
@Slf4j
@RequiredArgsConstructor
public class MyDataRepository {

    private final MakeId makeId;
    private final RestTemplate restTemplate;

    private static String id;

    @PostConstruct
    private void init(){
//        makeId.makeMember();
        setId();
    }

    private void setId(){
        log.info("start setId");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.set("X-Auth-Token","bf2cad0b872ea0fbbf5424340473f50b");
        HttpEntity<StartApi> request = new HttpEntity<>(new StartApi("",1,0), httpHeaders);
        StartApi forObject = restTemplate.postForObject("https://huqeyhi95c.execute-api.ap-northeast-2.amazonaws.com/prod/start", request, StartApi.class);
        log.info("id = {}", forObject.getAuth_key());
        this.id = forObject.getAuth_key();
    }

    public String getId(){
        return id;
    }

    @Component
    @RequiredArgsConstructor
    static class MakeId {

        private final RestTemplate restTemplate;

        public void makeMember(){
            log.info("start setId");
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            httpHeaders.set("X-Auth-Token","bf2cad0b872ea0fbbf5424340473f50b");
            HttpEntity<StartApi> request = new HttpEntity<>(new StartApi("",1,0), httpHeaders);
            StartApi forObject = restTemplate.postForObject("https://huqeyhi95c.execute-api.ap-northeast-2.amazonaws.com/prod/start", request, StartApi.class);
            log.info("id = {}", forObject.getAuth_key());
        }

    }
}
