package com.geeker.love.controller;

import com.geeker.love.pojo.adsense;
import com.geeker.love.service.impl.AdsenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/love/api")
public class AdController {
    @Autowired
    private AdsenseService adsenseService;
    @GetMapping("/ad")
    public List<adsense> getAd(Integer type){
    return adsenseService.getAd(type);



    }
}
