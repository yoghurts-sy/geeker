package com.geeker.love.service;

import com.geeker.love.pojo.comment;
import com.geeker.love.pojo.post;
import com.geeker.love.pojo.support;
import com.geeker.love.pojo.topic_post;
import com.geeker.love.utils.ResultInfo;

import java.util.List;
import java.util.Map;

public interface ArticleServe {
    ResultInfo getPostByClass(Integer pc_id,Integer page,Integer uid);
    ResultInfo getPostByClassMulti(Integer pc_id,Integer page);
    ResultInfo getPostByClassMultiRecommendation(String lang, Integer page);
    List<post> getPostByUser(Integer uid,Integer page);
    List<post> getAllPostByUser(Integer uid,Integer page);
    ResultInfo DingCai(Integer uid, Integer pid, Integer type);
    List<Map>  getCommentByPostId(Integer post_id);
    int addPost(post post);
    int addTopicPost(topic_post tp);
    int addComment(comment comment);
    support getSupport(Integer uid, Integer pid);
}
