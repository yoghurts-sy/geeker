package com.geeker.love.service;

import com.geeker.love.pojo.adsense;

import java.util.List;

public interface AdsenseServe {
    List<adsense> getAd(Integer type);
}