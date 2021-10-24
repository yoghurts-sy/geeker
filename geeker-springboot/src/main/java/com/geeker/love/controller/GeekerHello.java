package com.geeker.love.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/love/api")
public class GeekerHello {
    @ResponseBody
    @GetMapping("/hello")
    public String Hello() {
        return "Hello Geeker!";
    }
}
