package com.geeker.love.service.impl;

import com.geeker.love.dao.UserMapper;
import com.geeker.love.pojo.UserInfo;
import com.geeker.love.service.UserInfoServe;
import com.geeker.love.utils.ResultInfo;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static io.jsonwebtoken.Jwts.builder;

@Service
public class UserInfoService implements UserInfoServe {
    @Autowired
    private UserMapper userMapper;
    public int updateUserInfo(UserInfo userInfo, Integer uid) {
        return userMapper.updateUserInfo(userInfo,uid);
    }

    @Transactional
    public ResultInfo updatePassword(String oldPw, String newPw, Integer uid){
        ResultInfo resultInfo=new ResultInfo();
        String opw=userMapper.queryUserByUserId(uid).getPassword();
        if(oldPw.isEmpty()&&opw.isEmpty()){
            userMapper.updatePassword(Jwts.builder().setId("").setSubject(newPw)
                    .signWith(SignatureAlgorithm.HS256,"geeker").compact(),uid);
            resultInfo.setCode(200);
            resultInfo.setMsg("修改密码成功");
            return resultInfo;
        }
        if(opw.equals(Jwts.builder().setId("").setSubject(oldPw).signWith(SignatureAlgorithm.HS256,"geeker").compact())){
            userMapper.updatePassword(Jwts.builder().setId("").setSubject(newPw)
                    .signWith(SignatureAlgorithm.HS256,"geeker").compact(),uid);
            resultInfo.setCode(200);
            resultInfo.setMsg("修改密码成功");
        }else{
            resultInfo.setObj(400);
            resultInfo.setMsg("原密码有误");
        }
        return resultInfo;


    }

    @Transactional
    public ResultInfo insertBlackList(Integer bid, Integer uid) {
        ResultInfo resultInfo=new ResultInfo();
        if(bid==uid){
            resultInfo.setMsg("您不能拉黑自己");
            resultInfo.setCode(250);
            return  resultInfo;
        }
        if(userMapper.getBlackListById(bid,uid)==null){
            userMapper.insertBlackList(bid,uid);
            resultInfo.setMsg("加入黑名单成功");
            resultInfo.setCode(200);
            return resultInfo;
        }
        resultInfo.setCode(200);
        resultInfo.setMsg("该用户已在黑名单");
        return resultInfo;
    }
    @Transactional
    public ResultInfo deleteBlackList(Integer bid, Integer uid) {
        ResultInfo resultInfo=new ResultInfo();
        if(userMapper.getBlackListById(bid,uid)==null){
            resultInfo.setCode(200);
            resultInfo.setMsg("他不在您的黑名单");
            return  resultInfo;
        }
        userMapper.deleteBlackList(bid,uid);
        resultInfo.setCode(200);
        resultInfo.setMsg("删除成功");
        return resultInfo;
    }
}
