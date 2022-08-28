package com.so.studyonline.entity;


public class SoMenulist extends SoMenuPromise {

  private long id;
  private String menuKey;
  private String menuName;
  private long status;
  private long menuLevel;
  private long parentMent;
  private long menuOrder;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getMenuKey() {
    return menuKey;
  }

  public void setMenuKey(String menuKey) {
    this.menuKey = menuKey;
  }


  public String getMenuName() {
    return menuName;
  }

  public void setMenuName(String menuName) {
    this.menuName = menuName;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }


  public long getMenuLevel() {
    return menuLevel;
  }

  public void setMenuLevel(long menuLevel) {
    this.menuLevel = menuLevel;
  }


  public long getParentMent() {
    return parentMent;
  }

  public void setParentMent(long parentMent) {
    this.parentMent = parentMent;
  }


  public long getMenuOrder() {
    return menuOrder;
  }

  public void setMenuOrder(long menuOrder) {
    this.menuOrder = menuOrder;
  }

}
