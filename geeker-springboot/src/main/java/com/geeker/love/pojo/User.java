package com.geeker.love.pojo;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String username;
    private String userpic;
    private String password;
    private String phone;
    private String email;
    private Integer status;
    private Long create_time;
    /**
     *   时间戳转化为为格式时间
     *     Date date = new Date();
     *     long times = date.getTime();//时间戳
     *     SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     *     String dateString = formatter.format(date);
     *     System.out.println(dateString);
     */
}
