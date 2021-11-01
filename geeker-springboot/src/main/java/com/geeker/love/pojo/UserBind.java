package com.geeker.love.pojo;

import lombok.Data;

@Data
public class UserBind {
    private Integer id;
    private String type;
    private String openid; // 微信小程序
    private Long user_id;
    private String nickname;
    private String avatarurl; // 头像图片url
}
