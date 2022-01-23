package com.geeker.love.dao;

import com.geeker.love.common.dto.UserBaseInfo;
import com.geeker.love.pojo.User;
import com.geeker.love.pojo.follow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FollowMapper {
    int follow(@Param("fid")Integer fid,@Param("uid") Integer uid);
    follow getFollowById(@Param("fid") Integer fid,@Param("uid") Integer uid);
    int unFollow(@Param("fid")Integer fid,@Param("uid") Integer uid);
    List<UserBaseInfo> friendList(@Param("uid") Integer uid);
    List<User> likeList(@Param("uid") Integer uid);
    List<User> fansList(@Param("uid") Integer uid);
}
