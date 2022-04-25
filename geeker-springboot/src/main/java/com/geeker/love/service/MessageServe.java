package com.geeker.love.service;

import com.geeker.love.pojo.MessageBean;

import java.util.List;

public interface MessageServe {
    boolean sendMessage(MessageBean messageBean);
    List<MessageBean> queryMessage(Integer from_id,Integer to_id);
}
