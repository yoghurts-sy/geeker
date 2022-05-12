package com.geeker.love.controller;

import com.geeker.love.pojo.UserInfo;
import com.geeker.love.service.UserInfoServe;
import com.geeker.love.utils.ResultInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/love/api")
public class UserInfoController {

    @Autowired
    private UserInfoServe userInfoServe;


    @PostMapping("/updateUserInfo")
    public ResultInfo updateUserInfo(@RequestBody UserInfo userInfo){
        ResultInfo result = new ResultInfo();
        userInfoServe.updateUserInfo(userInfo);
        result.setMsg("修改成功");
        result.setCode(200);
        return result;
    }

    @GetMapping("/getUserInfo")
    public ResultInfo updateUserInfo(@RequestParam Integer user_id){
        return ResultInfo.success(userInfoServe.getUserInfo(user_id));
    }


    @PostMapping("/updatepw")
    public ResultInfo updatePassword(/*@RequestParam String token,*/
                                     @RequestParam String oldPw,
                                     @RequestParam String newPw)
    {
      /*  ResultInfo result=new ResultInfo();
          if(token.isEmpty()){
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
        return userInfoServe.updatePassword(oldPw,newPw,21);
    }
    @PostMapping("blacklist")   //加入黑名单
    public ResultInfo inBlacklist(/*@RequestParam String token,*/@RequestParam Integer bid){
        /*  ResultInfo result=new ResultInfo();
          if(token.isEmpty()){
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

        return userInfoServe.insertBlackList(bid,85);
    }

    @PostMapping("deletebl")   //移除黑名单
    public ResultInfo deleteBlacklist(/*@RequestParam String token,*/@RequestParam Integer bid){
        /*  ResultInfo result=new ResultInfo();
          if(token.isEmpty()){
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

        return userInfoServe.deleteBlackList(bid,85);
    }
}
