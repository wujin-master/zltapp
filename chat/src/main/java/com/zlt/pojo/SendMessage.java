package com.zlt.pojo;

public class SendMessage {
    private String head;
    private String data;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public SendMessage(String head, String data) {
        this.head = head;
        this.data = data;
    }

    public SendMessage() {
    }
}
