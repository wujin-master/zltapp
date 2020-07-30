package com.zlt.chatService;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zlt.pojo.ChatMessage;
import com.zlt.pojo.EduChatinfo;
import com.zlt.pojo.EduUser;
import com.zlt.pojo.SendMessage;
import com.zlt.service.ChatInfoService;
import com.zlt.service.EduUserService;
import com.zlt.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.misc.BASE64Decoder;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 上线的信息
 * 用户列表
 * 群聊
 * 私聊
 */
@Component
@ServerEndpoint(value = "/chat/{userId}")   //当前服务的url：ws://ip/chat
public class chatService {
    private static EduUserService eduUserService;
    private static ChatInfoService chatInfoService;

    // 注入的时候，给类的 service 注入
    @Autowired
    public void setService(EduUserService eduUserService, ChatInfoService chatInfoService) {
        chatService.eduUserService = eduUserService;
        chatService.chatInfoService = chatInfoService;
    }


    private Session session;//客户端与服务器端的会话：每个websocket客户端进来，都会有一个server对象
    private EduUser eduUser;//存放当前连接着的实例信息

    //内存中的数据结构——缓存：当前客户端的列表
    private static Map<EduUser,Session> clients = new ConcurrentHashMap<EduUser,Session>();

    @OnOpen
    public void onOpen(Session session,@PathParam(value="userId") String userId){
        System.out.println(userId);
        EduUser eduUser1 = eduUserService.findById(userId);
        System.out.println(eduUser1.getUserNickname()+":连接上线");
        System.out.println(session);
        this.session = session;
        session.setMaxTextMessageBufferSize(2000000);
        this.eduUser = eduUser1;

        clients.put(eduUser,session);//有用户上线，放入的用户缓存（redis）

        //上线的信息返回给所有客户端：head:onLine,data:username
        sendLoginMsg();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //更新的用户列表返回给所有客户端：head:userList,data:[{},{},{}]
//        sendUserList();
    }

    private void sendLoginMsg() {
        //构建要返回的消息
        EduChatinfo chatMessage = new EduChatinfo();
        chatMessage.setId(UUIDUtil.getUUID());
        chatMessage.setSender(eduUser.getUserId());
        chatMessage.setMessage(eduUser.getUserNickname() + "上线啦，快来一起聊天吧！");
        chatMessage.setReceiver("all");
        chatMessage.setType("011");
        chatMessage.setSendTime(new Timestamp(new Date().getTime()));
        //将聊天记录存在数据库中
        chatInfoService.addChatInfo(chatMessage);
        //消息转成json数据
        String msg = JSON.toJSONString(chatMessage);
        //群发的概念
        for(Session session:clients.values()){
            session.getAsyncRemote().sendText(msg);
        }
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



    @OnClose
    public void onClose(){
        System.out.println(eduUser.getUserNickname()+"下线");
//        clients.remove(username);
    }

    @OnMessage
    public void onMessage(String message){
        EduChatinfo chatMessage = new EduChatinfo();
        System.out.println(eduUser.getUserNickname() + "发送消息：" + message);
        JSONObject jobj = JSON.parseObject(message);
        if(jobj.getString("type").equals("010")){
            //处理图片信息
            String[] strArr = jobj.getString("message").split(",");
            String savePath = "D:/java web/mynewzltapp/chat/src/main/resources/static/images/" + UUIDUtil.getUUID() + "." + strArr[0].replace("data:image/", "").replace(";base64", "");
            GenerateImage(strArr[1], savePath);
            System.out.println("base64转图片");
            //设置消息格式
            chatMessage.setSender(jobj.getString("sender"));
            chatMessage.setReceiver(jobj.getString("receiver"));
            chatMessage.setMessage("https://p.17f.club/images/2020/04/05/1586079402341ckt_img.png");
            chatMessage.setType(jobj.getString("type"));
            chatMessage.setSendTime(new Timestamp(new Date().getTime()));
            chatMessage.setId(UUIDUtil.getUUID());
            chatInfoService.addChatInfo(chatMessage);
            sendAll(chatMessage);
        }else{
            //处理纯文本或者表情混合信息
            chatMessage.setSender(jobj.getString("sender"));
            chatMessage.setReceiver(jobj.getString("receiver"));
            chatMessage.setMessage(jobj.getString("message"));
            chatMessage.setType(jobj.getString("type"));
            chatMessage.setId(UUIDUtil.getUUID());
            chatInfoService.addChatInfo(chatMessage);
            sendAll(chatMessage);
        }

//        System.out.println(username+"发送消息"+message);
//
//
//
//        //群聊的消息发送给客户端
//        //参数：head:sendAll,data:消息
//        //返回：head:sendAll,data:{from:谁发的，info:消息本身}
//
//
//        //私聊的消息发送给客户端
//        //参数：head:sendTo,data:{to:发送给谁，info：消息本身}
//        //返回：head:sendTo,data:{from:谁发的，info：消息本身}
//
//        //解析消息到底来的群聊/私发——参数
//        //参数：head:sendAll,data:消息
//        //参数：head:sendTo,data:{to:发送给谁，info：消息本身}
//        JSONObject jobj = JSON.parseObject(message);
//        String head = jobj.getString("head");
//        if(head!=null && head.equals("sendAll")){
//            //客户端发送的群聊消息
//            sendAll(jobj.getString("data"));
//        }else if(head!=null && head.equals("sendTo")){
//            //客户端发送的是私聊消息
//            sendTo(jobj.getString("data"));
//        }


        //服务器端发送消息给客户端~~~
//        this.session.getAsyncRemote().sendText("服务器要发送给客户端的消息");
    }

    //消息
    //返回：head:sendAll,data:{from:谁发的，info:消息本身}
    private void sendAll(EduChatinfo chatMessage) {
        String outputMsg = JSON.toJSONString(chatMessage);
        //群发消息
        for(Session session:clients.values()){
            session.getAsyncRemote().sendText(outputMsg);
        }
    }
    //{to:发送给谁，info：消息本身}
    //返回：head:sendTo,data:{from:谁发的，info：消息本身}
//    private void sendTo(String data) {
//        //解析消息
//        JSONObject jobj = JSONObject.parseObject(data);
//        String toUser = jobj.getString("to");
//        String info = jobj.getString("info");
//        //构建消息对象
//        SendMessage sendMsg = new SendMessage();
//        sendMsg.setHead("sendTo");
//        JSONObject jsonMsg = new JSONObject();
//        jsonMsg.put("from",this.eduUser.getUserNickname());
//        jsonMsg.put("info",info);
//        sendMsg.setData(JSON.toJSONString(jsonMsg));
//        //转成JSON字符串
//        String outputMsg = JSON.toJSONString(sendMsg);
//        //私发消息
//        for(EduUser username:clients.keySet()){
//            if(toUser.equals(username)){
//                clients.get(username).getAsyncRemote().sendText(outputMsg);
//                break;
//            }
//        }
//    }

    @OnError
    public void onError(Throwable t){
        System.out.println("出现错误"+t.getMessage());
//        System.out.println(eduUser.getUserNickname()+"出现错误"+t.getMessage());
    }

    /**
     * base64转图片
     * @param base64str base64码
     * @param savePath 图片路径
     * @return
     */
    public static boolean GenerateImage(String base64str, String savePath) {
        //对字节数组字符串进行Base64解码并生成图片
        if (base64str == null) {
            return false;
        }
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            //Base64解码
            byte[] b = decoder.decodeBuffer(base64str);
            for (int i = 0; i < b.length; ++i) {
                //调整异常数据
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            //生成jpeg图片
            OutputStream out = new FileOutputStream(savePath);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
