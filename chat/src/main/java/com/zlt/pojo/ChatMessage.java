package com.zlt.pojo;

import java.sql.Timestamp;

public class ChatMessage {
    private String id;
    private String sender;
    private String receiver;
    private String senderName;
    private String senderImg;
    private String message;
    private String type;
    private Timestamp sendTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderImg() {
        return senderImg;
    }

    public void setSenderImg(String senderImg) {
        this.senderImg = senderImg;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Timestamp getSendTime() {
        return sendTime;
    }

    public void setSendTime(Timestamp sendTime) {
        this.sendTime = sendTime;
    }

    public ChatMessage(String id, String sender, String receiver, String senderName, String senderImg, String message, String type, Timestamp sendTime) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.senderName = senderName;
        this.senderImg = senderImg;
        this.message = message;
        this.type = type;
        this.sendTime = sendTime;
    }

    public ChatMessage() {
    }
}
