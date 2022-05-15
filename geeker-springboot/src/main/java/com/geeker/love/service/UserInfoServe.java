package com.geeker.love.service;

import com.geeker.love.pojo.UserInfo;
import com.geeker.love.utils.ResultInfo;

public interface UserInfoServe {
    Integer updateUserInfo(UserInfo userInfo);

    ResultInfo updatePassword(String oldPw, String newPw, Integer uid);
    ResultInfo insertBlackList(Integer bid,Integer uid);
    ResultInfo deleteBlackList(Integer bid,Integer uid);

    UserInfo getUserInfo(Integer user_id);
    ResultInfo updateUserImage(Integer user_id, String url);
}
