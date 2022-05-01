package com.geeker.love.service.impl;

import com.geeker.love.dao.MessageMapper;
import com.geeker.love.pojo.MessageBean;
import com.geeker.love.service.MessageServe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<MessageBean> messages = messageMapper.queryMessage(from_id,to_id);
        return messages;
    }

    @Override
    public List<Map> getChatList(Integer user_id) {
        List<Map> maps = messageMapper.queryChatList(user_id);
        Map<String, Map> temp = new HashMap<>();
        for (Map map : maps) {
            Long from_id = (Long) map.get("from_id");
            Long to_id = (Long) map.get("to_id");
            String form0 = from_id + "-" + to_id;
            String form1 = to_id + "-" + from_id;
            if (temp.containsKey(form0)) {
                temp.put(form0, map);
            } else if (temp.containsKey(form1)) {
                temp.put(form1, map);
            } else {
                temp.put(form0, map);
            }
        }
        List<Map> res = new ArrayList<>();
        for (String key : temp.keySet()) {
            Map map = temp.get(key);
            String[] split = key.split("-");
            String to_id = split[0].equals(user_id + "") ? split[1] : split[0];
            System.out.println(key);
            System.out.println(to_id);
            Long toId = Long.parseLong(to_id);
            Map<String, Object> toUserDetail = messageMapper.getToUserDetail(toId);
            if (toUserDetail == null) {
                continue;
            }
            System.out.println(toUserDetail);
            map.put("user_id", toUserDetail.get("user_id"));
            map.put("avatar", toUserDetail.get("avatar"));
            map.put("username", toUserDetail.get("username"));
            map.put("noread", 0);

            map.remove("id");
            map.remove("from_id");
            map.remove("to_id");
            res.add(map);
        }
        return res;
    }

    @Override
    public List<Map> getChatDetails(Integer to_id, Integer from_id) {
        List<Map> maps = messageMapper.queryChatDetails(from_id, to_id);
        Map toUserDetail = messageMapper.getToUserDetail(Long.parseLong(to_id + ""));
        Map fromUserDetail = messageMapper.getToUserDetail(Long.parseLong(from_id + ""));
        System.out.println(toUserDetail);
        System.out.println(fromUserDetail);
        List<Map> res = new ArrayList<>();
        for (Map map : maps) {
            if ((Long) map.get("user_id") == Long.parseLong(from_id + "")) {
                map.put("avatar", fromUserDetail.get("avatar"));
                map.put("username", fromUserDetail.get("username"));
            } else {
                map.put("avatar", toUserDetail.get("avatar"));
                map.put("username", toUserDetail.get("username"));
            }
            res.add(map);
        }
        return res;
    }
}
