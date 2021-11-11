package com.geeker.love.dao;

import com.geeker.love.pojo.absense;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AbsenseMapper {
    List<absense> getAb(@Param("type") Integer type);
}
