package com.geeker.love.pojo;

import lombok.Data;

@Data
public class image {
    private int id;
    private String url;
    private int create_time;
    private int user_id;
    public image(String url,int uid){
        this.url=url;
        this.user_id=uid;
    }
}
