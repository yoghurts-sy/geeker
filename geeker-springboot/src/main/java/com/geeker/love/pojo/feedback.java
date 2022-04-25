package com.geeker.love.pojo;

import lombok.Data;

@Data
public class feedback {
    private Integer id;
    private  Integer to_id;
    private Integer from_id;
    private  String data;
    private Long create_time;
}
