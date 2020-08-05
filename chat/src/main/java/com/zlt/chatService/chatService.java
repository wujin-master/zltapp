package com.zlt.chatService;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.obs.services.ObsClient;
import com.zlt.pojo.*;
import com.zlt.service.ChatInfoService;
import com.zlt.service.EduUserService;
import com.zlt.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.misc.BASE64Decoder;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 根据chatInfo的信息判断是群聊还是
 */
@Component
@ServerEndpoint(value = "/chat/{chatInfo}")   //当前服务的url：ws://ip/chat
public class chatService {
    private static EduUserService eduUserService;
    private static ChatInfoService chatInfoService;
    //私人模式可能会存储相同的sender或者receiver
    private String receiverId;
    //存放真实的接收者id
    private String receiverId_1;
    private String userId;
    private Session session;//客户端与服务器端的会话：每个websocket客户端进来，都会有一个server对象
    private EduUser eduUser;//....存放当前连接着的实例信息
    //内存中的数据结构——缓存：当前客户端的列表
    private static Map<String, ArrayList<Session>> clients = new ConcurrentHashMap<String,ArrayList<Session>>();
    private static Map<String, ArrayList<EduUser>> clients_user = new ConcurrentHashMap<String,ArrayList<EduUser>>();
    // 注入的时候，给类的 service 注入
    @Autowired
    public void setService(EduUserService eduUserService, ChatInfoService chatInfoService) {
        chatService.eduUserService = eduUserService;
        chatService.chatInfoService = chatInfoService;
    }

    @OnOpen
    public void onOpen(Session session, @PathParam(value="chatInfo") String chatInfo){
//        System.out.println("========新用户上线=========");
//        System.out.println(chatInfo);
        String[] info = chatInfo.split("\\|");
        //消息类型 all：群聊  private：私聊
        String chatType = info[0];
        //实际上是接受者的id：班级或者用户id
        this.receiverId = info[1];
        this.receiverId_1 = info[1];
        EduUser eduUser1 = eduUserService.findById(info[2]);
        this.userId = info[2];
        this.session = session;
        this.eduUser = eduUser1;

        session.setMaxTextMessageBufferSize(2000000);
        if(chatType.equals("all")){
            //群聊方式
            if(clients.get(receiverId)!=null){
                //如果班级集合已经建立,就将班级所对应的集合取出来，把新的用户加进去
                receiverId_1 = receiverId;
                ArrayList<Session> chatList = clients.get(receiverId);
                chatList.add(session);
                clients.put(receiverId, chatList);
                //如果班级集合已经建立,就将班级所对应的集合取出来，把新的用户信息加进去
                ArrayList<EduUser> userList = clients_user.get(receiverId);
                userList.add(eduUser1);
                clients_user.put(receiverId, userList);
            }else{
                //如果班级集合还未建立，就新建集合，将新的用户加进去，再放入总的map会话集合种
                ArrayList<Session> chatList = new ArrayList<Session>();
                chatList.add(session);
                clients.put(receiverId, chatList);
                //如果班级集合已经建立,就将班级所对应的集合取出来，把新的用户信息加进去
                ArrayList<EduUser> userList = new ArrayList<EduUser>();
                userList.add(eduUser1);
                clients_user.put(receiverId, userList);
            }
            //创建会话集合后，发送上线信息到客户端
            try {
                sendLoginMsg();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //更新的用户列表返回给所有客户端：head:userList,data:[{},{},{}]
            try {
                sendUserList();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(chatType.equals("private")){
            //私聊方式
            System.out.println("私聊模式开始");
            if(clients.get(userId)!=null){
                //对面在线，因为对面如果在在线，就会存在以userId为key的session集合
                receiverId = userId;
                System.out.println("对方在线");
                //如果双人聊天集合已经建立,就将双人所对应的集合取出来，把新的用户加进去
                ArrayList<Session> chatList = clients.get(userId);
                chatList.add(session);
                clients.put(userId, chatList);
                //如果班级集合已经建立,就将班级所对应的集合取出来，把新的用户信息加进去
                ArrayList<EduUser> userList = clients_user.get(userId);
                userList.add(eduUser1);
                clients_user.put(userId, userList);
                //如果双人集合已经建立，证明目前会话集合中加上自己必有两个人在线，即对方在线，所以发送对方在线的消息
                ChatOnLine chatOnLine = new ChatOnLine();
                chatOnLine.setChatState("yes");
                chatOnLine.setType("onLineState");
                chatOnLine.setSender(userId);
                try {
                    sendOnlineState(chatOnLine);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else{
                //对面不在线,即双方都不在线，那么就创建以receiverid为key的session集合
                ArrayList<Session> chatList = new ArrayList<Session>();
                chatList.add(session);
                clients.put(receiverId, chatList);
                //如果班级集合已经建立,就将班级所对应的集合取出来，把新的用户信息加进去
                ArrayList<EduUser> userList = new ArrayList<EduUser>();
                userList.add(eduUser1);
                clients_user.put(receiverId, userList);
                //如果双人集合还没创建，证明对方也不在线
                ChatOnLine chatOnLine = new ChatOnLine();
                chatOnLine.setChatState("no");
                chatOnLine.setType("onLineState");
                chatOnLine.setSender(userId);
                try {
                    sendOnlineState(chatOnLine);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //创建会话集合后，发送上线信息到客户端
            try {
                sendLoginMsg();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void sendLoginMsg() throws IOException {
        ChatMessage sendMessage = new ChatMessage();
        sendMessage.setSender(eduUser.getUserId());
        sendMessage.setSenderImg(eduUser.getUserPortrait());
        sendMessage.setReceiver(receiverId);
        sendMessage.setSenderName(eduUser.getUserNickname());
        sendMessage.setMessage("我上线啦，快来一起聊天吧！");
        sendMessage.setSendTime(new Timestamp(new Date().getTime()));
        sendMessage.setType("011");
        //消息转成json数据
        String msg = JSON.toJSONString(sendMessage);
        //将对应会话Id里的用户群发
        for(Session session:clients.get(receiverId)){
            System.out.println("session信息");
            System.out.println(session);
            session.getBasicRemote().sendText(msg);
        }
        // //构建要返回的消息
        //EduChatinfo chatMessage = new EduChatinfo();
        //chatMessage.setId(UUIDUtil.getUUID());
        //chatMessage.setSender(eduUser.getUserId());
        //chatMessage.setMessage("我上线啦，快来一起聊天吧！");
        //chatMessage.setReceiver("01");
        //chatMessage.setType("011");
        //chatMessage.setSendTime(new Timestamp(new Date().getTime()));
        //上线信息暂不存储到数据库中
        //chatInfoService.addChatInfo(chatMessage);
        //创建要发送到客户端的信息对象
    }

    private void sendUserList() throws IOException {
        ChatUserList chatUserList = new ChatUserList();
        chatUserList.setUserArrayList(clients_user.get(receiverId));
        chatUserList.setType("allUser");
        chatUserList.setSender(eduUser.getUserId());
        String msg = JSON.toJSONString(chatUserList);
        //将对应会话Id里的用户群发
        for(Session session:clients.get(receiverId)){
            session.getBasicRemote().sendText(msg);
        }
    }

    private void sendOnlineState(ChatOnLine chatOnLine) throws IOException {
        String msg = JSON.toJSONString(chatOnLine);
        //将对应会话Id里的用户群发
        for(Session session:clients.get(receiverId)){
            System.out.println("需要发送状态信息的用户");
            System.out.println(session);
            System.out.println("发送在线信息");
            session.getBasicRemote().sendText(msg);
        }
    }



    @OnClose
    public void onClose(){
        System.out.println("用户下线");
        //从会话中删除本用户以及session
        ArrayList<EduUser> eduUserArrayList = clients_user.get(receiverId);
        int count = 0;
        for(int i=0;i<eduUserArrayList.size();i++){
            //将该用户从会话中删除
            if(eduUserArrayList.get(i).getUserId().equals(userId)){
                count = i;
                eduUserArrayList.remove(i);
                break;
            }
        }
        if(eduUserArrayList.size()==0){
            //如果删除后会话集合的大小等于0，证明当前房间没人，则删除此会话集
            clients_user.remove(receiverId);
            clients.remove(receiverId);
        }else{
            clients_user.put(receiverId, eduUserArrayList);
            ArrayList<Session> sessionArrayList = clients.get(receiverId);
            sessionArrayList.remove(count);
            clients.put(receiverId, sessionArrayList);
        }
    }

    @OnMessage
    public void onMessage(String message){
        EduChatinfo chatMessage = new EduChatinfo();
        //将收到的转为Json格式
        JSONObject jobj = JSON.parseObject(message);
        if(jobj.getString("type").equals("010")){
            //用户发送的是图片信息，进行base64数据接受以及存储到华为云
            String[] strArr = jobj.getString("message").split(",");
            String uuid = UUIDUtil.getUUID();
            String savePath = UUIDUtil.getUUID() + "." + strArr[0].replace("data:image/", "").replace(";base64", "");
            GenerateImage(strArr[1], savePath);
            //设置数据库聊天记录对象
            chatMessage.setSender(userId);
            chatMessage.setReceiver(receiverId_1);
            chatMessage.setMessage("http://my.17f.club/" + savePath);
            chatMessage.setType(jobj.getString("type"));
            chatMessage.setSenderName(eduUser.getUserNickname());
            chatMessage.setSenderImg(eduUser.getUserPortrait());
            chatMessage.setSendTime(new Timestamp(new Date().getTime()));
            System.out.println(new Timestamp(new Date().getTime()));
            chatMessage.setId(UUIDUtil.getUUID());
            chatInfoService.addChatInfo(chatMessage);
            //设置要发送到客户端的信息对象
            ChatMessage sendMessage = new ChatMessage();
            sendMessage.setSender(userId);
            sendMessage.setSenderImg(eduUser.getUserPortrait());
            sendMessage.setReceiver(receiverId_1);
            sendMessage.setSenderName(eduUser.getUserNickname());
            sendMessage.setMessage("http://my.17f.club/" + savePath);
            sendMessage.setSendTime(new Timestamp(new Date().getTime()));
            sendMessage.setType(jobj.getString("type"));
            try {
                sendAll(sendMessage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            //设置数据库聊天记录对象
            chatMessage.setSender(userId);
            chatMessage.setReceiver(receiverId_1);
            chatMessage.setMessage(jobj.getString("message"));
            chatMessage.setType(jobj.getString("type"));
            chatMessage.setSenderName(eduUser.getUserNickname());
            chatMessage.setSenderImg(eduUser.getUserPortrait());
            chatMessage.setSendTime(new Timestamp(new Date().getTime()));
            chatMessage.setId(UUIDUtil.getUUID());
            chatInfoService.addChatInfo(chatMessage);
            //设置要发送到客户端的信息对象
            ChatMessage sendMessage = new ChatMessage();
            sendMessage.setSender(userId);
            sendMessage.setSenderImg(eduUser.getUserPortrait());
            sendMessage.setReceiver(receiverId_1);
            sendMessage.setSenderName(eduUser.getUserNickname());
            sendMessage.setMessage(jobj.getString("message"));
            sendMessage.setSendTime(new Timestamp(new Date().getTime()));
            sendMessage.setType(jobj.getString("type"));
            try {
                sendAll(sendMessage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //消息
    //返回：head:sendAll,data:{from:谁发的，info:消息本身}
    private void sendAll(ChatMessage chatMessage) throws IOException {
        String msg = JSON.toJSONString(chatMessage);
        //将对应会话Id里的用户群发
        for(Session session:clients.get(receiverId)){
            session.getBasicRemote().sendText(msg);
        }
    }

    @OnError
    public void onError(Throwable t){
        System.out.println("出现错误"+t.getMessage());
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
            //上传到华为云obs
            String endPoint = "https://your-endpoint";
            String ak = "*** Provide your Access Key ***";
            String sk = "*** Provide your Secret Key ***";
            // 创建ObsClient实例
            ObsClient obsClient = new ObsClient("AHUI0M0TSOP9PULFXVXS", "eg8Zs8qiMps8ZM8fbcq2ZpPzOGvbuBjM2g8nDgVY", "obs.cn-east-3.myhuaweicloud.com");
            obsClient.putObject("public-clouddisk", savePath, new ByteArrayInputStream(b));
            return true;
        } catch (Exception e) {
            System.out.println("图片数据保存到华为云对象存储时出现错误");
            System.out.println("错误信息：" + e);
            return false;
        }
    }
}
