package com.geeker.love.controller;

import com.geeker.love.pojo.TopicClass;
import com.geeker.love.service.impl.TopicClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/love/api")
public class TopicClassController {
    @Autowired
    private TopicClassService topicClassService;
    @GetMapping("/tc")
    @ResponseBody
    public List<TopicClass> getTopicClass(){
        return topicClassService.getTopicClass();
    }

}
