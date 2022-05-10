package com.geeker.love.controller.index;


import com.geeker.love.pojo.comment;
import com.geeker.love.service.ArticleServe;
import com.geeker.love.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
    @PostMapping("/addcomments")
    public ResultInfo addComments(@RequestBody comment comment){
        String time= String.valueOf(new Date().getTime()).substring(0,10);
        Long create_time=Long.parseLong(time);
        comment.setCreate_time(create_time);
        int n=articleServe.addComment(comment);
        if(n!=0){
            return ResultInfo.success("评论成功");
        }else{
            return ResultInfo.fail("评论失败");
        }
    }
}
