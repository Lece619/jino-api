package com.jino.jinoapi.controller;

import com.jino.jinoapi.Repository.MyDataRepository;
import com.jino.jinoapi.Repository.StartApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class BasicController {

    private final MyDataRepository myDataRepository;

    @GetMapping("/getId")
    public String findId(){
        return myDataRepository.getId();
    }
}
