package com.geeker.love.service.impl;

import com.geeker.love.common.dto.UserBaseInfo;
import com.geeker.love.dao.FollowMapper;
import com.geeker.love.pojo.User;
import com.geeker.love.service.FollowServe;
import com.geeker.love.utils.ResultInfo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FollowService implements FollowServe {
    @Autowired
    private FollowMapper followMapper;

    @Transactional
    public ResultInfo follow(Integer fid, Integer uid) {
        ResultInfo resultInfo=new ResultInfo();
        if(followMapper.getFollowById(fid,uid)!=null){
            resultInfo.setMsg("你已经关注过他了");
            resultInfo.setCode(200);
            return resultInfo;
        }
        followMapper.follow(fid,uid);
        resultInfo.setCode(200);
        resultInfo.setMsg("关注成功");
        return resultInfo;

    }
    @Transactional
    public ResultInfo unFollow(Integer fid, Integer uid) {
        ResultInfo resultInfo=new ResultInfo();
        if(followMapper.getFollowById(fid,uid)==null){
            resultInfo.setMsg("你还没有关注他");
            resultInfo.setCode(200);
            return resultInfo;
        }
        followMapper.follow(fid,uid);
        resultInfo.setCode(200);
        resultInfo.setMsg("已取关");
        return resultInfo;

    }
    public ResultInfo friendList(Integer uid,Integer page){
        ResultInfo resultInfo=new ResultInfo();
        PageHelper.startPage(page,5);
        List<UserBaseInfo> list=  followMapper.friendList(uid);
        resultInfo.setMsg(" 查看成功 ");
        resultInfo.setCode(200);
        resultInfo.setObj(list);
        return resultInfo;

    }


    public ResultInfo likeList(Integer uid, Integer page) {
        ResultInfo resultInfo=new ResultInfo();
        PageHelper.startPage(page,5);
        List<User> list=  followMapper.likeList(uid);
        resultInfo.setMsg(" 查看成功 ");
        resultInfo.setCode(200);
        resultInfo.setObj(list);
        return resultInfo;
    }


    public ResultInfo fansList(Integer uid, Integer page) {
        ResultInfo resultInfo=new ResultInfo();
        PageHelper.startPage(page,5);
        List<User> list=  followMapper.fansList(uid);
        resultInfo.setMsg(" 查看成功 ");
        resultInfo.setCode(200);
        resultInfo.setObj(list);
        return resultInfo;
    }


}
