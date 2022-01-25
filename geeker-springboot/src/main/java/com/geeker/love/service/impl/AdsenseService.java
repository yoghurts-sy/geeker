package com.geeker.love.service.impl;

import com.geeker.love.dao.AdsenseMapper;
import com.geeker.love.pojo.adsense;

import com.geeker.love.service.AdsenseServe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdsenseService implements AdsenseServe {
    @Autowired
    private AdsenseMapper adsenseMapper;
    public List<adsense> getAd(Integer type){
        System.out.println("==========666==========");
        return adsenseMapper.getAd(type);
    }
}