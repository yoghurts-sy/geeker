package com.geeker.love.controller;

import com.geeker.love.pojo.Topic;
import com.geeker.love.pojo.post;
import com.geeker.love.service.ArticleServe;
import com.geeker.love.service.impl.ArticleService;
import com.geeker.love.utils.ResultInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/love/api")
public class ArticleController {
    @Autowired
    private ArticleServe articleService;
    @GetMapping("/getpost")
    @ResponseBody
    public ResultInfo getPostByClass(Integer pc_id, Integer page, String token){
        System.out.println(pc_id + " " + page);
        ResultInfo resultInfo=new ResultInfo();
        if(token==null){
           //return articleService.getPostByClass(pc_id, page,0);
           return articleService.getPostByClassMulti(pc_id, page);
        }
        /**
         * 实现多表联查
         *      1. 通过user_id查username和userpic
         *      2. 通过post_id查comment
         *      3. 通过post_id查support
         */

        Claims claims= (Claims) Jwts.parser()
                .setSigningKey("geek")
                .parse(token)
                .getBody();
        int uid=Integer.parseInt(claims.getId());
        return articleService.getPostByClass(pc_id,page,uid);
    }

    @GetMapping("/openpost")
    @ResponseBody
    public ResultInfo getPostByUser(Integer uid,Integer page){
        ResultInfo resultInfo=new ResultInfo();
        resultInfo.setObj(articleService.getPostByUser(uid,page));
        resultInfo.setMsg("获取成功");
        resultInfo.setCode(200);
        return resultInfo;
    }

    @GetMapping("/allpost")
    @ResponseBody
    public ResultInfo getAllPostByUser(Integer uid,Integer page){
        ResultInfo resultInfo=new ResultInfo();
        resultInfo.setObj(articleService.getAllPostByUser(uid,page));
        resultInfo.setMsg("获取成功");
        resultInfo.setCode(200);
        return resultInfo;
    }

    @PostMapping("/dingcai")
    @ResponseBody
    public ResultInfo DingCai(/*@RequestParam(value = "token") String token,*/
                              @RequestParam(value = "pid") Integer pid,
                              @RequestParam(value = "type") Integer type){
        ResultInfo result=new ResultInfo();
       /*if(token.isEmpty()){
            result.setCode(400);
            result.setMsg("token为空!");
            return  result;
        }
        //token验证
        try{
            Claims claims= (Claims) Jwts.parser()
                    .setSigningKey("geek")
                    .parse(token)
                    .getBody();
        }catch (Exception e){
            result.setCode(402);
            result.setMsg("用户信息异常");
            return  result;
        }
        Claims claims= (Claims) Jwts.parser()
                .setSigningKey("geek")
                .parse(token)
                .getBody();
        int uid=Integer.parseInt(claims.getId());*/
                                   // uid
        result=articleService.DingCai(13,pid,type);
        return result;

    }

    @PostMapping("/addpost")
    @ResponseBody
    public ResultInfo addPost(@RequestBody post post){
       String time= String.valueOf(new Date().getTime()).substring(0,10);
        post.setCreate_time(Long.parseLong(time));
        int n=articleService.addPost(post);
        if(n!=0){
           return ResultInfo.success("上传成功");
        }else{
            return ResultInfo.fail("上传失败");
        }
    }
}
