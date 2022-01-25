package com.geeker.love.dao;

import com.geeker.love.pojo.adsense;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdsenseMapper {
    List<adsense> getAd(@Param("type") Integer type);
}
