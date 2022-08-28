package com.so.studyonline.entity;


public class SoConfig {

  private long id;
  private String key;
  private String value;
  private String name;
  private String group;
  private long isMust;
  private String about;
  private String status;

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }


  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getGroup() {
    return group;
  }

  public void setGroup(String group) {
    this.group = group;
  }


  public long getIsMust() {
    return isMust;
  }

  public void setIsMust(long isMust) {
    this.isMust = isMust;
  }


  public String getAbout() {
    return about;
  }

  public void setAbout(String about) {
    this.about = about;
  }

}
