package com.geeker.love.dao;


import com.geeker.love.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    User queryUserByPhone(String phone);
    Integer insertUserByPhone(@Param("phone") String phone,@Param("create_time") Long create_time);
    User queryUserByUserId(Integer id);
}
