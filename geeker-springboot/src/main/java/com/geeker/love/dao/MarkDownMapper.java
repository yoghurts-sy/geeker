package com.geeker.love.dao;

import com.geeker.love.pojo.MarkDown;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MarkDownMapper {
    boolean upload(@Param("markDown")MarkDown markDown);
    List<MarkDown> getMd();
}
