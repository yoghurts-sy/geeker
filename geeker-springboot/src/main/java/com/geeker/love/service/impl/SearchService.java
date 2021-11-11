package com.geeker.love.service.impl;

import com.geeker.love.dao.SearchMapper;
import com.geeker.love.pojo.Topic;
import com.geeker.love.pojo.User;
import com.geeker.love.pojo.post;
import com.geeker.love.service.SearchServe;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService implements SearchServe {
    @Autowired
    private SearchMapper searchMapper;


    public List<User> searchUser(String uname, Integer page) {
        PageHelper.startPage(page,5);
        List<User> lists=searchMapper.searchUser(uname);
        return lists;
    }

    public List<post> searchPost(String keywords, Integer page) {
        PageHelper.startPage(page,5);
        List<post> lists = searchMapper.searchPost(keywords);
        return lists;
    }

    public List<Topic> searchTopic(String keywords, Integer page) {
        PageHelper.startPage(page,5);
        List<Topic> lists = searchMapper.searchTopic(keywords);
        return lists;
    }
}
