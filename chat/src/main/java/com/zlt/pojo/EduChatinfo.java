package com.zlt.pojo;


public class EduChatinfo {

  private String id;
  private String sender;
  private String receiver;
  private String message;
  private String type;
  private java.sql.Timestamp sendTime;
  private String reverse1;
  private String reverse2;


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


  public java.sql.Timestamp getSendTime() {
    return sendTime;
  }

  public void setSendTime(java.sql.Timestamp sendTime) {
    this.sendTime = sendTime;
  }


  public String getReverse1() {
    return reverse1;
  }

  public void setReverse1(String reverse1) {
    this.reverse1 = reverse1;
  }


  public String getReverse2() {
    return reverse2;
  }

  public void setReverse2(String reverse2) {
    this.reverse2 = reverse2;
  }

}
