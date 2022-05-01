package com.geeker.love.service;

import com.geeker.love.pojo.MessageBean;

import java.util.List;
import java.util.Map;

public interface MessageServe {
    boolean sendMessage(MessageBean messageBean);
    List<MessageBean> queryMessage(Integer from_id,Integer to_id);
    List<Map> getChatList(Integer user_id);
    List<Map> getChatDetails(Integer to_id, Integer from_id);
}
