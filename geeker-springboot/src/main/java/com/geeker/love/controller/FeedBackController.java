package com.geeker.love.controller;

import com.geeker.love.service.FeedBackServe;
import com.geeker.love.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/love/api")
public class FeedBackController {
    @Autowired
    private FeedBackServe feedBackServe;
    @PostMapping("/feedback")
    public ResultInfo FeedBack(/*@RequestParam String token,*/@RequestParam String data){
        /* if(token.isEmpty()){
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

        return feedBackServe.FeedBack(25,data);
    }

    @GetMapping("/getfeedback")
    public ResultInfo getFeedBack(/*@RequestParam String token,*/@RequestParam Integer pageNum){
        /* if(token.isEmpty()){
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

        return feedBackServe.getFeedBack(25,pageNum);
    }
}
