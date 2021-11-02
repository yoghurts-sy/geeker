package com.geeker.love.dao;

import com.geeker.love.pojo.TopicClass;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TopicClassMapper {
    List<TopicClass> getTopicClass();
}
