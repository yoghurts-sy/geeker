package com.geeker.love.service.impl;

import com.geeker.love.dao.SearchMapper;
import com.geeker.love.pojo.Topic;
import com.geeker.love.pojo.User;
import com.geeker.love.pojo.post;
import com.geeker.love.service.SearchServe;
import com.geeker.love.utils.ResultInfo;
import com.github.pagehelper.PageHelper;
//import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService implements SearchServe {
    @Autowired
    private SearchMapper searchMapper;


    public ResultInfo searchUser(String uname, Integer page) {
        PageHelper.startPage(page,5);
        ResultInfo res = ResultInfo.success(searchMapper.searchUser(uname));
        return res;
    }

    public ResultInfo searchPost(String keywords, Integer page) {
        PageHelper.startPage(page,5);
        ResultInfo res = ResultInfo.success(searchMapper.searchPost(keywords));
        return res;
    }

    public ResultInfo searchTopic(String keywords, Integer page) {
        PageHelper.startPage(page,5);
        ResultInfo res = ResultInfo.success(searchMapper.searchTopic(keywords));
        return res;
    }
}
