package com.geeker.love.service;

import com.geeker.love.pojo.Topic;
import com.geeker.love.pojo.User;
import com.geeker.love.pojo.post;

import java.util.List;

public interface SearchServe {
    List<User> searchUser(String uname,Integer page);
    List<Topic> searchTopic(String keywords, Integer page);
    List<post> searchPost(String keywords, Integer page);
}
