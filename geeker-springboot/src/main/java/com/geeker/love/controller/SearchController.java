package com.geeker.love.controller;

import com.geeker.love.pojo.Topic;
import com.geeker.love.pojo.User;
import com.geeker.love.pojo.post;
import com.geeker.love.service.impl.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/love/api")
public class SearchController {
    @Autowired
    private SearchService searchService;
    @GetMapping("/scuser")
    @ResponseBody
    public List<User> searchUser(String uname,Integer pageNum){
        String name="%"+uname+"%";
        List<User> users=searchService.searchUser(name,pageNum);
        return users;
    }

    @GetMapping("/scpost")
    @ResponseBody
    public List<post> searchPost(@RequestParam String keyword,
                                 @RequestParam Integer pageNum)
    {
        String keywords="%"+keyword+"%";
        List<post> posts= searchService.searchPost(keywords,pageNum);
        return posts;
    }

    @GetMapping("/sctopic")
    @ResponseBody
    public List<Topic> searchTopic(@RequestParam String keyword,
                                   @RequestParam Integer pageNum)
    {
        String keywords="%"+keyword+"%";
        List<Topic> topics= searchService.searchTopic(keywords,pageNum);
        return topics;
    }

}
