package com.geeker.love.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Topic {
    private int id;
    private String title;
    private String titlepic;
    private String desc;
    private int type;
    private LocalDateTime create_time;
    private int topic_class_id;
}
