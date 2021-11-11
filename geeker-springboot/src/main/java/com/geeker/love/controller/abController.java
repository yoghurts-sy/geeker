package com.geeker.love.controller;

import com.geeker.love.pojo.absense;
import com.geeker.love.service.impl.AbsenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/love/api")
public class abController {
    @Autowired
    private AbsenseService absenseService;
    @GetMapping("/ab")
    public List<absense> getAb(Integer type){
    return absenseService.getAb(type);



    }
}
