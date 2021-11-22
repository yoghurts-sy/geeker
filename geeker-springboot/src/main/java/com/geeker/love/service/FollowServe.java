package com.geeker.love.service;

import com.geeker.love.common.dto.UserBaseInfo;
import com.geeker.love.pojo.User;
import com.geeker.love.utils.ResultInfo;

import java.util.List;

public interface FollowServe {
    ResultInfo follow(Integer fid,Integer uid);
    ResultInfo unFollow(Integer fid,Integer uid);
    ResultInfo friendList(Integer uid, Integer page);
    ResultInfo likeList(Integer uid,Integer page);
    ResultInfo fansList(Integer uid,Integer page);
}
