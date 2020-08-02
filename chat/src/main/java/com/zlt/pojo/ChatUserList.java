package com.zlt.pojo;

import java.util.ArrayList;

public class ChatUserList {
    private ArrayList<EduUser> userArrayList;
    private String type;
    private String sender;

    public ArrayList<EduUser> getUserArrayList() {
        return userArrayList;
    }

    public void setUserArrayList(ArrayList<EduUser> userArrayList) {
        this.userArrayList = userArrayList;
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

    public ChatUserList(ArrayList<EduUser> userArrayList, String type, String sender) {
        this.userArrayList = userArrayList;
        this.type = type;
        this.sender = sender;
    }

    public ChatUserList() {
    }
}
