package com.geeker.love.service.impl;

import com.geeker.love.dao.TopicClassMapper;
import com.geeker.love.pojo.TopicClass;
import com.geeker.love.service.TopicClassServe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicClassService implements TopicClassServe {
    @Autowired
    private TopicClassMapper topicClassMapper;
    public List<TopicClass> getTopicClass(){
        return topicClassMapper.getTopicClass();
    }
}
