package com.geeker.love.controller;

import com.geeker.love.pojo.ArticleClass;
import com.geeker.love.service.impl.ArticleClassService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/love/api")
public class ArticleClassController {
    @Autowired
    private ArticleClassService articleClassService;
    @GetMapping("/pc")
    @ResponseBody
    public List<ArticleClass> getAC(){
        List<ArticleClass> ac=articleClassService.GetArticleClass();
        return ac;
    }

}
