package com.zlt.pojo;

import java.sql.Timestamp;

public class ChatMessage {
    private String id;
    private String sender;
    private String receiver;
    private String message;
    private String type;
    private Timestamp sendTime;

    public ChatMessage(String id, String sender, String receiver, String message, String type, Timestamp sendTime) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.type = type;
        this.sendTime = sendTime;
    }

    public ChatMessage() {
    }

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
}
