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

    public Integer getTo_id() {
        return to_id;
    }

    public void setTo_id(Integer to_id) {
        this.to_id = to_id;
    }

    public Integer getFrom_id() {
        return from_id;
    }

    public void setFrom_id(Integer from_id) {
        this.from_id = from_id;
    }

    public String getFrom_name() {
        return from_name;
    }

    public void setFrom_name(String from_name) {
        this.from_name = from_name;
    }

    public String getFrom_userpic() {
        return from_userpic;
    }

    public void setFrom_userpic(String from_userpic) {
        this.from_userpic = from_userpic;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
