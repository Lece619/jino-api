package com.jino.jinoapi.Repository;

import com.jino.jinoapi.consts.ConstInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;

@Repository
@Slf4j
@RequiredArgsConstructor
public class MyDataRepository {

    private final RestTemplate restTemplate;

    private static String id;

    @PostConstruct
    private void init(){
//        makeId.makeMember();
        setId();
        getWaitLine();
        gameStart();
        getWaitLine();

    }

    private void setId(){

        log.info("start setId");

        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.set("X-Auth-Token","bf2cad0b872ea0fbbf5424340473f50b");
        HttpEntity<StartApi> request = new HttpEntity<>(new StartApi("",1,0), httpHeaders);
        StartApi forObject = restTemplate.postForObject(ConstInfo.BASE_URL + "/start", request, StartApi.class);

        log.info("id = {}", forObject.getAuth_key());
        this.id = forObject.getAuth_key();
    }

    private void getWaitLine(){
        log.info("waitLine");

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", this.id);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<String>("", httpHeaders);

//        String forObject = restTemplate.getForObject(ConstInfo.BASE_URL + "/waiting_line", String.class, entity);
        ResponseEntity<String> exchange = restTemplate.exchange(ConstInfo.BASE_URL + "/waiting_line", HttpMethod.GET, request, String.class);
        String body = exchange.getBody();
        log.info("wain line = {}", body);

    }

    private  void gameStart(){
        log.info(" game Start matching start in ZeroTime");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", this.id);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        MultiValueMap<String, Integer[]> body = new LinkedMultiValueMap<>();
        body.add("pairs", null);

        HttpEntity<MultiValueMap> request = new HttpEntity<>(body, httpHeaders);

        ResponseEntity<String> exchange = restTemplate.exchange(ConstInfo.BASE_URL + "/match", HttpMethod.PUT, request, String.class);

        String body1 = exchange.getBody();
        log.info("game start = {}", body1);

    }

    public String getId(){
        return id;
    }


}
