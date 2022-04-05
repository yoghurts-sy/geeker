package com.geeker.love.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MessageBean {
    @JsonProperty(value = "to_id")
    Integer to_id;

    @JsonProperty(value = "from_id")
    Integer from_id;

    @JsonProperty(value = "from_name")
    String from_name;

    @JsonProperty(value = "from_userpic")
    String from_userpic;

    @JsonProperty(value = "type")
    String type;

    @JsonProperty(value = "data")
    String data;

    @JsonProperty(value = "time")
    Long time;
}
