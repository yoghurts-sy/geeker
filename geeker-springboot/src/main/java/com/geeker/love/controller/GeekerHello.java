package com.geeker.love.controller;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
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


    @ResponseBody
    @RequiresAuthentication // 需要请求头里带token，才可以访问
    @GetMapping("/shiro")
    public String Shiro() {
        return "Hello Shiro!";
    }
}
