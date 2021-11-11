package com.geeker.love.dao;

import com.geeker.love.pojo.Topic;
import com.geeker.love.pojo.post;
import com.geeker.love.pojo.support;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArticleMapper {
    List<post> getPostByClass(@Param("pc_id") Integer pc_id);
    List<post> getPostByUser(@Param("uid") Integer uid);
    List<post> getAllPostByUser(@Param("uid") Integer uid);
    post getPostById(@Param("pid") Integer pid);
    List<support> getSupportById(@Param("uid") Integer uid);
    int DingCai(@Param("uid") Integer uid,
                    @Param("pid") Integer pid,
                    @Param("type") Integer type);
    support getSupport(@Param("uid")Integer uid,
                       @Param("pid") Integer pid);
    int updateSupport(@Param("uid") Integer uid,
                      @Param("pid") Integer pid,
                      @Param("type") Integer type);
}
