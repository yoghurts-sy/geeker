package com.geeker.love.service;

import com.geeker.love.pojo.post;
import com.geeker.love.utils.ResultInfo;

import java.util.List;

public interface ArticleServe {
    ResultInfo getPostByClass(Integer pc_id,Integer page,Integer uid);
    List<post> getPostByUser(Integer uid,Integer page);
    List<post> getAllPostByUser(Integer uid,Integer page);
    ResultInfo DingCai(Integer uid, Integer pid, Integer type);
}
