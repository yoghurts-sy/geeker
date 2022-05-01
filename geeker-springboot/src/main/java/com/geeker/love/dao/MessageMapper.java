package com.geeker.love.dao;

import com.geeker.love.pojo.MessageBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface MessageMapper {
    boolean sendMessage(@Param("message")MessageBean message);
    List<MessageBean> queryMessage(@Param("from_id") Integer from_id, @Param("to_id") Integer to_id);
    List<Map> queryChatList(@Param("user_id") Integer user_id);
    Map<String, Object> getToUserDetail(@Param("to_id") Long to_id);
    List<Map> queryChatDetails(@Param("from_id") Integer from_id, @Param("to_id") Integer to_id);
}
