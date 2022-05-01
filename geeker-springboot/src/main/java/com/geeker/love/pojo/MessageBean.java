package com.geeker.love.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MessageBean {
    Long to_id;
    Long from_id;
    String from_username;
    String from_userpic;
    String type;
    String data;
    Long time;
}
