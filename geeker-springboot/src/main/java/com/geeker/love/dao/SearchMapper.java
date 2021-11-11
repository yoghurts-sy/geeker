package com.geeker.love.dao;

import com.geeker.love.pojo.Topic;
import com.geeker.love.pojo.User;
import com.geeker.love.pojo.post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SearchMapper {
    List<User> searchUser(@Param("uname") String uname);
    List<post> searchPost(@Param("keywords") String keywords);
    List<Topic> searchTopic(@Param("keywords") String keywords);
}
