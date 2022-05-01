package com.geeker.love.websocket;

import com.alibaba.fastjson.JSON;
import com.geeker.love.pojo.MessageBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@ServerEndpoint(value = "/love/api/connect/{user_id}", configurator = GetHttpSessionConfigurator.class)
@Component
public class ChatEndPoint {
    //用线程安全的map来保存当前用户
    private static Map<String, ChatEndPoint> onLineUsers = new ConcurrentHashMap<>();
    //声明一个session对象，通过该对象可以发送消息给指定用户，不能设置为静态，每个ChatEndPoint有一个session才能区分.(websocket的session)
    private Session session;
    //保存当前登录浏览器的用户
    private HttpSession httpSession;

    //建立连接时发送系统广播
    @OnOpen
    public void onOpen(Session session, EndpointConfig config, @PathParam("user_id")String user_id){
        this.session = session;

        HttpSession httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
        this.httpSession = httpSession;

        if (user_id == null) {
            try {
                Map<String, String> map = new HashMap<>();
                map.put("type", "bind");
                map.put("status", "false");
                map.put("user_id", "null");
                String res = JSON.toJSONString(map);
                this.session.getBasicRemote().sendText(res);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("user_id:" + user_id + " has connected!");
            Map<String, String> map = new HashMap<>();
            map.put("type", "bind");
            map.put("status", "true");
            map.put("user_id", user_id);
            String res = JSON.toJSONString(map);
            try {
                this.session.getBasicRemote().sendText(res);
                onLineUsers.put(user_id, this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //用户之间的信息发送
    @OnMessage
    public void onMessage(String message, Session session){
        System.out.println(message);
    }
    //用户断开连接的断后操作
    @OnClose
    public void onClose(Session session){

    }

    public static void sendMessage(MessageBean message) {
        String to_id =  message.getTo_id() + "";
        ChatEndPoint chatEndPoint = onLineUsers.get(to_id);
        if (null != chatEndPoint) {
            Session session = chatEndPoint.session;
            try {
                if (session.isOpen()) {
                    synchronized(session){
                        String res = JSON.toJSONString(message);
                        System.out.println(res);
                        session.getBasicRemote().sendText(res);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
