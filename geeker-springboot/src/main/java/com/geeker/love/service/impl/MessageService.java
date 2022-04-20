package com.geeker.love.service.impl;

import com.geeker.love.dao.MessageMapper;
import com.geeker.love.pojo.MessageBean;
import com.geeker.love.service.MessageServe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService implements MessageServe {
    @Autowired
    private MessageMapper messageMapper;
    @Override
    public boolean sendMessage(MessageBean messageBean) {
        return messageMapper.sendMessage(messageBean);
    }

    @Override
    public List<MessageBean> queryMessage(Integer from_id, Integer to_id) {
        List<MessageBean> messages=messageMapper.queryMessage(from_id,to_id);
        return messages;
    }
}
