package com.geeker.love.controller;

import com.geeker.love.common.dto.LoginDto;
import com.geeker.love.common.exception.GeekerException;
import com.geeker.love.common.lang.Result;
import com.geeker.love.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/love/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result LoginController(@RequestBody LoginDto loginDto) throws GeekerException {
        return userService.PhoneLogin(loginDto.getPhone(), loginDto.getPassword());
    }

    /**
     *  思路：先不设计注册，用户可根据手机验证码登录，然后进入了界面修改信息作为注册
     */

    // 已经获取到手机验证码后 --> 用户拿着手机号码和验证码 --> 登录
    @PostMapping("/codelogin")
    public Result PhoneLoginController(@RequestBody LoginDto loginDto) throws GeekerException {
        return userService.PhoneCodeLogin(loginDto.getPhone(), loginDto.getPassword()/*code*/);
    }

    @PostMapping("/sendcode")
    public Result SendVerifyCode(@RequestParam String phone) {
        return userService.SendVerifyCode(phone);
    }


}
