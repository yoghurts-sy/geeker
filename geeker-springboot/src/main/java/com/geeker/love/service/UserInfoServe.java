package com.geeker.love.service;

import com.geeker.love.pojo.UserInfo;
import com.geeker.love.utils.ResultInfo;

public interface UserInfoServe {
    int updateUserInfo(UserInfo userInfo,Integer uid);
    ResultInfo updatePassword(String oldPw, String newPw, Integer uid);
    ResultInfo insertBlackList(Integer bid,Integer uid);
    ResultInfo deleteBlackList(Integer bid,Integer uid);
}
