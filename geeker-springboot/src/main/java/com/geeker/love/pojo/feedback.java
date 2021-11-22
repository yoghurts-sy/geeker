package com.geeker.love.pojo;

import lombok.Data;

@Data
public class feedback {
    private int id;
    private  int to_id;
    private int from_id;
    private  String data;
    private int create_time;
}
