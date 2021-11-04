package com.geeker.love.shiro;

import lombok.Data;

import java.io.Serializable;

@Data
public class AccountProfile implements Serializable {
    private Integer id;
    private String username;
    private String userpic;
    private String phone;
    private String email;
    private Integer status;
    private Long create_time;
}
