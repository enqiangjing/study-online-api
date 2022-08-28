package com.so.studyonline.entity;


public class SoMenuPromise {

  private long id;
  private String menuKey;
  private String userRole;
  private long status;


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


  public String getUserRole() {
    return userRole;
  }

  public void setUserRole(String userRole) {
    this.userRole = userRole;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }

}
