package com.geeker.love.service.impl;

import com.geeker.love.dao.ArticleMapper;
import com.geeker.love.pojo.post;
import com.geeker.love.pojo.support;
import com.geeker.love.service.ArticleServe;
import com.geeker.love.utils.ResultInfo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticleService implements ArticleServe {
    @Autowired
    private ArticleMapper articleMapper;


    /**
     * 实现多表联查
     *      1. 通过user_id查username和userpic
     *      2. 通过post_id查comment
     *      3. 通过post_id查support
     */
    public ResultInfo getPostByClass(Integer pc_id,Integer page,Integer uid) {
        ResultInfo resultInfo = new ResultInfo();
        PageHelper.startPage(page,5);
        if(uid!=0){
            resultInfo.setCode(200);
            resultInfo.setObj(articleMapper.getSupportById(uid));
            resultInfo.setObj2(articleMapper.getPostByClass(pc_id));
            return resultInfo;
        }
        resultInfo.setObj(articleMapper.getPostByClass(pc_id));
        return resultInfo;
    }

    public ResultInfo getPostByClassMulti(Integer pc_id,Integer page) {
        ResultInfo resultInfo = new ResultInfo();
        PageHelper.startPage(page,5);
        List<Map<String, Object>> res = articleMapper.getPostByClassMulti(pc_id);
        resultInfo.setObj(res);
        return resultInfo;
    }


    public List<post> getPostByUser(Integer uid, Integer page) {
        PageHelper.startPage(page,5);
        List<post> lists=articleMapper.getPostByUser(uid);
        return lists;
    }

    public List<post> getAllPostByUser(Integer uid, Integer page) {
        PageHelper.startPage(page,5);
        List<post> lists=articleMapper.getAllPostByUser(uid);
        return lists;
    }

    @Transactional
    public ResultInfo DingCai(Integer uid, Integer pid, Integer type) {
        ResultInfo resultInfo=new ResultInfo();
        if(articleMapper.getPostById(pid)==null){
            resultInfo.setCode(400);
            resultInfo.setMsg("文章不存在");
            return resultInfo;
        }
        support support=articleMapper.getSupport(uid,pid);
        if(support==null){
            articleMapper.DingCai(uid,pid,type);
            resultInfo.setCode(200);
            resultInfo.setMsg("成功");
            return resultInfo;
        }
        if(support.getType()==type){
            resultInfo.setCode(200);
            resultInfo.setMsg("请勿重复操作");
        }else{
            articleMapper.updateSupport(uid,pid,type);
            resultInfo.setCode(200);
            resultInfo.setMsg("成功");
        }
        return resultInfo;
    }


    @Override
    public List<Map> getCommentByPostId(Integer post_id) {
        List<Map> res = articleMapper.getCommentsByPostId(post_id);
        return res;
    }

    @Override
    public int addPost(post post) {
        return articleMapper.addPost(post);
    }


}
