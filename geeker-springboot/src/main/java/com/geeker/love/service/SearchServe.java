package com.geeker.love.service;

import com.geeker.love.pojo.Topic;
import com.geeker.love.pojo.User;
import com.geeker.love.pojo.post;
import com.geeker.love.utils.ResultInfo;

import java.util.List;

public interface SearchServe {
    ResultInfo searchUser(String uname,Integer page);
    ResultInfo searchTopic(String keywords, Integer page);
    ResultInfo searchPost(String keywords, Integer page);
}
