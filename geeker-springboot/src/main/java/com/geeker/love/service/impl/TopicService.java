package com.geeker.love.service.impl;

import com.geeker.love.dao.TopicMapper;
import com.geeker.love.pojo.Topic;
import com.geeker.love.service.TopicServe;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService implements TopicServe {
    @Autowired
    private TopicMapper topicMapper;
    public List<Topic> get10Topic(){
        return topicMapper.get10Topic();
    }
    public List<Topic> getTopic(Integer tc_id){
        return topicMapper.getTopic(tc_id);
    }
    public List<Topic> getTopicsByPages(Integer tc_id,Integer page){
        PageHelper.startPage(page,5);
        List<Topic> lists = topicMapper.getTopic(tc_id);

        return lists;
    }
}
