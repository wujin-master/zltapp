package com.sqf.chatService;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sqf.pojo.SendMessage;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 上线的信息
 * 用户列表
 * 群聊
 * 私聊
 */
@Component
@ServerEndpoint(value = "/chat/{username}")   //当前服务的url：ws://ip/chat
public class chatService {
    private Session session;//客户端与服务器端的会话：每个websocket客户端进来，都会有一个server对象
    private String username;//当前客户的名字，随着请求的url携带

    //内存中的数据结构——缓存：当前客户端的列表
    private static Map<String,Session> clients = new ConcurrentHashMap<String,Session>();

    @OnOpen
    public void onOpen(Session session,@PathParam(value="username") String username){
        System.out.println(username+":连接上线");
        System.out.println(session);
        this.session = session;
        this.username = username;

        clients.put(username,session);//有用户上线，放入的用户缓存（redis）

        //上线的信息返回给所有客户端：head:onLine,data:username
        sendLoginMsg();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //更新的用户列表返回给所有客户端：head:userList,data:[{},{},{}]
        sendUserList();
    }

    private void sendUserList() {
        //构建要返回的消息
        SendMessage sendMsg = new SendMessage();
        sendMsg.setHead("userList");
        sendMsg.setData(JSON.toJSONString(clients.keySet()));

        //消息转成json数据
        String msg = JSON.toJSONString(sendMsg);

        //群发的概念
        for(Session session:clients.values()){
            session.getAsyncRemote().sendText(msg);
        }
    }

    private void sendLoginMsg() {
        //构建要返回的消息
        SendMessage sendMsg = new SendMessage();
        sendMsg.setHead("onLine");
        sendMsg.setData(this.username);

        //消息转成json数据
        String msg = JSON.toJSONString(sendMsg);

        //群发的概念
        for(Session session:clients.values()){
            session.getAsyncRemote().sendText(msg);
        }
    }

    @OnClose
    public void onClose(){
        System.out.println(username+"下线");
        clients.remove(username);
    }

    @OnMessage
    public void onMessage(String message){
        System.out.println(username+"发送消息"+message);



        //群聊的消息发送给客户端
        //参数：head:sendAll,data:消息
        //返回：head:sendAll,data:{from:谁发的，info:消息本身}


        //私聊的消息发送给客户端
        //参数：head:sendTo,data:{to:发送给谁，info：消息本身}
        //返回：head:sendTo,data:{from:谁发的，info：消息本身}

        //解析消息到底来的群聊/私发——参数
        //参数：head:sendAll,data:消息
        //参数：head:sendTo,data:{to:发送给谁，info：消息本身}
        JSONObject jobj = JSON.parseObject(message);
        String head = jobj.getString("head");
        if(head!=null && head.equals("sendAll")){
            //客户端发送的群聊消息
            sendAll(jobj.getString("data"));
        }else if(head!=null && head.equals("sendTo")){
            //客户端发送的是私聊消息
            sendTo(jobj.getString("data"));
        }


        //服务器端发送消息给客户端~~~
//        this.session.getAsyncRemote().sendText("服务器要发送给客户端的消息");
    }

    //消息
    //返回：head:sendAll,data:{from:谁发的，info:消息本身}
    private void sendAll(String data) {
        //解析消息：data:消息
        //构建消息对象
        SendMessage sendMsg = new SendMessage();
        sendMsg.setHead("sendAll");
        JSONObject jsonMsg = new JSONObject();
        jsonMsg.put("from",this.username);
        jsonMsg.put("info",data);
        sendMsg.setData(JSON.toJSONString(jsonMsg));
        //转成JSON字符串
        String outputMsg = JSON.toJSONString(sendMsg);
        //群发消息
        for(Session session:clients.values()){
            session.getAsyncRemote().sendText(outputMsg);
        }
    }
    //{to:发送给谁，info：消息本身}
    //返回：head:sendTo,data:{from:谁发的，info：消息本身}
    private void sendTo(String data) {
        //解析消息
        JSONObject jobj = JSONObject.parseObject(data);
        String toUser = jobj.getString("to");
        String info = jobj.getString("info");
        //构建消息对象
        SendMessage sendMsg = new SendMessage();
        sendMsg.setHead("sendTo");
        JSONObject jsonMsg = new JSONObject();
        jsonMsg.put("from",this.username);
        jsonMsg.put("info",info);
        sendMsg.setData(JSON.toJSONString(jsonMsg));
        //转成JSON字符串
        String outputMsg = JSON.toJSONString(sendMsg);
        //私发消息
        for(String username:clients.keySet()){
            if(toUser.equals(username)){
                clients.get(username).getAsyncRemote().sendText(outputMsg);
                break;
            }
        }
    }

    @OnError
    public void onError(Throwable t){
        System.out.println(username+"出现错误"+t.getMessage());
    }
}
