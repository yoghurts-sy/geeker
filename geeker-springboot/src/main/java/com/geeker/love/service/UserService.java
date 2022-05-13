package com.geeker.love.service;

import com.geeker.love.common.exception.GeekerException;
import com.geeker.love.common.lang.Result;
import com.geeker.love.pojo.User;
import com.geeker.love.utils.ResultInfo;

public interface UserService {
    Result PhoneLogin(String phone, String password) throws GeekerException;
    Result PhoneCodeLogin(String phone, String code) throws GeekerException;
    Result SendVerifyCode(String phone);
    User QueryUserByUserId(Integer id);
    ResultInfo QueryUserByUserIdMap(Integer id);
    String SaveResume(Long user_id, String resume);
    ResultInfo registerUser(String nickname, String phone, String password);
}
