package com.zlt.pojo;


public class EduEmoji {

  private long id;
  private String code;
  private String urlMapper;
  private String reverse1;
  private String reverse2;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }


  public String getUrlMapper() {
    return urlMapper;
  }

  public void setUrlMapper(String urlMapper) {
    this.urlMapper = urlMapper;
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

  public EduEmoji(long id, String code, String urlMapper, String reverse1, String reverse2) {
    this.id = id;
    this.code = code;
    this.urlMapper = urlMapper;
    this.reverse1 = reverse1;
    this.reverse2 = reverse2;
  }

  public EduEmoji() {
  }
}
