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
    /**
     *  不需要
     */
   /* @PostMapping("/bind")
    public ResultInfo bind(@RequestBody Map<String, Object> map, HttpSession httpSession) {
        String user_id = map.get("user_id") + "";
        System.out.println("接收bind请求 From:" + user_id);
        System.out.println(httpSession.getId());
        httpSession.setMaxInactiveInterval(30 * 60);
        httpSession.setAttribute("user_id", user_id);
        return ResultInfo.success("bound From:" + user_id);
    }*/

    @PostMapping("/send")
    public ResultInfo send(@RequestBody MessageBean message) {


        ChatEndPoint.sendMessage(message);
        messageServe.sendMessage(message);
        /**
         * 存数据库
         */
        return ResultInfo.success("sent");
    }

    //获取消息记录
    @GetMapping("/record")
    public ResultInfo record(@RequestParam Integer from_id,Integer to_id){
       return ResultInfo.success(messageServe.queryMessage(from_id,to_id));
    }
}

