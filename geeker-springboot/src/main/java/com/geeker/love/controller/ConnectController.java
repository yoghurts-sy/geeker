package com.geeker.love.controller;


import com.geeker.love.dao.MessageMapper;
import com.geeker.love.pojo.MessageBean;
import com.geeker.love.service.MessageServe;
import com.geeker.love.utils.ResultInfo;
import com.geeker.love.websocket.ChatEndPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/love/api")
public class ConnectController {
    @Autowired
    private MessageServe messageServe;

    @PostMapping("/send")
    public ResultInfo send(@RequestBody MessageBean message) {
        message.setTime(Long.parseLong(message.getTime().toString().substring(0, 10)));
        System.out.println(message);
        ChatEndPoint.sendMessage(message);
        messageServe.sendMessage(message);
        /**
         * 存数据库
         */
        return ResultInfo.success("sent");
    }

    //获取消息记录
    @GetMapping("/record")
    public ResultInfo record(@RequestParam Integer from_id, Integer to_id){
       return ResultInfo.success(messageServe.queryMessage(from_id,to_id));
    }

    //获取消息记录
    @GetMapping("/getChatList")
    public ResultInfo getChatList(@RequestParam Integer user_id){
        System.out.println(user_id);
        return ResultInfo.success(messageServe.getChatList(user_id));
    }

    //获取消息记录
    @GetMapping("/getChatDetails")
    public ResultInfo getChatDetails(@RequestParam Integer to_id, @RequestParam Integer from_id){
        return ResultInfo.success(messageServe.getChatDetails(to_id, from_id));
    }
}

