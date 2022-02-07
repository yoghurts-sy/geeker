package com.geeker.love.service.impl;

import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.SecureUtil;
import com.geeker.love.common.exception.GeekerException;
import com.geeker.love.common.lang.Result;
import com.geeker.love.dao.UserMapper;
import com.geeker.love.pojo.User;
import com.geeker.love.service.UserService;
import com.geeker.love.utils.FormatTimeUtils;
import com.geeker.love.utils.JwtUtils;
import com.geeker.love.utils.RedisUtils;
import com.geeker.love.utils.nullOrNot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public Result PhoneLogin(String phone, String password) throws GeekerException {

        System.out.println(phone + " " + password);
        if (!checkPhone(phone)) throw new GeekerException("手机号码格式不正确");// 应该在前端校验
        User user = userMapper.queryUserByPhone(phone);
        nullOrNot.istrue(user == null, "用户不存在");
        nullOrNot.istrue(!user.getPassword().equals(SecureUtil.md5(password)), "密码不正确");
        // 记得把数据库改改
        String jwt = jwtUtils.generateToken(user.getId());

        System.out.println(user);
        return Result.success(
                MapUtil.builder()
                        .put("username", user.getUsername())
                        .put("avatar", user.getUserpic())
                        .put("phone", user.getPhone())
                        .put("email", user.getEmail())
                        .put("createTime", FormatTimeUtils.format(user.getCreate_time()))
                        .put("token", jwt)
                        .map()
        );
    }


    /**
     * 查看redis，对应的key - value ?== phone - code匹配了才给登录
     * @param phone
     * @param code
     * @return
     */
    @Override
    public Result PhoneCodeLogin(String phone, String code) throws GeekerException {
        System.out.println(phone + " " + code);


        nullOrNot.istrue(!checkPhone(phone), "手机号码格式不正确");
        String redisCode = (String)redisUtils.get(phone);
        if (redisCode == null) return Result.fail("验证码已过期，请重新获取");
        if (!redisCode.equals(code)) return Result.fail("验证码输入错误");

        User user = userMapper.queryUserByPhone(phone);
        if (user == null) { // 用户第一次登录，走注册逻辑，存下他的手机号码
            Integer res = userMapper.insertUserByPhone(phone, FormatTimeUtils.getCurrentTime());
            if (res != 1) throw new GeekerException("注册失败");
            user = userMapper.queryUserByPhone(phone);
        }

        System.out.println("user"+user);

        String jwt = jwtUtils.generateToken(user.getId());
        return Result.success(
                MapUtil.builder()
                        .put("username", user.getUsername())
                        .put("avatar", user.getUserpic())
                        .put("phone", user.getPhone())
                        .put("email", user.getEmail())
                        .put("createTime", FormatTimeUtils.format(user.getCreate_time()))
                        .put("token", jwt)
                        .map()
        );
    }

    @Override
    public Result SendVerifyCode(String phone) {
        // 发送code，并将键值对存入redis中
        //if (redisUtils.get(phone) != null) return Result.fail("验证码未失效，请勿重复获取！");  还是前端设置60秒拦截
        Random random = new Random();
        String code = ""+(random.nextInt(8999) + 1000);
        redisUtils.set(phone, code, 60 * 5); // 5mins
        return Result.success("验证码已发送，注意查收"+" --> "+redisUtils.get(phone));
    }

    @Override
    public User QueryUserByUserId(Integer id) {
        return userMapper.queryUserByUserId(id);
    }


    private static boolean checkPhone(String phone) {
        Pattern pattern = Pattern
                .compile("^(13[0-9]|15[0-9]|153|15[6-9]|180|18[23]|18[5-9])\\d{8}$");
        Matcher matcher = pattern.matcher(phone);

        if (matcher.matches()) {
            return true;
        }
        return false;
    }
}
