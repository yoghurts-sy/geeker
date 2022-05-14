package com.geeker.love.dao;

import com.geeker.love.pojo.Topic;
import com.geeker.love.pojo.post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface TopicMapper {
    List<Topic> get10Topic();
    List<Topic> getTopic(@Param("TC_id") Integer TC_id);
    List<post> getPostByTopic(@Param("topic_id") Integer topic_id);
    List<Map<String, Object>> getPostByTopicId(@Param("topic_id") Integer topic_id);
}
