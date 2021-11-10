package com.geeker.love.service;

import com.geeker.love.pojo.Topic;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface TopicServe {
    public List<Topic> get10Topic();
    public List<Topic> getTopic(Integer tc_id);
    List<Topic> getTopicsByPages(Integer tc_id,Integer page);
}
