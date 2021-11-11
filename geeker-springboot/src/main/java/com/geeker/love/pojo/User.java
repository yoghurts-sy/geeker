package com.geeker.love.pojo;

import lombok.Data;

@Data
public class User {
    private int id;
    private String username;
    private String userpic;
    private String phone;
    private String email;
    private int status;
    private int create_time;
}
