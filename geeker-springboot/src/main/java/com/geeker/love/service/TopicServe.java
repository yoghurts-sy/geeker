package com.geeker.love.service;

import com.geeker.love.pojo.Topic;
import com.geeker.love.pojo.post;
import com.geeker.love.utils.ResultInfo;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface TopicServe {
    List<Topic> get10Topic();
    List<Topic> getTopic(Integer tc_id);
    List<Topic> getTopicsByPages(Integer tc_id,Integer page);
    List<post> getPostByTopic(Integer tid,Integer page);
    ResultInfo getTopicByTopicId(Integer topic_id,Integer page);
}
