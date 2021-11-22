package com.geeker.love.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class tokenUtil {
   /* public static int getId(String token) throws RuntimeException{
        ResultInfo result=new ResultInfo();
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
        int uid=Integer.parseInt(claims.getId());
    }*/
}
