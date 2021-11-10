package com.geeker.love.controller;
import com.geeker.love.pojo.Topic;
import com.geeker.love.service.impl.TopicService;
import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/love/api")
public class TopicController {
    @Autowired
    private TopicService topicService;

    @GetMapping("/top10")
    @ResponseBody
    public List<Topic> get10Topic(){
        return topicService.get10Topic();
    }

    @GetMapping("/topic")
    @ResponseBody
    public List<Topic> getTopicsByPages(@RequestParam Integer tc_id,
                                        @RequestParam Integer pageNum)
    {

        List<Topic> topics= topicService.getTopicsByPages(tc_id,pageNum);
        return topics;
    }
}
