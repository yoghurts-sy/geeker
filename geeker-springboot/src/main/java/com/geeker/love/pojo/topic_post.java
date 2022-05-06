package com.geeker.love.pojo;

import lombok.Data;

@Data
public class topic_post {
    private int id;
    private int topic_id;
    private int post_id;
    private long create_time;
    public topic_post(int topic_id,int post_id,long create_time){
        this.topic_id=topic_id;
        this.post_id=post_id;
        this.create_time=create_time;
    }
}
