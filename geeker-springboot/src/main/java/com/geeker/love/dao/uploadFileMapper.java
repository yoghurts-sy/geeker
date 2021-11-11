package com.geeker.love.dao;

import com.geeker.love.pojo.image;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface uploadFileMapper {
    void uploadPics(@Param("pics") List<image> pics);
}
