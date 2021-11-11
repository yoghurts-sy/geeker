package com.geeker.love.pojo;

import lombok.Data;

@Data
public class post {
    private int id;
    private int user_id;
    private String title;
    private String titlepic;
    private String content;
    private int sharenum;
    private String path;
    private int type;
    private int create_time;
    private int post_class_id;
    private int share_id;
    private int isopen;
}
