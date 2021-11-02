package com.geeker.love.dao;

import com.geeker.love.pojo.ArticleClass;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleClassMapper {
    List<ArticleClass> getArticleClass();
}
