package com.geeker.love.dao;

import com.geeker.love.pojo.Topic;
import com.geeker.love.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface SearchMapper {
    List<User> searchUser(@Param("uname") String uname);
    List<Map> searchPost(@Param("keywords") String keywords);
    List<Topic> searchTopic(@Param("keywords") String keywords);
}
