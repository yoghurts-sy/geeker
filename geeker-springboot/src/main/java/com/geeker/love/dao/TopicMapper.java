package com.geeker.love.dao;

import com.geeker.love.pojo.Topic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TopicMapper {
    List<Topic> get10Topic();
    List<Topic> getTopic(@Param("TC_id") Integer TC_id);
}
