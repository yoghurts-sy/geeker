package com.geeker.love.pojo;

import lombok.Data;

@Data
public class comment {
   private Integer id;
    private Integer user_id;
    private Integer fid;
    private  Integer fnum;
    private String data;
    private Long create_time;
    private Integer post_id;
}
