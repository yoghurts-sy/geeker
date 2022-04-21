package com.geeker.love.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class MarkDown {
    private Integer id;
    private Integer user_id;
    private String title;
    private String description;
    private String content;
    private Long created;
    private Integer status;

}
