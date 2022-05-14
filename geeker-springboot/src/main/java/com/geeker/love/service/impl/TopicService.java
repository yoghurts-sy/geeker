package com.geeker.love.service.impl;

import com.geeker.love.dao.TopicMapper;
import com.geeker.love.pojo.Topic;
import com.geeker.love.pojo.post;
import com.geeker.love.service.TopicServe;
import com.geeker.love.utils.ResultInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
    public List<post> getPostByTopic(Integer tid, Integer page) {
        PageHelper.startPage(page,5);
        List<post> lists = topicMapper.getPostByTopic(tid);
        return lists;
    }

    @Override
    public ResultInfo getTopicByTopicId(Integer topic_id, Integer page) {
        ResultInfo resultInfo = new ResultInfo();
        PageHelper.startPage(page,5);
        List<Map<String, Object>> res = topicMapper.getPostByTopicId(topic_id);
        List<Map<String, Object>> newRes = new ArrayList<>();
        for (Map<String, Object> re : res) {
            String language = (String)re.get("language");
            List<String> languages = new ArrayList<>();
            if (language != null && !language.equals("")) {
                String[] split = language.split(":");
                languages.addAll(Arrays.asList(split));
            }
            re.put("language", languages);
            newRes.add(re);
        }

        resultInfo.setObj(newRes);
        return resultInfo;
    }


}
