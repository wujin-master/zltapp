package com.zlt.pojo;

public class ChatOnLine {
    private String chatState;
    private String type;
    private String sender;

    public String getChatState() {
        return chatState;
    }

    public void setChatState(String chatState) {
        this.chatState = chatState;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public ChatOnLine(String chatState, String type, String sender) {
        this.chatState = chatState;
        this.type = type;
        this.sender = sender;
    }

    public ChatOnLine() {
    }
}
