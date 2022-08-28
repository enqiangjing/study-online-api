package com.so.studyonline.entity;


public class SoDiscuss {

    private Integer id;
    private Integer topicId;
    private String topicType;
    private String content;
    private Integer userId;
    private java.sql.Timestamp discussTime;
    private java.sql.Timestamp updateTime;
    private java.sql.Timestamp deletedTime;
    private Integer status;
    private Integer floor;
    private int upTimes;
    private int reTimes;
    private String userName;
    private String userImg;

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUpTimes() {
        return upTimes;
    }

    public void setUpTimes(int upTimes) {
        this.upTimes = upTimes;
    }

    public int getReTimes() {
        return reTimes;
    }

    public void setReTimes(int reTimes) {
        this.reTimes = reTimes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }


    public String getTopicType() {
        return topicType;
    }

    public void setTopicType(String topicType) {
        this.topicType = topicType;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public java.sql.Timestamp getDiscussTime() {
        return discussTime;
    }

    public void setDiscussTime(java.sql.Timestamp discussTime) {
        this.discussTime = discussTime;
    }


    public java.sql.Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(java.sql.Timestamp updateTime) {
        this.updateTime = updateTime;
    }


    public java.sql.Timestamp getDeletedTime() {
        return deletedTime;
    }

    public void setDeletedTime(java.sql.Timestamp deletedTime) {
        this.deletedTime = deletedTime;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

}
