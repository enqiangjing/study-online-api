package com.so.studyonline.entity;


public class SoDiscussReply {

    private long id;
    private String content;
    private long discussId;
    private long topicId;
    private long userId;
    private java.sql.Timestamp replyTime;
    private java.sql.Timestamp updateTime;
    private java.sql.Timestamp deletedTime;
    private long status;
    private long floor;
    private long replyId;
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

    public long getTopicId() {
        return topicId;
    }

    public void setTopicId(long topicId) {
        this.topicId = topicId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public long getDiscussId() {
        return discussId;
    }

    public void setDiscussId(long discussId) {
        this.discussId = discussId;
    }


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }


    public java.sql.Timestamp getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(java.sql.Timestamp replyTime) {
        this.replyTime = replyTime;
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


    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }


    public long getFloor() {
        return floor;
    }

    public void setFloor(long floor) {
        this.floor = floor;
    }


    public long getReplyId() {
        return replyId;
    }

    public void setReplyId(long replyId) {
        this.replyId = replyId;
    }

}
