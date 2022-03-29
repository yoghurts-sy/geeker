package com.geeker.love.controller.index;


import com.geeker.love.service.ArticleServe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/love/api")
public class CommentController {

    @Autowired
    private ArticleServe articleServe;


    @GetMapping("/comments")
    public List<Map> getCommentsByPostId(Integer post_id) {
        return articleServe.getCommentByPostId(post_id);
    }
}
