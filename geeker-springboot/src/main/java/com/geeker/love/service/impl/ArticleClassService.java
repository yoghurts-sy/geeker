package com.geeker.love.service.impl;

import com.geeker.love.dao.ArticleClassMapper;
import com.geeker.love.pojo.ArticleClass;

import com.geeker.love.service.ArticleClassServe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArticleClassService implements ArticleClassServe {
    @Autowired
    private ArticleClassMapper articleClassMapper;
    public List<ArticleClass> GetArticleClass() {
        List<ArticleClass> ac = articleClassMapper.getArticleClass();
        return ac;
    }
}
