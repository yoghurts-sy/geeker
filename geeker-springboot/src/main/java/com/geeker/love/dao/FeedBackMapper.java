package com.geeker.love.dao;

import com.geeker.love.pojo.feedback;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FeedBackMapper {
    void FeedBack(@Param("from_id")Integer from_id,@Param("data") String data);
    List<feedback> getFeedBack(@Param("fid") Integer fid);
}
